package ois.internship.view.ui.Other;

import android.content.Context;
import android.view.View;
import android.widget.Button;

public abstract class BaseButton extends Button {

    /**
     * コンストラクタ
     * @param context
     */
    BaseButton(Context context){
        super(context);
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClick();
            }
        });
    }

    /**
     * クリック後のアクション
     */
    public abstract void setOnClick();
}