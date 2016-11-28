package ois.internship.view.fragment;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.util.Log;

import java.util.ArrayList;

import ois.internship.R;
import ois.internship.view.ui.Lists.ListFragment;
import ois.internship.view.ui.Lists.ListLayout;
import ois.internship.view.ui.Lists.ListModel;

public class ToDoListListFragment extends ListFragment {

    FragmentTransaction fragmentTransaction;
    int fragmentTransactionFrame = R.id.to_do_list;


    public ToDoListListFragment(Activity activity){
        Log.i("DEBUG","ToDoLilstFragment");

        listLayout = new ListLayout(R.id.todo_list_view);
        fragmentTransaction = activity.getFragmentManager().beginTransaction();
        fragmentTransaction.add(fragmentTransactionFrame, this).commit();
    }

    public void setData(ArrayList<ListModel> data){
        for(int i=0;i < data.size(); i++) {
            addData(new ListModel(data.get(i).getImg(), data.get(i).getText()));
        }

    }
}
