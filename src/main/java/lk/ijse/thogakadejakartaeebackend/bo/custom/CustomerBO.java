package lk.ijse.thogakadejakartaeebackend.bo.custom;

import lk.ijse.thogakadejakartaeebackend.bo.SuperBO;
import lk.ijse.thogakadejakartaeebackend.dto.CustomerDTO;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {

    ArrayList<CustomerDTO> getAllCustomers(BasicDataSource dbcp) throws SQLException, ClassNotFoundException;

    boolean saveCustomer(CustomerDTO customerDTO, BasicDataSource dbcp) throws SQLException, ClassNotFoundException;
}
