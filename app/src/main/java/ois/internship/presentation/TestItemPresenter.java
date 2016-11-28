package ois.internship.presentation;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import ois.internship.R;
import ois.internship.model.loader.AsyncHttpLoader;
import ois.internship.model.loader.BaseLoader;
import ois.internship.model.repository.injector.ItemRepositoryInjector;
import ois.internship.model.repository.item.ItemRepository;
import ois.internship.view.activity.stab.Grid1;
import ois.internship.view.fragment.CardsFragment;


public class TestItemPresenter extends BasePresenter implements LoaderManager.LoaderCallbacks<JSONArray> {

    //=============================================================================
    // Variable
    //=============================================================================
    // Context
    private Context context;

    // Repository
    private ItemRepositoryInjector data = new ItemRepository();

    // View
    private Grid1 view;


    //------------------------------------------------------------------------------
    // Option Variable
    //------------------------------------------------------------------------------
    // Fragment
    private CardsFragment cardsFragment;


    //=============================================================================
    // Constracter
    //=============================================================================
    public TestItemPresenter(Context context, Grid1 view){
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
        cardsFragment = new CardsFragment(view, view.gridView);
        cardsFragment.setData(data.getCardData());
    }


    //=============================================================================
    // private
    //=============================================================================
    // モックデータ
    private void loadMock(){
        data.add(null, "AAAAA", null, null, 0);
        data.add(null, "AAAAA", null, null, 0);
        data.add(null, "AAAAA", null, null, 0);
        data.add(null, "AAAAA", null, null, 0);
        data.add(null, "AAAAA", null, null, 0);
        data.add(null, "AAAAA", null, null, 0);
        data.add(null, "AAAAA", null, null, 0);
        data.add(null, "AAAAA", null, null, 0);
        data.add(null, "AAAAA", null, null, 0);
        data.add(null, "AAAAA", null, null, 0);
        data.add(null, "AAAAA", null, null, 0);
        data.add(null, "AAAAA", null, null, 0);
        data.add(null, "AAAAA", null, null, 0);
        data.add(null, "AAAAA", null, null, 0);
        data.add(null, "AAAAA", null, null, 0);
    }


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
            for(int i=0; i < data.length(); i++) {
                this.data.add(
                        context.getString(R.string.httpPath) + "/img/" + data.getJSONObject(i).getString("img"),
                        data.getJSONObject(i).getString("name"),
                        data.getJSONObject(i).getString("maker"),
                        data.getJSONObject(i).getString("category"),
                        data.getJSONObject(i).getLong("price")
                );
            }
        } catch (JSONException e){e.printStackTrace();}
        view.onRefresh();
    }

    @Override
    public void onLoaderReset(Loader<JSONArray> loader) {

    }
}
