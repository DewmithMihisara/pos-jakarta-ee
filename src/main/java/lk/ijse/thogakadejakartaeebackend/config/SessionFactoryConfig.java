package lk.ijse.thogakadejakartaeebackend.config;

import lk.ijse.thogakadejakartaeebackend.entities.Customers;
import lk.ijse.thogakadejakartaeebackend.entities.Item;
import lk.ijse.thogakadejakartaeebackend.entities.Order;
import lk.ijse.thogakadejakartaeebackend.entities.OrderDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class SessionFactoryConfig {
    private static SessionFactoryConfig sessionFactoryConfig;
    private final SessionFactory sessionFactory;
    private SessionFactoryConfig() {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();

        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.Properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        configuration
                .addAnnotatedClass(Customers.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(OrderDetail.class);
        sessionFactory=configuration.setProperties(properties).buildSessionFactory();
    }
    public static SessionFactoryConfig getInstance(){
        return (sessionFactoryConfig == null) ? sessionFactoryConfig = new SessionFactoryConfig() : sessionFactoryConfig;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}
