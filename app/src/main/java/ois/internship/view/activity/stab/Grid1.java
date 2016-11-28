package ois.internship.view.activity.stab;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import ois.internship.R;
import ois.internship.presentation.TestItemPresenter;
import ois.internship.presentation.TestPurchasePresenter;
import ois.internship.view.activity.BaseActivity;


public class Grid1 extends BaseActivity {

    // Presenter
    private static TestItemPresenter testItemList;
    private static TestPurchasePresenter testPurchaseList;

    // component
    public GridView gridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__grid1);

        // レイアウトロード
        findViewById(R.id.button).setOnClickListener(clickButton);
        gridView = (GridView)findViewById(R.id.card_frame);

        // presenter初期化
        testItemList = new TestItemPresenter(getBaseContext(), this);
        testPurchaseList = new TestPurchasePresenter(getBaseContext(), this);

        // presenter描画
        testItemList.onCreate();
        testPurchaseList.onCreate();

        /////////////////////////////////////////////////////////////////////////
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        testItemList = null;
        testPurchaseList = null;
    }
    public void onRefresh() {
        testItemList.onRefresh();
        testPurchaseList.onRefresh();
    }

    // ACTION
    private View.OnClickListener clickButton = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}
