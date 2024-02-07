package lk.ijse.thogakadejakartaeebackend.dao.custom;

import lk.ijse.thogakadejakartaeebackend.dao.CrudDAO;
import lk.ijse.thogakadejakartaeebackend.entities.OrderDetail;

import javax.sql.DataSource;

public interface OrderDetailDAO extends CrudDAO<OrderDetail, String, DataSource> {
}
