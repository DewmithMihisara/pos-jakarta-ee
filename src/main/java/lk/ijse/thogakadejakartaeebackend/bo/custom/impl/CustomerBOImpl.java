package lk.ijse.thogakadejakartaeebackend.bo.custom.impl;

import jakarta.annotation.Resource;
import lk.ijse.thogakadejakartaeebackend.bo.custom.CustomerBO;
import lk.ijse.thogakadejakartaeebackend.dao.DAOFactory;
import lk.ijse.thogakadejakartaeebackend.dao.custom.CustomerDAO;
import lk.ijse.thogakadejakartaeebackend.dto.CustomerDTO;
import lk.ijse.thogakadejakartaeebackend.entities.Customers;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;

import static lk.ijse.thogakadejakartaeebackend.dao.DAOFactory.DAOTypes.CUSTOMER;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO= DAOFactory.getDAOFactory().getDAO(CUSTOMER);
    @Override
    public ArrayList<CustomerDTO> getAllCustomers(DataSource pool) throws SQLException, ClassNotFoundException {
        ArrayList<Customers> all = customerDAO.getAll(pool);
        ArrayList<CustomerDTO> arrayList= new ArrayList<>();
        for (Customers c : all) {
            arrayList.add(new CustomerDTO(c.getId(),c.getName(),c.getAddress()));
        }
        return arrayList;
    }

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO,DataSource pool) throws SQLException, ClassNotFoundException {
        return customerDAO.save( new Customers(customerDTO.getId(), customerDTO.getName(),customerDTO.getAddress()),pool);
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO, DataSource pool) throws SQLException, ClassNotFoundException {
        return customerDAO.update( new Customers(customerDTO.getId(), customerDTO.getName(),customerDTO.getAddress()),pool);
    }

    @Override
    public boolean deleteCustomer(String id, DataSource pool) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id,pool);
    }
}
