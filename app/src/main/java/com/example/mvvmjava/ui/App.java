package com.example.mvvmjava.ui;

import android.app.Application;


/**
 *  Created by Md Zakaria Ahnaf on 19/10/2023.
 */
public class App extends Application {

    private static App sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static App getInstance() {
        return sInstance;
    }

}
