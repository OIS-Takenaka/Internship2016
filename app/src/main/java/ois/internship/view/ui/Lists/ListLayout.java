package ois.internship.view.ui.Lists;

import android.util.Log;

import ois.internship.R;


public class ListLayout {

    // リストアイテムのレイアウト
    int pLayout = R.layout.component__list;
    int layout = R.layout.fragment__bill_list;

    // 外枠のレイアウト
    int outFrame;

    // 画像
    int imgLayout = R.id.simple_list_thumbnail;

    // テキスト
    int titleLayout = R.id.simple_list_title;

    // テキスト
    int priceLayout = R.id.simple_list_price;


    // コンストラクタ
    public ListLayout(int outFrame){
        Log.i("DEBUG","TempListLayout");
        this.outFrame = outFrame;
    }
}
