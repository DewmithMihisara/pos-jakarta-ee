package lk.ijse.thogakadejakartaeebackend.dao.custom;

import lk.ijse.thogakadejakartaeebackend.dao.CrudDAO;
import lk.ijse.thogakadejakartaeebackend.entities.Order;

import javax.sql.DataSource;

public interface OrderDAO extends CrudDAO<Order, String, DataSource> {
}
