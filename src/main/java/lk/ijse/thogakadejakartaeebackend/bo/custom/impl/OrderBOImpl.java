package lk.ijse.thogakadejakartaeebackend.bo.custom.impl;

import lk.ijse.thogakadejakartaeebackend.bo.custom.OrderBO;
import lk.ijse.thogakadejakartaeebackend.dao.DAOFactory;
import lk.ijse.thogakadejakartaeebackend.dao.custom.ItemDAO;
import lk.ijse.thogakadejakartaeebackend.dao.custom.OrderDAO;
import lk.ijse.thogakadejakartaeebackend.dao.custom.OrderDetailDAO;
import lk.ijse.thogakadejakartaeebackend.dto.ItemDTO;
import lk.ijse.thogakadejakartaeebackend.dto.OrderDTO;
import lk.ijse.thogakadejakartaeebackend.entities.Item;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class OrderBOImpl implements OrderBO {
    ItemDAO itemDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    OrderDAO orderDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    OrderDetailDAO orderDetailsDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDER_DETAILS);
    @Override
    public boolean saveOrder(OrderDTO orderDTO, DataSource pool) {
        return false;
    }
    public ItemDTO findItemByID(String code, DataSource pool) {
        try {
            Item search = itemDAO.search(code,pool);
            return new ItemDTO(search.getCode(),search.getDescription(),search.getQtyOnHand(),search.getUnitPrice());
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find the Item " + code, e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
