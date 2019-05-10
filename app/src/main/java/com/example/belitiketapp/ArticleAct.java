package com.example.belitiketapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ArticleAct extends AppCompatActivity {

    TextView title_artikel,desc_artikel,text_date;

    DatabaseReference reference;

    ImageView header_artikel;
    private Context context;

    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new UtilsSetting(this).setTheme();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        context = this;
        title_artikel = findViewById(R.id.title_artikel);
        desc_artikel = findViewById(R.id.text_desc);
        header_artikel = findViewById(R.id.header_article);
        btn_back = findViewById(R.id.btn_back_artikel);
        text_date = findViewById(R.id.text_date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        new UtilsSetting(context).setFontBig(desc_artikel);
        text_date.setText(simpleDateFormat.format(date));

        Bundle bundle = getIntent().getExtras();
        final String nama_artikel = bundle.getString("nama_artikel");

        reference = FirebaseDatabase.getInstance().getReference().child("Article").child(nama_artikel);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                title_artikel.setText(dataSnapshot.child("nama_artikel").getValue().toString());
                desc_artikel.setText(dataSnapshot.child("desc_artikel").getValue().toString());
                Picasso.with(ArticleAct.this).load(dataSnapshot.child("url_header_artikel").getValue().toString()).centerCrop().fit().into(header_artikel);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ArticleAct.this,HomeAct.class));
            }
        });
    }
}
