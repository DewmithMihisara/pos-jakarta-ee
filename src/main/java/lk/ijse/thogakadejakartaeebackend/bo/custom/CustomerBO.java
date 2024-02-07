package lk.ijse.thogakadejakartaeebackend.bo.custom;

import lk.ijse.thogakadejakartaeebackend.bo.SuperBO;
import lk.ijse.thogakadejakartaeebackend.dto.CustomerDTO;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {

    ArrayList<CustomerDTO> getAllCustomers(DataSource pool) throws SQLException, ClassNotFoundException;

    boolean saveCustomer(CustomerDTO customerDTO, DataSource pool) throws SQLException, ClassNotFoundException;

    boolean updateCustomer(CustomerDTO customerDTO, DataSource pool) throws SQLException, ClassNotFoundException;

    boolean deleteCustomer(String id, DataSource pool) throws SQLException, ClassNotFoundException;
}
