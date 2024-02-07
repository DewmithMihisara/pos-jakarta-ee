package lk.ijse.thogakadejakartaeebackend.api.util;

import lk.ijse.thogakadejakartaeebackend.dto.OrderDetailDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Validation {
    public static boolean validateIdCus(String id){
        return id.matches("[C][0-9]{3}");
    }

    public static boolean validateName(String name){
        return name.matches("[A-Za-z ]{3,}");
    }

    public static boolean validateAddress(String address){
        return address.matches("[A-Za-z0-9 ,]{3,}");
    }
    public static boolean validateIdItm(String id){
        return id.matches("[I][0-9]{3}");
    }

    public static boolean validateNo(int qtyOnHand) {
        return qtyOnHand >= 0;
    }

    public static boolean validatePrice(BigDecimal unitPrice) {
        return unitPrice.compareTo(new BigDecimal(0)) >= 0;
    }

    public static boolean validateOrderDetails(List<OrderDetailDTO> detaisList) {
        return detaisList.size() > 0;
    }

    public static boolean validateIdOrder(String id) {
        return id.matches("[O][0-9]{3}");
    }

    public static boolean validateDate(LocalDate date) {
        return date == null;
    }
}
