package lk.ijse.thogakadejakartaeebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderJoin {
    private String orderID;
    private LocalDate orderDate;
    private String customerID;
    private String itemCode;
    private int itemQty;
    private double unitPrice;
}
