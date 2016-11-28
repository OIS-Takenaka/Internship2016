package ois.internship.view.activity;

import android.os.Bundle;
import android.view.View;

import com.beardedhen.androidbootstrap.BootstrapButton;

import ois.internship.R;
import ois.internship.view.fragment.ToDoListListFragment;
import ois.internship.view.ui.Lists.ListModel;

public class Page1 extends BaseActivity {

    BootstrapButton button;
    ToDoListListFragment toDoListFragment;

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

        toDoListFragment = new ToDoListListFragment(this);
        toDoListFragment.addData(new ListModel(null, "AAA"));
        toDoListFragment.addData(new ListModel(null, "BBB"));
        toDoListFragment.addData(new ListModel(null, "CCC"));


        /////////////////////////////////////////////////////////////////////////
    }
}
