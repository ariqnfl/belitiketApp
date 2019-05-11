package com.example.belitiketapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class SettingAct extends AppCompatActivity {

    Switch mSwitchNight, mSwitchFont;
    Button btnSave;
    private Context mContext;
    private AppState appState = AppState.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new UtilsSetting(this).setTheme();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        mContext = this;
        mSwitchNight = findViewById(R.id.switch_night_mode);
        mSwitchFont = findViewById(R.id.switch_big_font);
        btnSave = findViewById(R.id.btn_save_setting);
        init();
    }

    void init() {
        if (appState.isNightMode()) {
            mSwitchNight.setChecked(true);
        }

        if (appState.isFontBig()) {
            mSwitchFont.setChecked(true);
        }
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTheme();
                changeFontSize();
                Toast.makeText(mContext, "Saved Changes Success", Toast.LENGTH_SHORT).show();
                recreate();
            }
        });
    }

    void changeTheme() {
        if (mSwitchNight.isChecked()) {
            appState.setNightMode(true);
            new UtilsSetting(mContext).setTheme();
        } else {
            appState.setNightMode(false);
            new UtilsSetting(mContext).setTheme();
        }
    }

    void changeFontSize() {
        if (mSwitchFont.isChecked()) {
            appState.setFontBig(true);
        } else {
            appState.setFontBig(false);
        }
    }
}
