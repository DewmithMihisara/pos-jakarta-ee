package lk.ijse.thogakadejakartaeebackend.api;

import jakarta.annotation.Resource;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.thogakadejakartaeebackend.api.util.Validation;
import lk.ijse.thogakadejakartaeebackend.bo.BOFactory;
import lk.ijse.thogakadejakartaeebackend.bo.custom.CustomerBO;
import lk.ijse.thogakadejakartaeebackend.dto.CustomerDTO;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "CustomerAPI", urlPatterns = "/customers", loadOnStartup = 1)
public class CustomerAPI extends HttpServlet {
    private DataSource pool;

    @Override
    public void init() throws ServletException {
        try {
            pool = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/pos");

        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
    CustomerBO customerBO= BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER_BO);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<CustomerDTO> allCustomers = null;
        try {
            allCustomers = customerBO.getAllCustomers(pool);
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            System.out.println(e.getMessage());
        }
        resp.setContentType("application/json");
        Jsonb jsonb = JsonbBuilder.create();
        jsonb.toJson(allCustomers,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsonb jsonb = JsonbBuilder.create();
        CustomerDTO customerDTO = jsonb.fromJson(req.getReader(), CustomerDTO.class);

        String id = customerDTO.getId();
        String name = customerDTO.getName();
        String address = customerDTO.getAddress();

        if(Validation.validateIdCus(id) && Validation.validateName(name) && Validation.validateAddress(address)){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Some data empty or invalid");
            return;
        }else {
            try {
                if (customerBO.saveCustomer(customerDTO,pool)){
                    resp.setStatus(HttpServletResponse.SC_CREATED);
                }else {
                    resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                }
            } catch (SQLException | ClassNotFoundException e) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsonb jsonb = JsonbBuilder.create();
        CustomerDTO customerDTO = jsonb.fromJson(req.getReader(), CustomerDTO.class);

        String id = customerDTO.getId();
        String name = customerDTO.getName();
        String address = customerDTO.getAddress();

        if(Validation.validateIdCus(id) && Validation.validateName(name) && Validation.validateAddress(address)){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Some data empty or invalid");
            return;
        }else {
            try {
                if (customerBO.updateCustomer(customerDTO,pool)){
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