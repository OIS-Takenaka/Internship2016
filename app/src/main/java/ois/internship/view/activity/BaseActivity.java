package ois.internship.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import ois.internship.R;
import ois.internship.model.repository.item.ItemRepository;


public abstract class BaseActivity extends AppCompatActivity {

    public int pageID = 0;
    public ItemRepository intentData;

    // 前画面フラグ
    public boolean enableBackBotton = true;

    static final int RESULT_SUB_ACTIVITY = 2461;

    /**
     * 画面生成時のシーケンス
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(enableBackBotton);
    }

    /**
     * アクションバー
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent();
                intent.putExtra(getString(R.string.intentKEY), intentData);
                setResult(RESULT_OK, intent);
                finish();
            default:
                break;
        }
        return false;
    }

    /**
     * ページの遷移
     *
     * @param c 遷移するクラス
     */
    public void transitionPage(Class c, ItemRepository itemRepository) {
        Log.i("---", c.getName());
        try {
            Intent intent = new Intent(getBaseContext(), c);
            intent.putExtra(getString(R.string.intentKEY), itemRepository);
            startActivityForResult(intent, RESULT_SUB_ACTIVITY);
        } catch (Exception e) {
            Intent intent = new Intent(getBaseContext(), c);
            startActivity(intent);
        }
    }

    /**
     * intentのデータを取得
     */
    public ItemRepository getIntentData() {
        intentData = (ItemRepository) getIntent().getSerializableExtra(getString(R.string.intentKEY));
        return intentData;
    }

    /**
     * 画面遷移時にデータを取得
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        // Bundle bundle = intent.getExtras();
        if (resultCode == RESULT_OK && requestCode == RESULT_SUB_ACTIVITY && intent != null) {
            intentData = (ItemRepository) getIntent().getSerializableExtra(getString(R.string.intentKEY));
            Log.w("intentData", "getIntentData");
        }
    }

    /**
     * 選択中のアイテムの変更
     */
    public void setSelectItemNum(int selectItemNum) {
        Log.i("position", selectItemNum + "");
    }

    public void onRefresh(){

    };
}
