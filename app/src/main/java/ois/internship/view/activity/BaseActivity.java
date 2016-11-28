package ois.internship.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import ois.internship.R;
import ois.internship.model.repository.BaseRepository;


public abstract class BaseActivity extends AppCompatActivity {

    public int pageID = 0;
    public BaseRepository intentData;

    /**
     * 画面生成時のシーケンス
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    /**
     * ページの遷移
     * @param c 遷移するクラス
     * @param data 渡すデータ
     */
    public void transitionPage(Class c,BaseRepository data){
        Log.i("---",c.getName());
        Intent intent = new Intent(this, c);
        intent.putExtra("KEY", data);
        startActivity(intent);
    }

    /**
     * intentのデータを取得
     */
    public void getIntentData(){
        intentData = (BaseRepository) getIntent().getSerializableExtra(getString(R.string.intentKEY));
    }

}
