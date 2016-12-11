package ois.internship.view.activity.stab;

import android.os.Bundle;
import android.view.View;

import com.beardedhen.androidbootstrap.BootstrapButton;

import ois.internship.R;
import ois.internship.view.activity.BaseActivity;
import ois.internship.view.fragment.CustomListFragment;
import ois.internship.view.ui.Lists.ListModel;

public class Page1 extends BaseActivity {

    BootstrapButton button;
    CustomListFragment toDoCustomListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__page1);

        /////////////////////////////////////////////////////////////////////////
        // ここから処理を書く
        /////////////////////////////////////////////////////////////////////////
        button = (BootstrapButton)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getBaseContext(), Page2.class));
                finish();
            }
        });

        toDoCustomListFragment = new CustomListFragment(this);
        toDoCustomListFragment.addData(new ListModel(null, "AAA", "111"));
        toDoCustomListFragment.addData(new ListModel(null, "BBB", "222"));
        toDoCustomListFragment.addData(new ListModel(null, "CCC", "333"));


        /////////////////////////////////////////////////////////////////////////
    }
}
