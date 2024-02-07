package lk.ijse.thogakadejakartaeebackend.api.util;

import java.math.BigDecimal;

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
}
