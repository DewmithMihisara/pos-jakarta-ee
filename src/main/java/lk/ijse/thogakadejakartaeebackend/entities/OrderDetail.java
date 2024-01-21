package lk.ijse.thogakadejakartaeebackend.entities;

import jakarta.persistence.*;
import lk.ijse.thogakadejakartaeebackend.embedded.OrderDetailPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @EmbeddedId
    private OrderDetailPK orderDetailPK;
    @Column(name = "order_quantity")
    private int qty;
    @Column(name = "order_price")
    private double price;
    @ManyToOne
    @JoinColumn(name = "order_id",
            referencedColumnName = "order_id",
            insertable = false,
            updatable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "item_id",
            referencedColumnName = "item_id",
            insertable = false,
            updatable = false)
    private Item item;
}
