package lk.ijse.thogakadejakartaeebackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Order implements Serializable {
    private String orderId;
    private LocalDate date;
    private String customerID;
}
