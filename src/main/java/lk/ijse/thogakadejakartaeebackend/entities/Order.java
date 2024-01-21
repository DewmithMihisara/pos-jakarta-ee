package lk.ijse.thogakadejakartaeebackend.entities;

import com.google.protobuf.Timestamp;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;
    @Column(name = "order_description")
    private String description;
    @CreationTimestamp
    @Column(name = "order_date")
    private Timestamp orderDateTime;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customer;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "order")
    private List<OrderDetail> orderDetails = new ArrayList<>();
}
