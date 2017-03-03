package ois.internship.presentation.logic;

import ois.internship.model.entity.AccountEntity;
import ois.internship.model.repository.item.ItemRepository;
import ois.internship.presentation.logic.billCalc.BillCalcInjector;
import ois.internship.presentation.logic.billCalc.FreeMeｍberLogic;
import ois.internship.presentation.logic.billCalc.PayMeｍberLogic;

public class BillCalcManager {

    int billDiscountPrice = 0;
    int billDeliverPrice = 0;
    int billTotalPrice = 0;
    int billRemainPoint = 0;
    BillCalcInjector logic;

    public BillCalcManager(ItemRepository cart, boolean usePointFlag){
        int[] price = new int[cart.dataSize()];
        for(int i=0 ; i<cart.dataSize(); i++) price[i]  = cart.getItem(i).getPrice();

        // 清算方法の切り替え
        if(cart.getAccount() == AccountEntity.FREE_MEMBER) {
            logic = new PayMeｍberLogic(price, cart.getPoint(), cart.getDay(), usePointFlag);
        } else {
            logic = new FreeMeｍberLogic(price, cart.getPoint(), cart.getDay(), usePointFlag);
        }

        billDiscountPrice = logic.getBillDiscountPrice();
        billDeliverPrice = logic.getBillDeliverPrice();
        billTotalPrice = logic.getBillTotalPrice();
        billRemainPoint = logic.getBillRemainPoint();
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
    public String getBillRemainPoint() {
        return billRemainPoint + "ポイント ";
    }

}
