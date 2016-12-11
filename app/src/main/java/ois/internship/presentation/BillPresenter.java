package ois.internship.presentation;

import android.content.Context;

import java.util.Stack;

import ois.internship.model.repository.item.CategoryRepository;
import ois.internship.model.repository.item.ItemRepository;
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
    private CategoryRepository category = new CategoryRepository();
    private ItemRepository data = new ItemRepository();

    // View
    private BillPage view;

    private Stack<String> getCategory = new Stack<>();

    //------------------------------------------------------------------------------
    // Option Variable
    //------------------------------------------------------------------------------
    // Fragment
    private CustomListFragment billListFragment;


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
        billListFragment = new CustomListFragment(view);
        billListFragment.addData(new ListModel(null, "AAA"));
        billListFragment.addData(new ListModel(null, "BBB"));
        billListFragment.addData(new ListModel(null, "CCC"));
        //TabPagerAdpter adapter = new TabPagerAdpter(view, data.size());
        //if(data.size() > 0)adapter.setData(data.get(0).getCardData());
    }


    //=============================================================================
    // private
    //=============================================================================
}

