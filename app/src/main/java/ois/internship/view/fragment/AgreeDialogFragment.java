package ois.internship.view.fragment;

import android.util.Log;

import ois.internship.view.ui.Dailog.DialogFragment;
import ois.internship.view.ui.Dailog.DialogModel;

public class AgreeDialogFragment extends DialogFragment {

    /**
     * コンストラクタ
     */
    public AgreeDialogFragment(){
        Log.i("DEBUG", "TempDialogFragment");
    }

    protected void onClickTobutton1() {
        dismiss();
    }
    protected void onClickTobutton2() {
        dismiss();
    }
    public void setData(DialogModel data) {


    }
}
