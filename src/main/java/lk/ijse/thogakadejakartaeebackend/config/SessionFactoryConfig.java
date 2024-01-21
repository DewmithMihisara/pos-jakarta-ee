package lk.ijse.thogakadejakartaeebackend.config;

import lk.ijse.thogakadejakartaeebackend.entities.Customers;
import lk.ijse.thogakadejakartaeebackend.entities.Item;
import lk.ijse.thogakadejakartaeebackend.entities.Order;
import lk.ijse.thogakadejakartaeebackend.entities.OrderDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {
    private static SessionFactoryConfig sessionFactoryConfig;
    private final SessionFactory sessionFactory;
    private SessionFactoryConfig() {
        sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Customers.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(OrderDetail.class)
                .buildSessionFactory();
    }
    public static SessionFactoryConfig getInstance(){
        return (sessionFactoryConfig == null) ? sessionFactoryConfig = new SessionFactoryConfig() : sessionFactoryConfig;
    }
    public Session getSessionFactory(){
        return sessionFactory.openSession();
    }
}
