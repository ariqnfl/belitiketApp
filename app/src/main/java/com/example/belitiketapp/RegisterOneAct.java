package com.example.belitiketapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class RegisterOneAct extends AppCompatActivity {
    Button btn_continue;
    LinearLayout btn_back;
    EditText username, password, email_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_one);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email_address = findViewById(R.id.email_address);

        btn_continue = findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // berpindah activity
                Intent gotonextregister = new Intent(RegisterOneAct.this, RegisterTwoAct.class);
                startActivity(gotonextregister);
            }
        });
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backtosignin = new Intent(RegisterOneAct.this, SignInAct.class);
                startActivity(backtosignin);
            }
        });
    }
}
