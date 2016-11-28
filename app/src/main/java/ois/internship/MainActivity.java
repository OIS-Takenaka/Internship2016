package ois.internship;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.beardedhen.androidbootstrap.BootstrapButton;

import ois.internship.view.activity.Grid1;
import ois.internship.view.activity.Page1;
import ois.internship.view.activity.Page2;
import ois.internship.view.activity.Page4;
import ois.internship.view.fragment.ApplyDialogFragment;

public class MainActivity extends AppCompatActivity {

    BootstrapButton button1;
    BootstrapButton button2;
    BootstrapButton button3;
    BootstrapButton button4;
    BootstrapButton button5;

    ApplyDialogFragment applyDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /////////////////////////////////////////////////////////////////////////
        // ここから処理を書く
        /////////////////////////////////////////////////////////////////////////
        //startActivity(new Intent(getApplicationContext(), Page3.class));

        button1 = (BootstrapButton)findViewById(R.id.button1);
        button2 = (BootstrapButton)findViewById(R.id.button2);
        button3 = (BootstrapButton)findViewById(R.id.button3);
        button4 = (BootstrapButton)findViewById(R.id.button4);
        button5 = (BootstrapButton)findViewById(R.id.button5);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Page1.class));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Page2.class));
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getBaseContext(), Page3.class));
                applyDialogFragment = new ApplyDialogFragment();
                applyDialogFragment.show(getFragmentManager(), "");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Grid1.class));
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Page4.class));
            }
        });

        //new AsyncJsonGet(this).execute("List");

        ////////////////////////////////////////////////////////////////////////
    }
}
