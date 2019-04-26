package com.example.belitiketapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TicketCheckoutAct extends AppCompatActivity {
    Button btn_pay_ticket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_checkout);
        btn_pay_ticket = findViewById(R.id.btn_pay_ticket);

        btn_pay_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TicketCheckoutAct.this,SuccessBuyTicketAct.class));
            }
        });
    }
}
