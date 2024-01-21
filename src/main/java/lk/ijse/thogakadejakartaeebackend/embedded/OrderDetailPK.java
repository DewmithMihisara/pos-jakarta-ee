package lk.ijse.thogakadejakartaeebackend.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class OrderDetailPK implements Serializable {
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "item_id")
    private int itemId;

}