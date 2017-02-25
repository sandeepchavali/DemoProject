package com.GoogleplusloginDemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by chavali on 2017-02-24.
 */

public class Myapplication extends Application {
    private static Myapplication mInstance;

    public static synchronized Myapplication getInstance() {
        return mInstance;
    }

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();


        Myapplication.context = getApplicationContext();

    }

    public static Context getAppContext() {
        return Myapplication.context;
    }

}
