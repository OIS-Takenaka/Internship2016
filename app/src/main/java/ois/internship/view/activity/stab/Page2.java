package ois.internship.view.activity.stab;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.beardedhen.androidbootstrap.BootstrapButton;

import java.util.ArrayList;

import ois.internship.R;
import ois.internship.view.activity.BaseActivity;
import ois.internship.view.fragment.CardsFragment;
import ois.internship.view.ui.Cards.CardModel;

public class Page2 extends BaseActivity {

    // Fragmnt
    CardsFragment cardsFragment;

    BootstrapButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__page2);

        /////////////////////////////////////////////////////////////////////////
        // ここから処理を書く
        /////////////////////////////////////////////////////////////////////////
        button = (BootstrapButton)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //transitionPage(Page1.class, null);
                finish();
            }
        });

        ArrayList<CardModel> data = new ArrayList<CardModel>();
        data.add(new CardModel(null, "AAAAA", "aaaaa", false));
        data.add(new CardModel(null, "BBBBB", "bbbbb", true));
        data.add(new CardModel(null, "CCCCC", "ccccc", true));

        //GridView gridView = (GridView) findViewById(R.id.card_frame);
        //CardAdapter adapter = new CardAdapter(getBaseContext(), data, cardLayout);
        //gridView.setAdapter(adapter);

        cardsFragment = new CardsFragment(this, (GridView)findViewById(R.id.card_frame));
        cardsFragment.setData(data);

        /////////////////////////////////////////////////////////////////////////
    }
}
