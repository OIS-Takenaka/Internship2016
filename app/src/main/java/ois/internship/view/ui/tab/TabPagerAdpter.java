package ois.internship.view.ui.tab;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

import ois.internship.R;
import ois.internship.view.fragment.CardsFragment;
import ois.internship.view.ui.Cards.CardFragment;
import ois.internship.view.ui.Cards.CardModel;

public class TabPagerAdpter extends PagerAdapter {

    Activity activity;
    int numOfTabs = 0;

    ArrayList<CardModel> data = new ArrayList<CardModel>();

    public TabPagerAdpter(Activity activity, int numOfTabs){
        this.activity = activity;
        this.numOfTabs = numOfTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "カテゴリ" + position;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View v = activity.getLayoutInflater().inflate(R.layout.component__grid, null);
        CardFragment cardsFragment = new CardsFragment(activity, (GridView)v.findViewById(R.id.card_frame));
        cardsFragment.setData(data);
        container.addView(v);
        return v;
    }

    public void setData(ArrayList<CardModel> data){
        this.data = data;
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
