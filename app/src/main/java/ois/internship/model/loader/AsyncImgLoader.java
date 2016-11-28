package ois.internship.model.loader;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncImgLoader extends AsyncTask<String, Void, Bitmap> {

    Context context = null;
    private ImageView imageView;

    public AsyncImgLoader(Context context, ImageView imageView) {
        this.context = context;
        this.imageView = imageView;
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

            bitmap = BitmapFactory.decodeStream(inputStream);
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
        this.imageView.setImageBitmap(bitmap);
    }
}
