package ois.internship.view.fragment;

import android.util.Log;
import android.widget.AbsListView;
import android.widget.GridView;

import ois.internship.R;
import ois.internship.view.activity.BaseActivity;
import ois.internship.view.ui.Cards.CardFragment;
import ois.internship.view.ui.Cards.CardLayout;


public class CardsFragment extends CardFragment {

    public CardsFragment(BaseActivity activity, GridView gridView){
        super(activity, gridView, new CardLayout(R.id.card_frame));

        gridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                Log.i("Debug","onScrollStateChanged");
                switch (scrollState){
                    case SCROLL_STATE_FLING:
                        int first = view.getFirstVisiblePosition();
                        int count = view.getChildCount();
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                //Log.i("Debug","onScroll");
            }
        });
    }

}
