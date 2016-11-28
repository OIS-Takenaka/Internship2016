package ois.internship.view.ui.Lists;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ListFragment extends android.app.Fragment implements OnRecyclerListener {

    private View view;
    private Context context = null;
    private RecyclerView recyclerView;
    private ListRecyclerAdapter listRecyclerAdapter;
    private RecyclerFragmentListener fragmentListener;
    protected ListLayout listLayout;
    private ArrayList<ListModel> data = new ArrayList<>();

    /**
     *
     * @param v
     * @param position
     */
    @Override
    public void onRecyclerClicked(View v, int position) {
        Log.i("DEBUG","onRecyclerClicked");
        Log.i("DEBUG","position: " + position);
    }

    /**
     *
     */
    public interface RecyclerFragmentListener {
        void onRecyclerEvent();
    }

    /**
     *
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("DEBUG","onAttach context");
        if (!(context instanceof RecyclerFragmentListener)) {
            //throw new UnsupportedOperationException("NOT SUPPORT!");
        } else {
            fragmentListener = (RecyclerFragmentListener) context;
        }
        this.context = context;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.i("DEBUG","onAttach activity");
        //if (!(activity instanceof RecyclerFragmentListener)) {
        //    throw new UnsupportedOperationException("NOT SUPPORT!");
        //} else {
        //  fragmentListener = (RecyclerFragmentListener) activity;
        //}
        this.context = activity;
    }

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("DEBUG","onCreateView");
        this.view = inflater.inflate(listLayout.pLayout, container, false);
        recyclerView = (RecyclerView)this.view.findViewById(listLayout.outFrame);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        return view;
    }

    /**
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("DEBUG","onActivityCreated");
        listRecyclerAdapter = new ListRecyclerAdapter(context, data, this, listLayout);
        recyclerView.setAdapter(listRecyclerAdapter);
    }

    /**
     * データ追加
     * @param listModel
     * @return
     */
    public ArrayList<ListModel> addData(ListModel listModel){
        Log.i("DEBUG","addData");
        data.add(listModel);
        return data;
    }
}


