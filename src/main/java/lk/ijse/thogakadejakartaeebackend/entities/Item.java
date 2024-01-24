package lk.ijse.thogakadejakartaeebackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {
    private String code;
    private String description;
    private int qtyOnHand;
    private BigDecimal unitPrice;
}
