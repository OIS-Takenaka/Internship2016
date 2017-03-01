package ois.internship.presentation.logic;

import ois.internship.model.repository.item.ItemRepository;
import ois.internship.presentation.logic.billCalc.PayMeｍberLogic;

public class BillCalcManager {

    int billDiscountPrice = 0;
    int billDeliverPrice = 0;
    int billTotalPrice = 0;

    public BillCalcManager(ItemRepository cart, boolean usePointFlag){
        int[] price = new int[cart.dataSize()];
        for(int i=0 ; i<cart.dataSize(); i++) price[i]  = cart.getItem(i).getPrice();

        PayMeｍberLogic logic = new PayMeｍberLogic(price, usePointFlag);;

        if(false) {
            // logic = new FreeMeｍberLogic(price, usePointFlag);
        } else {
            // logic = new PayMeｍberLogic(price, usePointFlag);
        }

        billDiscountPrice = logic.getBillDiscountPrice();
        billDeliverPrice = logic.getBillDeliverPrice();
        billTotalPrice = logic.getBillTotalPrice();
    }

    public String getBillDiscountPrice() {
        return billDiscountPrice + "円";
    }
    public String getBillDeliverPrice() {
        return billDeliverPrice + "円";
    }
    public String getBillTotalPrice() {
        return billTotalPrice + "円 ";
    }
}
