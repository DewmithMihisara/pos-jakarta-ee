package lk.ijse.thogakadejakartaeebackend.bo;

import lk.ijse.thogakadejakartaeebackend.bo.custom.impl.CustomerBOImpl;
import lk.ijse.thogakadejakartaeebackend.bo.custom.impl.ItemBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){

    }
    public static BOFactory getBoFactory() {
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes {
        CUSTOMER_BO, ITEM_BO, PURCHASE_ORDER_BO,
    }

    public <T extends SuperBO> T getBO(BOTypes boTypes) {
        switch (boTypes) {
            case CUSTOMER_BO:
                return (T) new CustomerBOImpl();
            case ITEM_BO:
                return (T) new ItemBOImpl();
            case PURCHASE_ORDER_BO:
//                return (T) new PurchaseOrderBOImpl();
            default:
                return null;
        }
    }
}
