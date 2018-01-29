package com.codepuran.grabby;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by parth on 1/28/2018.
 */

public class Request {

    public static void MakeStringRequest(String url)
    {
        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        GrabbyApplication.getInstance().getRequestQueue().add(stringRequest);
    }
}
