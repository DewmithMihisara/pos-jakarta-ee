package lk.ijse.thogakadejakartaeebackend.bo.custom.impl;

import lk.ijse.thogakadejakartaeebackend.bo.custom.OrderBO;
import lk.ijse.thogakadejakartaeebackend.dao.DAOFactory;
import lk.ijse.thogakadejakartaeebackend.dao.custom.ItemDAO;
import lk.ijse.thogakadejakartaeebackend.dao.custom.OrderDAO;
import lk.ijse.thogakadejakartaeebackend.dao.custom.OrderDetailDAO;
import lk.ijse.thogakadejakartaeebackend.dto.ItemDTO;
import lk.ijse.thogakadejakartaeebackend.dto.OrderDTO;
import lk.ijse.thogakadejakartaeebackend.dto.OrderDetailDTO;
import lk.ijse.thogakadejakartaeebackend.entities.Item;
import lk.ijse.thogakadejakartaeebackend.entities.Order;
import lk.ijse.thogakadejakartaeebackend.entities.OrderDetail;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class OrderBOImpl implements OrderBO {
    ItemDAO itemDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    OrderDAO orderDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    OrderDetailDAO orderDetailsDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDER_DETAILS);
    @Override
    public boolean saveOrder(OrderDTO orderDTO, DataSource pool) {
        try {
            Connection connection = pool.getConnection();

            if (orderDAO.exist(orderDTO.getId(),pool)){
                return false;
            }

            connection.setAutoCommit(false);

            Order orderEntity = new Order(orderDTO.getId(), orderDTO.getDate(), orderDTO.getCustomerId());
            boolean orderAdded = orderDAO.save(orderEntity,pool);
            if (!orderAdded) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            for (OrderDetailDTO odDTO : orderDTO.getOrderDetaisList()) {
                OrderDetail orderDetailsEntity = new OrderDetail(odDTO.getOrderId(), odDTO.getItemCode(), odDTO.getQty(), odDTO.getUnitPrice());
                boolean odAdded = orderDetailsDAO.save(orderDetailsEntity,pool);
                if (!odAdded) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }

                ItemDTO item = findItemByID(orderDetailsEntity.getItemCode(), pool);
                item.setQtyOnHand(item.getQtyOnHand() - orderDetailsEntity.getQty());
                boolean itemUpdate = itemDAO.update(new Item(item.getCode(), item.getDescription() ,item.getQtyOnHand(), item.getUnitPrice()),  pool);

                if (!itemUpdate) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }
            connection.commit();
            connection.setAutoCommit(true);
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
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
