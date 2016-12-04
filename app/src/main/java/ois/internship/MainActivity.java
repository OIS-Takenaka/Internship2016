package ois.internship;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.beardedhen.androidbootstrap.BootstrapButton;

import ois.internship.view.activity.BillPage;
import ois.internship.view.activity.ItemPage;
import ois.internship.view.activity.stab.Grid1;
import ois.internship.view.activity.stab.Page1;
import ois.internship.view.activity.stab.Page2;
import ois.internship.view.activity.stab.Page4;
import ois.internship.view.fragment.AgreeDialogFragment;

public class MainActivity extends AppCompatActivity {

    BootstrapButton button1;
    BootstrapButton button2;
    BootstrapButton button3;
    BootstrapButton button4;
    BootstrapButton button5;
    BootstrapButton button6;

    AgreeDialogFragment agreeDialogFragment;

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
        button6 = (BootstrapButton)findViewById(R.id.button6);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getBaseContext(), Page1.class));
                startActivity(new Intent(getBaseContext(), ItemPage.class));
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
                agreeDialogFragment = new AgreeDialogFragment();
                agreeDialogFragment.show(getFragmentManager(), "");
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
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), BillPage.class));
            }
        });

        //new AsyncJsonGet(this).execute("List");

        ////////////////////////////////////////////////////////////////////////
    }
}
