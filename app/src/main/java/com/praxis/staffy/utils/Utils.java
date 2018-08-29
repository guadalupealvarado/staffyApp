package com.praxis.staffy.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.praxis.staffy.ui.MyAplication;

public class Utils {
    public static boolean isOnline(){
        ConnectivityManager cm = (ConnectivityManager) MyAplication.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        @SuppressLint("MissingPermission") NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
