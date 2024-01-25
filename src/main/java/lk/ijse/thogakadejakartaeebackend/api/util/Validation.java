package lk.ijse.thogakadejakartaeebackend.api.util;

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
}
