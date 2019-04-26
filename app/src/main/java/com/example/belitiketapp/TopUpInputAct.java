package com.example.belitiketapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TopUpInputAct extends AppCompatActivity {
    TextView top_up_balance;
    EditText amount;
    Button top_up;
    DatabaseReference reference,reference2;

    Integer my_balance=0;
    Integer jml_top_up = 0;
    String USERNAME_KEY = "usernamekey";
    String username_key = "";
    String username_key_new = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up_input);
        getUsernameLocal();
        top_up_balance = findViewById(R.id.balance_amount);
        amount = findViewById(R.id.jumlah_top_up);
        top_up = findViewById(R.id.btn_top_up);
//
        reference = FirebaseDatabase.getInstance().getReference().child("Users").child(username_key_new);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                my_balance = Integer.valueOf(dataSnapshot.child("user_balance").getValue().toString());
                top_up_balance.setText(my_balance.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        top_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jml_top_up = Integer.valueOf(amount.getText().toString());
                final int hasil = my_balance + jml_top_up;

                reference2 = FirebaseDatabase.getInstance().getReference().child("Users").child(username_key_new);
                reference2.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        reference2.getRef().child("user_balance").setValue(hasil);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                startActivity(new Intent(TopUpInputAct.this,HomeAct.class));
            }
        });


    }
    public void getUsernameLocal() {
        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
        username_key_new = sharedPreferences.getString(username_key, "");
    }
}
