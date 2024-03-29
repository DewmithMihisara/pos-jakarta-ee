package lk.ijse.thogakadejakartaeebackend.bo.custom;

import lk.ijse.thogakadejakartaeebackend.bo.SuperBO;
import lk.ijse.thogakadejakartaeebackend.dto.CustomerDTO;
import lk.ijse.thogakadejakartaeebackend.dto.ItemDTO;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    ArrayList<ItemDTO> getAllItem(DataSource pool) throws SQLException, ClassNotFoundException;

    boolean saveItem(ItemDTO itemDTO, DataSource pool) throws SQLException, ClassNotFoundException;

    boolean updateItem(ItemDTO itemDTO, DataSource pool) throws SQLException, ClassNotFoundException;

    boolean deleteItem(String code, DataSource pool) throws SQLException, ClassNotFoundException;
}
