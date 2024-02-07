package lk.ijse.thogakadejakartaeebackend.dao.custom.impl;

import lk.ijse.thogakadejakartaeebackend.dao.custom.OrderDAO;
import lk.ijse.thogakadejakartaeebackend.dao.custom.impl.util.SQLUtil;
import lk.ijse.thogakadejakartaeebackend.entities.Order;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public ArrayList<Order> getAll(DataSource pool) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Order dto, DataSource pool) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute(pool,"INSERT INTO `orders` (id, date, customerID) VALUES (?,?,?)", dto.getOrderId(), Date.valueOf(dto.getDate()), dto.getCustomerID());
    }

    @Override
    public boolean update(Order dto, DataSource pool) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String s, DataSource pool) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute(pool,"SELECT id FROM `Orders` WHERE id=?", s);
        return rst.next();
    }

    @Override
    public boolean delete(String s, DataSource pool) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Order search(String s, DataSource pool) throws SQLException, ClassNotFoundException {
        return null;
    }
}
