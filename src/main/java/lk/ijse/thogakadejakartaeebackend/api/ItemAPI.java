package lk.ijse.thogakadejakartaeebackend.api;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.thogakadejakartaeebackend.api.util.Validation;
import lk.ijse.thogakadejakartaeebackend.bo.BOFactory;
import lk.ijse.thogakadejakartaeebackend.bo.custom.ItemBO;
import lk.ijse.thogakadejakartaeebackend.dto.CustomerDTO;
import lk.ijse.thogakadejakartaeebackend.dto.ItemDTO;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ItemAPI", urlPatterns = "/item", loadOnStartup = 2)
public class ItemAPI extends HttpServlet {
    private DataSource pool;
    @Override
    public void init() throws ServletException {
        try {
            pool = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/pos");

        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
    ItemBO itemBO= BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ITEM_BO);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<ItemDTO> allItem = null;
        try {
            allItem = itemBO.getAllItem(pool);
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            System.out.println(e.getMessage());
        }
        resp.setContentType("application/json");
        Jsonb jsonb = JsonbBuilder.create();
        jsonb.toJson(allItem,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsonb jsonb = JsonbBuilder.create();
        ItemDTO itemDTO = jsonb.fromJson(req.getReader(), ItemDTO.class);

        String code = itemDTO.getCode();
        BigDecimal unitPrice = itemDTO.getUnitPrice();
        int qtyOnHand = itemDTO.getQtyOnHand();
        String description = itemDTO.getDescription();

        if(Validation.validateIdItm(code) && Validation.validateName(description) && Validation.validateNo(qtyOnHand) && Validation.validatePrice(unitPrice)){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Some data empty or invalid");
            return;
        }else {
            try {
                if (itemBO.saveItem(itemDTO,pool)){
                    resp.setStatus(HttpServletResponse.SC_CREATED);
                }else {
                    resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                }
            } catch (SQLException | ClassNotFoundException e) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
    }
}
