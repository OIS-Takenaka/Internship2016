package ois.internship.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;

import ois.internship.R;
import ois.internship.controller.presenter.BillPresenter;
import ois.internship.view.fragment.AgreeDialogFragment;

public class BillPage extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private BillPresenter billPresenter;

    // textbox
    public TextView billDiscountPrice;
    public TextView billDeliverPrice;
    public TextView billTotalPrice;
    public TextView billRemainPoint;
    public BootstrapButton billEnterButton;

    AgreeDialogFragment agreeDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__bill_page);

        /////////////////////////////////////////////////////////////////////////
        // ここから処理を書く
        /////////////////////////////////////////////////////////////////////////

        // テキストボックスのセット
        billDiscountPrice = (TextView) findViewById(R.id.bill_discount_price);
        billDeliverPrice = (TextView) findViewById(R.id.bill_deliver_price);
        billTotalPrice = (TextView) findViewById(R.id.bill_total_price);
        billRemainPoint = (TextView) findViewById(R.id.bill_remain_point);
        billEnterButton = (BootstrapButton) findViewById(R.id.bill_enter_button);

        // ラジオボタンのセット
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(this);

        // presenter初期化
        billPresenter = new BillPresenter(getBaseContext(), this);

        // 遷移元からカート情報を取得
        billPresenter.setCart(getIntentData());

        // presenter描画
        billPresenter.onCreate();

        // 決定ボタンのアクションを追加
        billEnterButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               // Object a = billPresenter.getBillInfo();
               showDialog();
           }
       });
        /////////////////////////////////////////////////////////////////////////
    }

    /**
     * ラジオボタン
     * @param group
     * @param checkedId
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.not_use_point_toggle:
                billPresenter.setUsePointFlag(false);
                break;
            case R.id.use_point_toggle:
                billPresenter.setUsePointFlag(true);
                break;
            default:
                billPresenter.setUsePointFlag(false);
                break;
        }
    }

    public void showDialog() {
        agreeDialogFragment = new AgreeDialogFragment();
        agreeDialogFragment.setData(billPresenter.getDialog());
        agreeDialogFragment.show(getFragmentManager(), "");
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
