package com.codepuran.grabby;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.MobileAds;

/**
 * Created by parth on 1/28/2018.
 */

public class GrabbyApplication extends Application {

    private RequestQueue requestQueue;
    private static GrabbyApplication grabbyApplicationInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        grabbyApplicationInstance = this;
        MobileAds.initialize(this,getString(R.string.ad_mob_id));
    }


    public static synchronized GrabbyApplication getInstance()
    {
        return grabbyApplicationInstance;
    }

    public RequestQueue getRequestQueue()
    {
        if(requestQueue == null)
        {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return requestQueue;
    }
}
