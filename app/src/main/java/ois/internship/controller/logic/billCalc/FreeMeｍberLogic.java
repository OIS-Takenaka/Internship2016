package ois.internship.controller.logic.billCalc;


public class FreeMeｍberLogic implements BillCalcInjector {

    // 割引価格(0以上)
    private int billDiscountPrice = 0;

    // 送料
    private int billDeliverPrice = 0;

    // 合計金額
    private int billTotalPrice = 0;

    // 残りポイント数
    private int billRemainPoint = 0;

    //=================================================================
    // 無料会員の清算
    //=================================================================
    public FreeMeｍberLogic(int[] price, int havePoint, int nowDay, boolean usePointFlag) {

        // 清算前合計金額の計算
        int excludingTax = 0;
        for(int i=0; i < price.length; i++) {
            excludingTax += price[i];
        }
        if(excludingTax == 0) return;

        // 日にち割引の計算
        if(nowDay == 20 || nowDay == 30) {
            billDiscountPrice += (int)(excludingTax * 0.05);
        }

        // ポイント利用割引の計算
        if(usePointFlag){
            billDiscountPrice += 1000;
            billRemainPoint -= 1000;
        }

        // 税込金額の計算
        billTotalPrice = (int)((excludingTax - billDiscountPrice) * 1.08);

        // 税込金額から取得ポイントを計算
        if(!usePointFlag){
            billRemainPoint = (int)(billTotalPrice / 100);
        }

        // 税込金額から送料を計算
        if(billTotalPrice < 3000) {
            billDeliverPrice = 350;
            billTotalPrice += 350;
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
    public int getBillRemainPoint() {
        return billRemainPoint;
    }
}
