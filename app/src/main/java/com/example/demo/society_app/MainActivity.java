package com.example.demo.society_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private ImageView logo;

    long splashTimeOut=4000;
    Thread thread;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        firebaseAuth = FirebaseAuth.getInstance();
        final FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        thread= new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(splashTimeOut);
                    if (firebaseUser != null){
                        Intent i = new Intent(MainActivity.this, home.class);
                        startActivity(i);
                        finish();
                    }else {
                        Intent i = new Intent(MainActivity.this,mem_login.class);
                        startActivity(i);
                        finish();
                    }


                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

            }
        });

        thread.start();





       logo = (ImageView) findViewById(R.id.logo);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(MainActivity.this, home.class);
                    startActivity(i);
                    finish();
                }
            }, splashTimeOut);

    }
}
