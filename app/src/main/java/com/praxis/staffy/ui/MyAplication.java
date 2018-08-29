package com.praxis.staffy.ui;

import android.app.Application;
import android.content.Context;

public class  MyAplication extends Application {
    private static Context context;

    @Override
    public void onCreate()
    {
        super.onCreate();
        setContext(getApplicationContext());
    }

    public static Context getContext() {
        return context;
    }



    public static void setContext(Context context) {
        MyAplication.context = context;
    }
}
