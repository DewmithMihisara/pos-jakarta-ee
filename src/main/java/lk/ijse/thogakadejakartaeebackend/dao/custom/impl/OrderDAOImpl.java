package lk.ijse.thogakadejakartaeebackend.dao.custom.impl;

import lk.ijse.thogakadejakartaeebackend.dao.custom.OrderDAO;
import lk.ijse.thogakadejakartaeebackend.dao.custom.impl.util.SQLUtil;
import lk.ijse.thogakadejakartaeebackend.entities.Customers;
import lk.ijse.thogakadejakartaeebackend.entities.Order;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public ArrayList<Order> getAll(DataSource pool) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Order dto, DataSource pool) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute(pool,"INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)", dto.getOrderId(), Date.valueOf(dto.getDate()), dto.getCustomerID());
    }

    @Override
    public boolean update(Order dto, DataSource pool) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String s, DataSource pool) throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute(pool,"SELECT oid FROM `Orders` WHERE oid=?", s);
//        return rst.next();

        String sql = "SELECT oid FROM `Orders` WHERE oid=?";
        try(Connection connection=pool.getConnection()){
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1,s);
            ResultSet rst1 = pstm.executeQuery();
            return rst1.next();
        }
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
