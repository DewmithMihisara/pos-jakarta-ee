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
import lk.ijse.thogakadejakartaeebackend.bo.custom.OrderBO;
import lk.ijse.thogakadejakartaeebackend.dto.OrderDTO;
import lk.ijse.thogakadejakartaeebackend.dto.OrderDetailDTO;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "OrderAPI", urlPatterns = "/order", loadOnStartup = 3)
public class OrderAPI extends HttpServlet {
    private DataSource source;
    @Override
    public void init() throws ServletException {
        try {
            source = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/pos");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    OrderBO placeOrderBO = BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PURCHASE_ORDER_BO);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsonb jsonb = JsonbBuilder.create();
        OrderDTO orderDTO = jsonb.fromJson(req.getReader(), OrderDTO.class);
        String id = orderDTO.getId();
        LocalDate date = orderDTO.getDate();
        String customerId = orderDTO.getCustomerId();
        List<OrderDetailDTO> detaisList = orderDTO.getOrderDetaisList();


        if(Validation.validateIdOrder(id) && Validation.validateDate(date) && Validation.validateIdCus(customerId) && Validation.validateOrderDetails(detaisList)){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID is empty or invalid");
            return;
        } else {
            try {
                boolean saveOrder = placeOrderBO.saveOrder(new OrderDTO(id, date, customerId, detaisList),source);
                if (saveOrder) {
                    resp.setStatus(HttpServletResponse.SC_CREATED);
                    resp.getWriter().write("Added order successfully");
                }else {
                    resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to save the order");
                    System.out.println("fail in save");
                }

            }catch (Exception e){
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to save the order");
            }
        }
    }
}
