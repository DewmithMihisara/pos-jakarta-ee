package lk.ijse.thogakadejakartaeebackend.api;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
@WebServlet(name = "OrderAPI", urlPatterns = "/order", loadOnStartup = 3)
public class OrderAPI extends HttpServlet {

}
