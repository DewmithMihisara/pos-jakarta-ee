package lk.ijse.thogakadejakartaeebackend.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetail implements Serializable {
    private String orderId;
    private String itemCode;
    private int qty;
    private double price;
}
