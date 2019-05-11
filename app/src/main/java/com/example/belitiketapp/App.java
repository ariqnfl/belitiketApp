package com.example.belitiketapp;

import android.app.Application;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppState.getInstance().initSharedPrefs(this);
    }
}
