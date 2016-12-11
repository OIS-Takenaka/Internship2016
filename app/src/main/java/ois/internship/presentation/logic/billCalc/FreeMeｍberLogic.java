package ois.internship.presentation.logic.billCalc;


public class FreeMeｍberLogic {

    // 割引価格
    private int billDiscountPrice = 0;

    // 送料
    private int billDeliverPrice = 0;

    // 合計金額
    private int billTotalPrice = 0;

    public FreeMeｍberLogic(int[] price, boolean usePointFlag) {

        if(usePointFlag){
            billDiscountPrice = -1000;
        } else {
            billDiscountPrice = 0;
        }

        for(int i=0; i < price.length; i++) {
            billTotalPrice += price[i];
        }
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
