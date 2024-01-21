package lk.ijse.thogakadejakartaeebackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int id;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "item_quantity")
    private int qty;
    @Column(name = "unit_price")
    private double unitPrice;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =  "item")
    private List<OrderDetail> orderDetails = new ArrayList<>();
}
