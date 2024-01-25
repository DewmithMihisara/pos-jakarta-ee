package lk.ijse.thogakadejakartaeebackend.dao.custom;

import lk.ijse.thogakadejakartaeebackend.dao.CrudDAO;
import lk.ijse.thogakadejakartaeebackend.dao.SuperDAO;
import lk.ijse.thogakadejakartaeebackend.entities.Customers;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<Customers, String, BasicDataSource> {
}
