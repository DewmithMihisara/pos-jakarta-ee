package lk.ijse.thogakadejakartaeebackend.dao.custom.impl;

import lk.ijse.thogakadejakartaeebackend.dao.custom.CustomerDAO;
import lk.ijse.thogakadejakartaeebackend.dao.custom.impl.util.SQLUtil;
import lk.ijse.thogakadejakartaeebackend.entities.Customers;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<Customers> getAll(BasicDataSource basicDataSource) throws SQLException, ClassNotFoundException {
        ArrayList<Customers> allCustomers = new ArrayList<>();
        ResultSet rst = SQLUtil.execute(basicDataSource,"SELECT * FROM Customer");
        while (rst.next()) {
            allCustomers.add(new Customers(rst.getString(1), rst.getString(2), rst.getString(3)));
        }
        return allCustomers;
    }

    @Override
    public boolean save(Customers dto, BasicDataSource basicDataSource) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute(basicDataSource,"INSERT INTO Customer (id,name, address) VALUES (?,?,?)", dto.getId(), dto.getName(), dto.getAddress());
    }

    @Override
    public boolean update(Customers dto, BasicDataSource basicDataSource) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String s, BasicDataSource basicDataSource) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s, BasicDataSource basicDataSource) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Customers search(String s, BasicDataSource basicDataSource) throws SQLException, ClassNotFoundException {
        return null;
    }
//    @Override
//    public ArrayList<Customers> getAll(BasicDataSource dbcp) {
//        return null;
//    }
}
