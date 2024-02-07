package lk.ijse.thogakadejakartaeebackend.dao.custom;

import lk.ijse.thogakadejakartaeebackend.dao.CrudDAO;
import lk.ijse.thogakadejakartaeebackend.entities.Item;

import javax.sql.DataSource;

public interface ItemDAO extends CrudDAO<Item,String, DataSource> {
}
