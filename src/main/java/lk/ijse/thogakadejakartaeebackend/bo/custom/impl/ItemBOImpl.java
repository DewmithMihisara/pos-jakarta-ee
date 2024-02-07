package lk.ijse.thogakadejakartaeebackend.bo.custom.impl;

import lk.ijse.thogakadejakartaeebackend.bo.custom.ItemBO;
import lk.ijse.thogakadejakartaeebackend.dao.DAOFactory;
import lk.ijse.thogakadejakartaeebackend.dao.custom.ItemDAO;
import lk.ijse.thogakadejakartaeebackend.dto.CustomerDTO;
import lk.ijse.thogakadejakartaeebackend.dto.ItemDTO;
import lk.ijse.thogakadejakartaeebackend.entities.Item;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    @Override
    public ArrayList<ItemDTO> getAllItem(DataSource pool) throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> list = new ArrayList<>();
        ArrayList<Item> all = itemDAO.getAll(pool);
        for (Item i : all) {
            list.add(new ItemDTO(i.getCode(), i.getDescription(), i.getQtyOnHand(), i.getUnitPrice()));
        }
        return list;
    }

    @Override
    public boolean saveItem(ItemDTO itemDTO, DataSource pool) throws SQLException, ClassNotFoundException {
        return itemDAO.save(new Item(itemDTO.getCode(), itemDTO.getDescription(), itemDTO.getQtyOnHand(), itemDTO.getUnitPrice()),pool);
    }
}
