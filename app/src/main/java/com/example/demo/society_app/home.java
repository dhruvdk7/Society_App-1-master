package com.example.demo.society_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        CardView card1 = (CardView) findViewById(R.id.profile);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this,profile.class);
                startActivity(intent);
            }
        });
        CardView card2 = (CardView) findViewById(R.id.complaint);

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this,Complaint.class);
                startActivity(intent);
            }
        });
        CardView card3 = (CardView) findViewById(R.id.contacts);

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this,contacts.class);
                startActivity(intent);
            }
        });
        CardView card4 = (CardView) findViewById(R.id.payment_id);

        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this,pay.class);
                startActivity(intent);
            }
        });
        CardView card5 = (CardView) findViewById(R.id.announcement_id);

        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this,announcement.class);
                startActivity(intent);
            }
        });

    }
}
