package com.example.demo.society_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class contacts extends AppCompatActivity {
    private ImageView police, ambulance, fire;
    private  static  final  int REQUEST_CALL=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        police = (ImageView) findViewById(R.id.police);
        ambulance = (ImageView) findViewById(R.id.ambulance);
        fire = (ImageView) findViewById(R.id.fire);

        police.setOnClickListener(new View.OnClickListener() {



            public void onClick(View v) {
                makePhonecall();
            }

        });
        ambulance.setOnClickListener(new View.OnClickListener() {


//            @SuppressLint("MissingPermission")
//            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                makePhonecall();



//                int number = 101;
//                Intent callIntent = new Intent(Intent.ACTION_CALL);
//                callIntent.setData(Uri.parse("tel:" + number));
//                startActivity(callIntent);
            }

        });
        fire.setOnClickListener(new View.OnClickListener() {



            public void onClick(View arg0) {
                makePhonecall();
            }

        });
    }
    private  void makePhonecall()
    {



            if(ContextCompat.checkSelfPermission(contacts.this,
                    Manifest.permission.CALL_PHONE) !=PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(contacts.this,
                        new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);

            }
            else{
                String  dial="tel:"+"9924999662";
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }

        }



    }

