package ois.internship.model.loader;


import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MockAsyncTaskLoader extends BaseLoader{

    public MockAsyncTaskLoader(Context context, String url) {
        super(context, url);
    }

    @Override
    public JSONArray loadInBackground() {
        Log.i("DEBUG", "loadInBackground" + url);
        JSONArray data = null;
        try {
            // Json読み込み
            InputStream input = context.getAssets().open("mock/List.json");
            byte[] buffer = new byte[input.available()];
            input.read(buffer);
            input.close();
            data = new JSONArray(new String(buffer));
        } catch (FileNotFoundException e) {
            Log.i("DEBUG", "情報が無いです！");
        } catch (IOException e) {
            Log.i("DEBUG", "エラーです！");
        } catch (JSONException e) {
            Log.i("DEBUG", "JSONから変換できません！");
        }
        return data;
    }

}
