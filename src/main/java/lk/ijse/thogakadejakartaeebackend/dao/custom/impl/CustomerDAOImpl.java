package lk.ijse.thogakadejakartaeebackend.dao.custom.impl;

import lk.ijse.thogakadejakartaeebackend.dao.CrudDAO;
import lk.ijse.thogakadejakartaeebackend.dao.custom.CustomerDAO;
import lk.ijse.thogakadejakartaeebackend.dao.custom.impl.util.SQLUtil;
import lk.ijse.thogakadejakartaeebackend.entities.Customers;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<Customers> getAll(DataSource pool) throws SQLException, ClassNotFoundException {
        ArrayList<Customers> allCustomers = new ArrayList<>();
        String sql= "SELECT * FROM Customer";
        try(Connection connection=pool.getConnection()){
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rst1 = pstm.executeQuery();
            while (rst1.next()){
                allCustomers.add(new Customers(rst1.getString(1), rst1.getString(2), rst1.getString(3)));
            }
        }
        return allCustomers;
    }

    @Override
    public boolean save(Customers dto, DataSource pool) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute(pool,"INSERT INTO Customer (id,name, address) VALUES (?,?,?)", dto.getId(), dto.getName(), dto.getAddress());
    }

    @Override
    public boolean update(Customers dto, DataSource pool) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute(pool,"UPDATE Customer SET name=?, address=? WHERE id=?", dto.getName(), dto.getAddress(), dto.getId());
    }

    @Override
    public boolean exist(String s, DataSource pool) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s, DataSource pool) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute(pool,"DELETE FROM customer WHERE id=?", s);
    }

    @Override
    public Customers search(String s, DataSource pool) throws SQLException, ClassNotFoundException {
        return null;
    }
}
