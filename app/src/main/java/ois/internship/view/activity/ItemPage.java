package ois.internship.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;

import ois.internship.R;
import ois.internship.controller.ItemPresenter;

public class ItemPage extends BaseActivity {

    private ItemPresenter itemPresenter;

    // pager
    public ViewPager viewPager;
    public TabLayout tabLayout;

    // sideber
    public ImageView selectItemImg;
    public TextView selectItemCategory;
    public TextView selectItemTitle;
    public TextView selectItemPrice;
    public LinearLayout selectItemPriceLay;
    public BootstrapButton selectItemSubmitButton;
    public BootstrapButton selectItemBillButton;
    public BootstrapButton changeDayButton;
    public BootstrapButton changeMemberButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__item_page);

        /////////////////////////////////////////////////////////////////////////
        // ここから処理を書く
        /////////////////////////////////////////////////////////////////////////

        getIntentData();

        // pagerのセット
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        // sideberのセット
        selectItemImg = (ImageView) findViewById(R.id.select_item_img);
        selectItemCategory = (TextView) findViewById(R.id.select_item_category);
        selectItemTitle = (TextView) findViewById(R.id.select_item_title);
        selectItemPrice = (TextView) findViewById(R.id.select_item_price);
        selectItemPriceLay = (LinearLayout) findViewById(R.id.select_item_price_lay);
        selectItemSubmitButton = (BootstrapButton) findViewById(R.id.select_item_submit);
        selectItemBillButton = (BootstrapButton) findViewById(R.id.select_item_bill);
        changeDayButton = (BootstrapButton) findViewById(R.id.change_day_button);
        changeMemberButton = (BootstrapButton) findViewById(R.id.change_member_button);

        // presenter初期化
        itemPresenter = new ItemPresenter(getBaseContext(), this);

        // presenter描画
        itemPresenter.onCreate();

        // ボタンの設定
        selectItemSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemPresenter.addItemInCart();
            }
        });
        selectItemBillButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transitionPage(BillPage.class, itemPresenter.getCart());
            }
        });
        changeDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemPresenter.changeDay();
            }
        });
        changeMemberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemPresenter.changeMember();
            }
        });

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

    @Override
    public void setSelectItemNum(int selectItemNum) {
        super.setSelectItemNum(selectItemNum);
        itemPresenter.setSelectItemNum(selectItemNum);
    }
}
