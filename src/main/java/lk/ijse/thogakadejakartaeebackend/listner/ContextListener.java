package lk.ijse.thogakadejakartaeebackend.listner;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.apache.commons.dbcp2.BasicDataSource;

@WebListener(value = "seveletContextListener")
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext is initialized");

        BasicDataSource dbcp = new BasicDataSource();
        dbcp.setUsername("root");
        dbcp.setPassword("MYsql@123@");
        dbcp.setUrl("jdbc:mysql://localhost:3306/gdse66_hello");
        dbcp.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dbcp.setInitialSize(2);
        dbcp.setMaxTotal(5);

        ServletContext sc = sce.getServletContext();
        sc.setAttribute("dbcp",dbcp);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
