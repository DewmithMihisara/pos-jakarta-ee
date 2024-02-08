package lk.ijse.thogakadejakartaeebackend.dao.custom.impl;

import lk.ijse.thogakadejakartaeebackend.dao.custom.ItemDAO;
import lk.ijse.thogakadejakartaeebackend.dao.custom.impl.util.SQLUtil;
import lk.ijse.thogakadejakartaeebackend.entities.Item;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<Item> getAll(DataSource pool) throws SQLException, ClassNotFoundException {
        ArrayList<Item> allItems = new ArrayList<>();
        String sql= "SELECT * FROM Item";
        try(Connection connection=pool.getConnection()){
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rst1 = pstm.executeQuery();
            while (rst1.next()){
                allItems.add(new Item(rst1.getString(1), rst1.getString(2), rst1.getInt(3),rst1.getBigDecimal(4)));
            }
        }
        return allItems;
    }

    @Override
    public boolean save(Item dto, DataSource pool) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute(pool,"INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)", dto.getCode(), dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand());
    }

    @Override
    public boolean update(Item dto, DataSource pool) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute(pool,"UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?", dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand(), dto.getCode());
    }

    @Override
    public boolean exist(String s, DataSource pool) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s, DataSource pool) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute(pool,"DELETE FROM Item WHERE code=?", s);
    }

    @Override
    public Item search(String s, DataSource pool) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute(pool,"SELECT * FROM Item WHERE code=?", s);
        if (rst.next()) {
            return new Item(rst.getString(1), rst.getString(2),  rst.getInt(3),rst.getBigDecimal(4));
        }
        return null;
    }
}
