package ois.internship.model.loader;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import ois.internship.view.ui.If.AsyncImg;

public class AsyncImgLoader extends AsyncTask<String, Void, Bitmap> {

    private Context context = null;
    private AsyncImg asyncImg;
    private int position = -1;

    public AsyncImgLoader(Context context, AsyncImg asyncImg, int position) {
        this.context = context;
        this.asyncImg = asyncImg;
        this.position = position;
    }

    @Override
    protected Bitmap doInBackground(String... url) {

        HttpURLConnection connection = null;
        InputStream inputStream = null;
        Bitmap bitmap = null;

        try {
            URL _url = new URL(url[0]);
            connection = (HttpURLConnection)_url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            inputStream = connection.getInputStream();

            BitmapFactory.Options opt = new BitmapFactory.Options();
            opt.inSampleSize = 4;
            opt.inPurgeable = true;
            bitmap = BitmapFactory.decodeStream(inputStream, null, opt);
        }
        catch (MalformedURLException exception){}
        catch (IOException exception){}
        finally {
            if (connection != null)connection.disconnect();
            try{if (inputStream != null) inputStream.close();} catch (IOException exception){}
        }

        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        asyncImg.setImage(position, bitmap);
        Log.i("AsyncImg","onPostExecute");
    }
}
