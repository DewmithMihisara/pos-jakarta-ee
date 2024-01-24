package lk.ijse.thogakadejakartaeebackend.api;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(name = "CustomerAPI", urlPatterns = "/customers", loadOnStartup = 1)
public class CustomerAPI extends HttpServlet {

}
