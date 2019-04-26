package com.example.belitiketapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class HomeAct extends AppCompatActivity {
    LinearLayout btn_ticket_pisa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn_ticket_pisa = findViewById(R.id.btn_ticket_pisa);

        btn_ticket_pisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeAct.this, TicketDetailAct.class));
            }
        });
    }
}
