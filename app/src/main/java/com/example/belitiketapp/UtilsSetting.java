package com.example.belitiketapp;

import android.content.Context;
import android.util.TypedValue;
import android.widget.TextView;

public class UtilsSetting {
    private Context mContext;
    private AppState appState = AppState.getInstance();

    public UtilsSetting(Context mContext) {
        this.mContext = mContext;
    }

    public void setTheme() {
        if (appState.isNightMode()) {
            mContext.setTheme(R.style.AppTheme_Dark);
        } else {
            mContext.setTheme(R.style.AppTheme);
        }
    }

    public void setFontBig(TextView tv) {
        if (appState.isFontBig())
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
    }
}
