package com.garytokman.simplemvp;
// Gary Tokman
// 11/25/16
// SimpleMVP

import android.app.Application;

import timber.log.Timber;

public class SimpleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        Timber.i("Created the app!");
    }
}
