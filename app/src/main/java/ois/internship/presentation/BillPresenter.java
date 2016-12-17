package ois.internship.presentation;

import android.content.Context;
import android.util.Log;

import ois.internship.model.repository.item.PurchasedItemRepository;
import ois.internship.presentation.logic.BillCalcManager;
import ois.internship.view.activity.BillPage;
import ois.internship.view.fragment.CustomListFragment;
import ois.internship.view.ui.Lists.ListModel;


public class BillPresenter extends BasePresenter {

    //=============================================================================
    // Variable
    //=============================================================================
    // Context
    private Context context;

    // Repository
    private PurchasedItemRepository cart = new PurchasedItemRepository();

    // View
    private BillPage view;


    //------------------------------------------------------------------------------
    // Option Variable
    //------------------------------------------------------------------------------
    // Fragment
    private CustomListFragment billListFragment;

    // calc logic
    private BillCalcManager billCalcManager;

    // using point flag
    private boolean usePointFlag = false;

    //=============================================================================
    // Constracter
    //=============================================================================
    public BillPresenter(Context context, BillPage view) {
        this.context = context;
        this.view = view;
    }

    //=============================================================================
    // public
    //=============================================================================
    @Override
    public void onCreate() {
        view.onRefresh();
    }

    @Override
    public void onRefresh() {
        if(cart == null) return;
        billListFragment = new CustomListFragment(view);
        for(int i=0; i < cart.dataSize(); i++){
            billListFragment.addData(new ListModel(cart.getItem(i).getImg(), cart.getItem(i).getName(), cart.getItem(i).getPrice() + "円"));
        }
        setAccounting();
    }

    public void setCart(PurchasedItemRepository cart) {
        this.cart = cart;
    }

    public void setUsePointFlag(boolean usePointFlag) {
        Log.i("DEBUG", "setUsePointFlag");
        this.usePointFlag = usePointFlag;
        view.onRefresh();
    }

    //=============================================================================
    // private
    //=============================================================================
    private void setAccounting(){
        billCalcManager = new BillCalcManager(cart, usePointFlag);
        view.billDiscountPrice.setText(billCalcManager.getBillDiscountPrice());
        view.billDeliverPrice.setText(billCalcManager.getBillDeliverPrice());
        view.billTotalPrice.setText(billCalcManager.getBillTotalPrice());
    }
}

