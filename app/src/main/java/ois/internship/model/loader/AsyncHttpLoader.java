package ois.internship.model.loader;


import android.content.Context;
import android.util.Log;

import org.json.JSONArray;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import ois.internship.R;

public class AsyncHttpLoader extends BaseLoader{

    public AsyncHttpLoader(Context context, String url) {
        super(context, url);
    }

    @Override
    public JSONArray loadInBackground() {
        Log.i("DEBUG", "loadInBackground" + url);
        return tryHttpRequest("");
    }

    /**
     * HTTP通信
     * @param u
     * @return JSONデータ
     *
     * URL形式
     * http://xxxxxx?c=1&p=1
     */
    private JSONArray tryHttpRequest(String u){
        // 取得したテキストを格納する変数
        HttpURLConnection con = null;
        JSONArray result = new JSONArray();

        try {
            // URLオブジェクト生成
            URL url = new URL(context.getString(R.string.httpPath) + "/responce.php?q=i&c=" + this.url);
            Log.i("GET URL", url.getPath());

            // コネクション生成
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);

            // リクエスト送信
            con.connect();

            // HTTPレスポンスが正常か判定
            if (con.getResponseCode() != HttpURLConnection.HTTP_OK) return new JSONArray();

            // JSONに変換
            InputStream in = con.getInputStream();
            byte bodyByte[] = new byte[32768];
            in.read(bodyByte);
            in.close();
            result = new JSONArray(new String(bodyByte));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) con.disconnect(); // コネクションを切断
        }
        return result;
    }

}
