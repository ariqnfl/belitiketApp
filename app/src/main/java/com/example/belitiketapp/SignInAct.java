package com.example.belitiketapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignInAct extends AppCompatActivity {
    TextView btn_new_account;
    Button btn_sign_in;
    EditText xusername, xpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        btn_new_account = findViewById(R.id.btn_new_account);
        btn_sign_in = findViewById(R.id.btn_sign_in);
        xusername = findViewById(R.id.xusername);
        xpassword = findViewById(R.id.xpassword);

        btn_new_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoregisterone = new Intent(SignInAct.this, RegisterOneAct.class);
                startActivity(gotoregisterone);
            }
        });

        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotohome = new Intent(SignInAct.this, HomeAct.class);
                startActivity(gotohome);
            }
        });
    }
}
