package ois.internship.view.ui.Dailog;

import android.util.Log;

import ois.internship.R;


public class DialogLayout {

    // リストアイテムのレイアウト
    int layout = R.layout.fragment__card_dailog;

    // 画像
    int imgLayout = R.id.dialog_image;

    // テキスト
    int textLayout =  R.id.dialog_title;

    // ボタン
    int button1 = R.id.dialog_button1;
    int button2 = R.id.dialog_button2;


    // コンストラクタ
    public DialogLayout(){

    }
    public DialogLayout(int layout, int imgLayout, int textLayout, int button1, int button2){
        Log.i("DEBUG","TempDialogLayout");
        this.layout = layout;
        this.imgLayout = imgLayout;
        this.textLayout = textLayout;
        this.button1 = button1;
        this.button2 = button2;
    }
}
