package lk.ijse.thogakadejakartaeebackend.dao.custom.impl;

import lk.ijse.thogakadejakartaeebackend.dao.custom.ItemDAO;
import lk.ijse.thogakadejakartaeebackend.dao.custom.impl.util.SQLUtil;
import lk.ijse.thogakadejakartaeebackend.entities.Item;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<Item> getAll(DataSource pool) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute(pool,"SELECT * FROM Item");
        ArrayList<Item> allItems = new ArrayList<>();
        while (rst.next()) {
            allItems.add(new Item(rst.getString(1), rst.getString(2), rst.getInt(3),rst.getBigDecimal(4)));
        }
        return allItems;
    }

    @Override
    public boolean save(Item dto, DataSource pool) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute(pool,"INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)", dto.getCode(), dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand());
    }

    @Override
    public boolean update(Item dto, DataSource pool) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String s, DataSource pool) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s, DataSource pool) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Item search(String s, DataSource pool) throws SQLException, ClassNotFoundException {
        return null;
    }
}
