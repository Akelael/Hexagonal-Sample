package com.redbooth.hexagonalsample;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
    private static Application singleton;

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }

    public static Context getContext() {
        return singleton.getApplicationContext();
    }
}
