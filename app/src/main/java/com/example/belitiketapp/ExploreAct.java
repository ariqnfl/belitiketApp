package com.example.belitiketapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ExploreAct extends AppCompatActivity {
    LinearLayout btn_pisa,
            btn_torri, btn_pagoda,
            btn_candi, btn_sphinx,
            btn_monas,btn_opera,btn_berlin,btn_stonehenge;
    Button btn_back_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);
        btn_pisa = findViewById(R.id.btn_pisa);
        btn_torri = findViewById(R.id.btn_torri);
        btn_pagoda = findViewById(R.id.btn_pagoda);
        btn_candi = findViewById(R.id.btn_candi);
        btn_sphinx = findViewById(R.id.btn_sphinx);
        btn_monas = findViewById(R.id.btn_monas);
        btn_opera = findViewById(R.id.btn_opera);
        btn_berlin = findViewById(R.id.btn_berlin);
        btn_stonehenge = findViewById(R.id.btn_stonehenge);
        btn_back_home = findViewById(R.id.btn_back_home);

        btn_pisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotopisaticket = new Intent(ExploreAct.this,TicketDetailAct.class);
                // meletakan data kepada intent
                gotopisaticket.putExtra("jenis_tiket", "Pisa");
                startActivity(gotopisaticket);
            }
        });

        btn_torri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent torri = new Intent(ExploreAct.this,TicketDetailAct.class);
                torri.putExtra("jenis_tiket", "Torri");
                startActivity(torri);
            }
        });
        btn_pagoda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagoda = new Intent(ExploreAct.this,TicketDetailAct.class);
                pagoda.putExtra("jenis_tiket", "Pagoda");
                startActivity(pagoda);
            }
        });
        btn_candi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent candi = new Intent(ExploreAct.this,TicketDetailAct.class);
                candi.putExtra("jenis_tiket", "Candi");
                startActivity(candi);
            }
        });
        btn_sphinx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sphinx = new Intent(ExploreAct.this,TicketDetailAct.class);
                sphinx.putExtra("jenis_tiket", "Sphinx");
                startActivity(sphinx);
            }
        });
        btn_monas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent monas = new Intent(ExploreAct.this,TicketDetailAct.class);
                monas.putExtra("jenis_tiket", "Monas");
                startActivity(monas);
            }
        });
        btn_opera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opera = new Intent(ExploreAct.this,TicketDetailAct.class);
                opera.putExtra("jenis_tiket", "Opera House");
                startActivity(opera);
            }
        });
        btn_berlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent berlin = new Intent(ExploreAct.this,TicketDetailAct.class);
                berlin.putExtra("jenis_tiket", "Berlin Cathedral");
                startActivity(berlin);
            }
        });
        btn_stonehenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stonehenge = new Intent(ExploreAct.this,TicketDetailAct.class);
                stonehenge.putExtra("jenis_tiket", "Stonehenge");
                startActivity(stonehenge);
            }
        });


    }
}
