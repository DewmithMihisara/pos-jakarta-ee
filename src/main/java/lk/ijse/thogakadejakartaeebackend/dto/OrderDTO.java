package lk.ijse.thogakadejakartaeebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class OrderDTO {
    private String id;
    private LocalDate date;
    private String customerId;
    List<OrderDetailDTO> orderDetaisList;
}
