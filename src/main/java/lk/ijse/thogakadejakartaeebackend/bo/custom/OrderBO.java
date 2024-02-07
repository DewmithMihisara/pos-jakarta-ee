package lk.ijse.thogakadejakartaeebackend.bo.custom;

import lk.ijse.thogakadejakartaeebackend.bo.SuperBO;
import lk.ijse.thogakadejakartaeebackend.dto.OrderDTO;

import javax.sql.DataSource;

public interface OrderBO extends SuperBO {
    boolean saveOrder(OrderDTO orderDTO, DataSource source);
}
