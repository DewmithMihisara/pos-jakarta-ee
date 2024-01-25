package lk.ijse.thogakadejakartaeebackend.bo.custom.impl;

import lk.ijse.thogakadejakartaeebackend.bo.custom.CustomerBO;
import lk.ijse.thogakadejakartaeebackend.dao.DAOFactory;
import lk.ijse.thogakadejakartaeebackend.dao.custom.CustomerDAO;
import lk.ijse.thogakadejakartaeebackend.dto.CustomerDTO;
import lk.ijse.thogakadejakartaeebackend.entities.Customers;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.SQLException;
import java.util.ArrayList;

import static lk.ijse.thogakadejakartaeebackend.dao.DAOFactory.DAOTypes.CUSTOMER;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO= DAOFactory.getDAOFactory().getDAO(CUSTOMER);
    @Override
    public ArrayList<CustomerDTO> getAllCustomers(BasicDataSource dbcp) throws SQLException, ClassNotFoundException {
        ArrayList<Customers> all = customerDAO.getAll(dbcp);
        ArrayList<CustomerDTO> arrayList= new ArrayList<>();
        for (Customers c : all) {
            arrayList.add(new CustomerDTO(c.getId(),c.getName(),c.getAddress()));
        }
        return arrayList;
    }
}
