package lk.ijse.thogakadejakartaeebackend.bo.custom.impl;

import lk.ijse.thogakadejakartaeebackend.bo.custom.OrderBO;
import lk.ijse.thogakadejakartaeebackend.dto.OrderDTO;

import javax.sql.DataSource;

public class OrderBOImpl implements OrderBO {
    @Override
    public boolean saveOrder(OrderDTO orderDTO, DataSource source) {
        return false;
    }
}
