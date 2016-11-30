package ois.internship.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import ois.internship.R;
import ois.internship.presentation.ItemPresenter;

public class ItemPage extends BaseActivity {

    private ItemPresenter itemPresenter;
    public ViewPager viewPager;
    public TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__item_page);

        /////////////////////////////////////////////////////////////////////////
        // ここから処理を書く
        /////////////////////////////////////////////////////////////////////////

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        // presenter初期化
        itemPresenter = new ItemPresenter(getBaseContext(), this);

        // presenter描画
        itemPresenter.onCreate();

        /////////////////////////////////////////////////////////////////////////
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        itemPresenter = null;
    }
    public void onRefresh() {
        itemPresenter.onRefresh();
    }
}
