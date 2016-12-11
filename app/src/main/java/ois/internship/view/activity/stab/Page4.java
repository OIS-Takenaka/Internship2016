package ois.internship.view.activity.stab;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.beardedhen.androidbootstrap.BootstrapButton;

import ois.internship.R;
import ois.internship.view.activity.BaseActivity;
import ois.internship.view.ui.tab.TabPagerAdpter;

public class Page4 extends BaseActivity {

    BootstrapButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__page4);

        /////////////////////////////////////////////////////////////////////////
        // ここから処理を書く
        /////////////////////////////////////////////////////////////////////////
        button = (BootstrapButton)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TabPagerAdpter adapter = new TabPagerAdpter(this, 10);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(adapter);

        /////////////////////////////////////////////////////////////////////////
    }
}
