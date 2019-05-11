package com.example.belitiketapp;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class AppState {
    private static final String IS_NIGHT_MODE = "night_mode";
    private static final String IS_BIG_FONT = "big_font";
    private static AppState instance;
    private SharedPreferences pref;

    private AppState() {
    }

    public static AppState getInstance() {
        if (instance == null) {
            synchronized (AppState.class) {
                if (instance == null) {
                    instance = new AppState();
                }
            }
        }
        return instance;
    }

    public void initSharedPrefs(Application application) {
        pref = application.getSharedPreferences(
                "com.example.belitiketapp.SHARED_PREF",
                Context.MODE_PRIVATE
        );
    }

    public boolean isNightMode() {
        return pref.getBoolean(IS_NIGHT_MODE, false);
    }

    public void setNightMode(Boolean status) {
        pref.edit().putBoolean(IS_NIGHT_MODE, status).apply();
    }

    public boolean isFontBig() {
        return pref.getBoolean(IS_BIG_FONT, false);
    }

    public void setFontBig(Boolean status) {
        pref.edit().putBoolean(IS_BIG_FONT, status).apply();
    }
}
