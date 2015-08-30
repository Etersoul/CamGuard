package com.etersoul.camguard;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by etersoul on 8/30/15.
 */
public class AsyncCamNetwork extends AsyncTask<Void, Void, Drawable> {
    CallableAsyncUI<Drawable> mContext;

    public AsyncCamNetwork(CallableAsyncUI<Drawable> context) {
        this.mContext = context;
    }

    @Override
    protected Drawable doInBackground(Void... params) {
        Drawable draw;

        try {
            URL url = new URL("http://192.168.5.195/image/jpeg.cgi");
            URLConnection con = url.openConnection();

            draw = Drawable.createFromStream((InputStream) con.getContent(), "name");
        } catch (MalformedURLException e) {
            return null;
        } catch (IOException e) {
            return null;
        } catch (Exception e) {
            return null;
        }

        return draw;
    }

    @Override
    protected void onPostExecute(Drawable drawable) {
        this.mContext.updateUI(drawable);
    }
}
