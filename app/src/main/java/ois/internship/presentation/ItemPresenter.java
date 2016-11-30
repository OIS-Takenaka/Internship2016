package ois.internship.presentation;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import ois.internship.R;
import ois.internship.model.entity.ItemEntity;
import ois.internship.model.loader.AsyncHttpLoader;
import ois.internship.model.loader.BaseLoader;
import ois.internship.model.repository.item.ItemRepository;
import ois.internship.view.activity.ItemPage;
import ois.internship.view.fragment.CardsFragment;
import ois.internship.view.ui.tab.TabPagerAdpter;


public class ItemPresenter extends BasePresenter implements LoaderManager.LoaderCallbacks<JSONArray> {

        //=============================================================================
        // Variable
        //=============================================================================
        // Context
        private Context context;

        // Repository
        private ItemRepository data = new ItemRepository();

        // View
        private ItemPage view;


        //------------------------------------------------------------------------------
        // Option Variable
        //------------------------------------------------------------------------------
        // Fragment
        private CardsFragment cardsFragment;


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
            onCreateLoader("List");
            view.onRefresh();
        }

        @Override
        public void onRefresh() {
            TabPagerAdpter adapter = new TabPagerAdpter(view, data.categorySize());
            adapter.setData(data.getCardData());
            view.tabLayout.setupWithViewPager(view.viewPager);
            view.viewPager.setAdapter(adapter);
        }


        //=============================================================================
        // private
        //=============================================================================
        // モックデータ
        private void loadMock(){}

        //=============================================================================
        // Loader
        //=============================================================================
        private void onCreateLoader(String url) {
            Bundle bundle = new Bundle();
            bundle.putString("url", "List");
            view.getLoaderManager().initLoader(0, bundle, this);
        }

        @Override
        public Loader<JSONArray> onCreateLoader(int id, Bundle args) {
            String url = args.getString("url");
            BaseLoader asyncTaskLoader = new AsyncHttpLoader(context, url);
            //BaseLoader asyncTaskLoader = new MockAsyncTaskLoader(context, url);
            asyncTaskLoader.forceLoad();
            return asyncTaskLoader;
        }

        @Override
        public void onLoadFinished(Loader<JSONArray> loader, JSONArray data) {
            if(data != null) Log.i("DEBUG", data.toString());
            this.data = new ItemRepository();
            try {
                // 変換
                ArrayList<ItemEntity> tempItemList = new ArrayList<>();
                for(int i=0; i < data.length(); i++) {
                    tempItemList.add(new ItemEntity(
                            context.getString(R.string.httpPath) + "/img/" + data.getJSONObject(i).getString("img"),
                            data.getJSONObject(i).getString("name"),
                            data.getJSONObject(i).getString("maker"),
                            data.getJSONObject(i).getString("category"),
                            data.getJSONObject(i).getLong("price")
                    ));
                }
                this.data.set(0, tempItemList);
            } catch (JSONException e){e.printStackTrace();}
            view.onRefresh();
        }

        @Override
        public void onLoaderReset(Loader<JSONArray> loader) {

        }
}

