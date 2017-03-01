package ois.internship.presentation.logic.billCalc;

import ois.internship.presentation.logic.injector.BillCalcInjectorIf;

public class PayMeｍberLogic implements BillCalcInjectorIf{

    // 現在日付
    private int day = 1;

    // 割引価格
    private int billDiscountPrice = 0;

    // 送料
    private int billDeliverPrice = 0;

    // 合計金額
    private int billTotalPrice = 0;

    public PayMeｍberLogic(int[] price, boolean usePointFlag) {

        billTotalPrice = 0;

        if(usePointFlag){
            billDiscountPrice = -1000;
        } else {
            billDiscountPrice = 0;
        }

        for(int i=0; i < price.length; i++) {
            billTotalPrice += price[i];
        }

        if(billTotalPrice < 3000) {
            billDeliverPrice = 350;
        } else {
            billDeliverPrice = 0;
        }

        billTotalPrice += billDiscountPrice;
        billTotalPrice += billDeliverPrice;
    }

    public int getBillDiscountPrice() {
        return billDiscountPrice;
    }
    public int getBillDeliverPrice() {
        return billDeliverPrice;
    }
    public int getBillTotalPrice() {
        return billTotalPrice;
    }
}
