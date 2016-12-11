package ois.internship.presentation;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Stack;

import ois.internship.R;
import ois.internship.model.entity.ItemEntity;
import ois.internship.model.loader.AsyncHttpLoader;
import ois.internship.model.loader.BaseLoader;
import ois.internship.model.repository.item.CategoryRepository;
import ois.internship.model.repository.item.ItemRepository;
import ois.internship.view.activity.ItemPage;
import ois.internship.view.fragment.CardsFragment;
import ois.internship.view.ui.tab.TabPagerAdpter;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;


public class ItemPresenter extends BasePresenter implements LoaderManager.LoaderCallbacks<JSONArray> {

        //=============================================================================
        // Variable
        //=============================================================================
        // Context
        private Context context;

        // Repository
        private CategoryRepository category = new CategoryRepository();
        private ArrayList<ItemRepository> data = new ArrayList<>();

        // View
        private ItemPage view;

        private Stack<String> getCategory = new Stack<>();

        //------------------------------------------------------------------------------
        // Option Variable
        //------------------------------------------------------------------------------
        // Fragment
        private CardsFragment cardsFragment;
        private TabPagerAdpter tabPagerAdpter;

        // selected item
        private int selectItemNum = -1;

        //=============================================================================
        // Constracter
        //=============================================================================
        public ItemPresenter(Context context, ItemPage view){
            this.context = context;
            this.view = view;
            loadMock();
        }


        //=============================================================================
        // public
        //=============================================================================
        @Override
        public void onCreate(){
            getCategory.push("food");
            getCategory.push("clothes");
            onCreateLoader();
            view.onRefresh();
        }

        @Override
        public void onRefresh() {
            tabPagerAdpter = new TabPagerAdpter(view, data.size());
            if(data.size() > 0)tabPagerAdpter.setData(data.get(0).getCardData());
            view.tabLayout.setupWithViewPager(view.viewPager);
            view.viewPager.setAdapter(tabPagerAdpter);
            this.setSide();
        }

        //=============================================================================
        // private
        //=============================================================================
        // モックデータ
        private void loadMock(){}

        //=============================================================================
        // Loader
        //=============================================================================
        private void onCreateLoader() {
            Log.i("DEBUG", "onCreateLoader");
            Bundle bundle = new Bundle();
            bundle.putString("url", getCategory.pop());
            view.getLoaderManager().initLoader(0, bundle, this);
        }

        @Override
        public Loader<JSONArray> onCreateLoader(int id, Bundle args) {
            Log.w("DEBUG ---", args.getString("url"));
            String url = args.getString("url");
            BaseLoader asyncTaskLoader = new AsyncHttpLoader(context, url);
            //BaseLoader asyncTaskLoader = new MockAsyncTaskLoader(context, url);
            asyncTaskLoader.forceLoad();
            return asyncTaskLoader;
        }

        @Override
        public void onLoadFinished(Loader<JSONArray> loader, JSONArray data) {
            if(data != null) Log.i("DEBUG", data.toString());
            this.data.add(new ItemRepository());
            try {
                // 変換
                ArrayList<ItemEntity> tempItemList = new ArrayList<>();
                for(int i=0; i < data.length(); i++) {
                    tempItemList.add(new ItemEntity(
                            context.getString(R.string.httpPath) + "/img/" + data.getJSONObject(i).getString("img"),
                            data.getJSONObject(i).getString("name"),
                            data.getJSONObject(i).getString("maker"),
                            data.getJSONObject(i).getString("category"),
                            (int)data.getJSONObject(i).getLong("price")
                    ));
                }
                this.data.get(this.data.size()-1).set(tempItemList);
            } catch (JSONException e){e.printStackTrace();}
            view.onRefresh();

            Log.i("debug---", getCategory.toString());
            //if(!getCategory.empty()) onCreateLoader();
        }

        @Override
        public void onLoaderReset(Loader<JSONArray> loader) {

        }

        //=============================================================================
        // Sideber
        //=============================================================================
        public void setSelectItemNum(int selectItemNum) {
            this.selectItemNum = selectItemNum;
            view.onRefresh();
        }

        private void setSide(){
            if(this.selectItemNum > -1){
                setVisibilitySide(true);
                view.selectItemCategory.setText(data.get(0).getItem(selectItemNum).getCategory());
                view.selectItemTitle.setText(data.get(0).getItem(selectItemNum).getName());
                view.selectItemPrice.setText("￥ " + data.get(0).getItem(selectItemNum).getPrice());
                view.selectItemImg.setImageBitmap(tabPagerAdpter.cardsFragment.adapter.getImage(selectItemNum));
            } else {
                setVisibilitySide(false);
                view.selectItemTitle.setText("商品を選択してください。");
            }
        }

        private void setVisibilitySide(boolean bool){
            int visibleFlag = ( bool ? VISIBLE : INVISIBLE);
            view.selectItemImg.setVisibility(visibleFlag);
            view.selectItemCategory.setVisibility(visibleFlag);
            view.selectItemPriceLay.setVisibility(visibleFlag);
            view.selectItemSubmitButton.setVisibility(visibleFlag);
        }
}

