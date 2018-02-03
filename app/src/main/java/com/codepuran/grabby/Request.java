package com.codepuran.grabby;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.codepuran.grabby.listeners.ResponseListener;

/**
 * Created by parth on 1/28/2018.
 */

public class Request {

    public static void makeStringRequest(final String url, final ResponseListener responseListener)
    {
        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                responseListener.notifySuccess(response,url);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                responseListener.notifyError(error,url);

            }
        });

        GrabbyApplication.getInstance().getRequestQueue().add(stringRequest);
    }
}
