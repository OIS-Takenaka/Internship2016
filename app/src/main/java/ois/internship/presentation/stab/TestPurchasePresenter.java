package ois.internship.presentation.stab;

import android.content.Context;

import java.util.ArrayList;

import ois.internship.model.entity.ItemEntity;
import ois.internship.presentation.BasePresenter;
import ois.internship.view.BaseViewInterface;
import ois.internship.view.activity.stab.Grid1;
import ois.internship.view.fragment.CustomListFragment;
import ois.internship.view.ui.If.ListsInterface;
import ois.internship.view.ui.Lists.ListModel;


public class TestPurchasePresenter extends BasePresenter implements ListsInterface, BaseViewInterface {

    //=============================================================================
    // Variable
    //=============================================================================
    // Context
    private Context context;

    // Entity
    ArrayList<ItemEntity> itemList = new ArrayList();

    // View
    private Grid1 view;

    //------------------------------------------------------------------------------
    // Option Variable
    //------------------------------------------------------------------------------
    // Fragmnt
    public CustomListFragment toDoCustomListFragment;

    //=============================================================================
    // Constracter
    //=============================================================================
    public TestPurchasePresenter(Context context, Grid1 view){
        this.context = context;
        this.view = view;
        loadMock();
    }

    //=============================================================================
    // public
    //=============================================================================
    @Override
    public void onCreate() {
        // リスト
        toDoCustomListFragment = new CustomListFragment(view);
        toDoCustomListFragment.setData(getListData());
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public ArrayList<ListModel> getListData() {
        ArrayList<ListModel> listData = new ArrayList();
        for(int i=0; i < itemList.size(); i++) {
            listData.add(new ListModel(itemList.get(i).getImg(), itemList.get(i).getName()));
        }
        return listData;
    }

    //=============================================================================
    // private
    //=============================================================================
    // モックデータ
    private void loadMock(){
        itemList.add(new ItemEntity(null, "AAA"));
        itemList.add(new ItemEntity(null, "BBB"));
        itemList.add(new ItemEntity(null, "CCC"));
        itemList.add(new ItemEntity(null, "DDD"));
        itemList.add(new ItemEntity(null, "EEE"));
        itemList.add(new ItemEntity(null, "FFF"));
        itemList.add(new ItemEntity(null, "GGG"));
        itemList.add(new ItemEntity(null, "HHH"));
        itemList.add(new ItemEntity(null, "III"));
        itemList.add(new ItemEntity(null, "JJJ"));
        itemList.add(new ItemEntity(null, "KKK"));
        itemList.add(new ItemEntity(null, "LLL"));
        itemList.add(new ItemEntity(null, "MMM"));
    }
}
