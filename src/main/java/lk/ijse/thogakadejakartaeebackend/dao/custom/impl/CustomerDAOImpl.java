package lk.ijse.thogakadejakartaeebackend.dao.custom.impl;

import jakarta.annotation.Resource;
import lk.ijse.thogakadejakartaeebackend.dao.custom.CustomerDAO;
import lk.ijse.thogakadejakartaeebackend.dao.custom.impl.util.SQLUtil;
import lk.ijse.thogakadejakartaeebackend.entities.Customers;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<Customers> getAll(DataSource pool) throws SQLException, ClassNotFoundException {
        ArrayList<Customers> allCustomers = new ArrayList<>();
        ResultSet rst = SQLUtil.execute(pool,"SELECT * FROM customer");
        while (rst.next()) {
            allCustomers.add(new Customers(rst.getString(1), rst.getString(2), rst.getString(3)));
        }
        return allCustomers;
    }

    @Override
    public boolean save(Customers dto, DataSource pool) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute(pool,"INSERT INTO Customer (id,name, address) VALUES (?,?,?)", dto.getId(), dto.getName(), dto.getAddress());

    }

    @Override
    public boolean update(Customers dto, DataSource pool) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String s, DataSource pool) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s, DataSource pool) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Customers search(String s, DataSource pool) throws SQLException, ClassNotFoundException {
        return null;
    }
}
