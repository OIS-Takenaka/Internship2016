package ois.internship.view.fragment;

import android.app.Activity;
import android.widget.GridView;

import ois.internship.R;
import ois.internship.view.activity.BaseActivity;
import ois.internship.view.ui.Cards.CardFragment;
import ois.internship.view.ui.Cards.CardLayout;


public class CardsFragment extends CardFragment {

    public CardsFragment(BaseActivity activity, GridView gridView){
        super(activity, gridView, new CardLayout(R.id.card_frame));
    }

}
