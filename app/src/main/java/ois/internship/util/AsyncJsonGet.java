package ois.internship.util;


import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class AsyncJsonGet extends AsyncTask<String, Integer, JSONObject>{

    Context context;

    /**
     * コンストラクタ
     */
    public AsyncJsonGet(Context context){
        this.context = context;
    }

    /**
     * doInBackground 実行前
     */
    protected void onPreExecute(){
        super.onPreExecute();
        Log.i("DEBUG", "onProgressUpdate");
    }

    /**
     * doInBackground 実行後
     */
    protected void onPostExecute(JSONObject data){
        super.onPostExecute(data);
        Log.i("DEBUG", "onPostExecute");
    }

    /**
     * doInBackground 実行中
     * @param _progress 進捗率
     */
    protected void onProgressUpdate(Integer... _progress) {
        super.onProgressUpdate(_progress);
        Log.i("DEBUG", "onProgressUpdate " + (100-_progress[0]*20) + "%");
    }

    /**
     * 非同期処理
     * @param api api名
     * @return jsonオブジェクト
     */
    protected JSONObject doInBackground(String... api) {

        Log.i("DEBUG", "doInBackground" + api[0]);
        for(int i=5;i-->0;){
            new Util().waitTimer(1000);
            publishProgress(i);
        }
        JSONObject jsonObject = null;

        try {

            // Json読み込み
            InputStream input = context.getAssets().open("mock/" + api[0] + ".json");
            byte[] buffer = new byte[input.available()];
            input.read(buffer);
            input.close();
            jsonObject = new JSONObject(new String(buffer));
            Log.i("DEBUG", "doInBackground:" + jsonObject);

        } catch (FileNotFoundException e) {
            Log.i("DEBUG", "情報が無いです！");
        } catch (IOException e) {
            Log.i("DEBUG", "エラーです！");
        } catch (JSONException e) {
            Log.i("DEBUG", "JSONから変換できません！");
        }

        return jsonObject;
    }
}
