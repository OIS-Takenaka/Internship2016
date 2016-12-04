package ois.internship.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import ois.internship.R;
import ois.internship.presentation.BillPresenter;
import ois.internship.presentation.ItemPresenter;

public class BillPage extends BaseActivity {

    private BillPresenter billPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__bill_page);

        /////////////////////////////////////////////////////////////////////////
        // ここから処理を書く
        /////////////////////////////////////////////////////////////////////////

        // presenter初期化
        billPresenter = new BillPresenter(getBaseContext(), this);

        // presenter描画
        billPresenter.onCreate();

        /////////////////////////////////////////////////////////////////////////
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        billPresenter = null;
    }

    public void onRefresh() {
        billPresenter.onRefresh();
    }
}
