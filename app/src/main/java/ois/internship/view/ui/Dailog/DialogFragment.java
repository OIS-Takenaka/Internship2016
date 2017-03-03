package ois.internship.view.ui.Dailog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialButton;


public abstract class DialogFragment extends android.app.DialogFragment {

    protected DialogLayout dialogLayout = new DialogLayout();
    protected DialogModel dialogModel = new DialogModel("", "");
    private MaterialButton button1;
    private MaterialButton button2;

    TextView titleView;
    ImageView imageView;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View content = layoutInflater.inflate(dialogLayout.layout, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        ///////////////////////////////////////////////////////////////////////////////////////

        titleView = (TextView) content.findViewById(dialogLayout.textLayout);
        titleView.setText(dialogModel.text);

        // 画像の高さを調整
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int basePixels = ( metrics.widthPixels > metrics.heightPixels ? metrics.heightPixels : metrics.widthPixels );
        int imgHeight = 0;//(int) (basePixels / 16 * 9);
        int imgWidth = 100;//(int) basePixels;
        imageView = (ImageView)content.findViewById(dialogLayout.imgLayout);
        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        params.height = imgHeight;
        params.width = imgWidth;
        imageView.setLayoutParams(params);

        //ボタンアクション
        button1 = (MaterialButton) content.findViewById(dialogLayout.button1);
        button2 = (MaterialButton) content.findViewById(dialogLayout.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickTobutton1();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickTobutton2();
            }
        });

        ///////////////////////////////////////////////////////////////////////////////////////
        builder.setView(content);

        Dialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(true);
        return dialog;
    }

    protected abstract void onClickTobutton1();
    protected abstract void onClickTobutton2();
    public abstract void setData(DialogModel data);
}
