package ois.internship.view.ui.Cards;

import android.util.Log;

import ois.internship.R;


public class CardLayout {

    // フラグメントのレイアウト
    int layout = R.layout.fragment__card_list;

    // グリッド
    int gridViewLayout;

    // 画像
    int imgLayout = R.id.card_list_image;

    // テキスト
    int textLayout = R.id.card_list_textView;


    // コンストラクタ
    public CardLayout(int gridViewLayout){
        Log.i("DEBUG","TempListLayout");
        this.gridViewLayout = gridViewLayout;
    }
}
