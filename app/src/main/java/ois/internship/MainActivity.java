package ois.internship;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.beardedhen.androidbootstrap.BootstrapButton;

import java.util.ArrayList;

import ois.internship.model.entity.ItemEntity;
import ois.internship.model.repository.item.PurchasedItemRepository;
import ois.internship.view.activity.BaseActivity;
import ois.internship.view.activity.ItemPage;
import ois.internship.view.fragment.AgreeDialogFragment;

public class MainActivity extends BaseActivity {

    BootstrapButton button1;
    BootstrapButton button2;
    BootstrapButton button3;
    BootstrapButton button4;
    BootstrapButton button5;
    BootstrapButton button6;

    AgreeDialogFragment agreeDialogFragment;

    MainActivity() {
        intentData = new PurchasedItemRepository();
        ArrayList<ItemEntity> item = new ArrayList<>();
        item.add(new ItemEntity("AAA","BBB"));
        intentData.set(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        enableBackBotton = false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /////////////////////////////////////////////////////////////////////////
        // ここから処理を書く
        /////////////////////////////////////////////////////////////////////////
        startActivity(new Intent(getApplicationContext(), ItemPage.class));

        button1 = (BootstrapButton)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transitionPage(ItemPage.class, null);
            }
        });

        ////////////////////////////////////////////////////////////////////////
    }
}
