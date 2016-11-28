package ois.internship.model.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;

import org.json.JSONArray;


public class BaseLoader extends AsyncTaskLoader<JSONArray> {

    Context context = null;
    String url = null;

    public BaseLoader(Context context, String url) {
        super(context);
        this.context = context;
        this.url = url;
    }

    @Override
    public JSONArray loadInBackground() {
        return null;
    }

    public BaseLoader(Context context) {
        super(context);
    }
}
