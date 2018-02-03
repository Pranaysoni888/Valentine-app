package com.codepuran.grabby.listeners;

import com.android.volley.VolleyError;

import org.json.JSONObject;

/**
 * Created by parth on 2/3/2018.
 */

public interface ResponseListener {

    void notifySuccess(String response,String url);
    void notifyError(VolleyError error,String url);
}
