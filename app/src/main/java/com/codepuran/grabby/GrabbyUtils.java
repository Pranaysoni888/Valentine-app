package com.codepuran.grabby;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by parth on 2/3/2018.
 */

public class GrabbyUtils {

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
