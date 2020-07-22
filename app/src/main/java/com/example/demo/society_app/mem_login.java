package com.example.demo.society_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import com.google.firebase.auth.FirebaseAuth;

public class mem_login extends AppCompatActivity {
    private FirebaseAuth mAuth;

    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText emailt, passwordt;
    private CheckBox rememberMe;
    private Button login, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mem_login);


        emailt = (EditText) findViewById(R.id.edit_text1);
        // rememberMe=(CheckBox)findViewById(R.id.remember);
        passwordt = (EditText) findViewById(R.id.edit_text2);
        login = (Button) findViewById(R.id.btn_login);
        signup = (Button) findViewById(R.id.sign_up);

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            // FirebaseUser mfirebaseuser = mAuth.getCurrentUser();
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mfirebaseuser = mAuth.getCurrentUser();
                //FirebaseUser mFirebaseUser = mAuthListener.g
                if (mfirebaseuser != null) {
                    Toast.makeText(mem_login.this, "You are logged in", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(mem_login.this, home.class);
                    startActivity(i);
                } else {
                    Toast.makeText(mem_login.this, "You are not logged in", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(mem_login.this, mem_login.class);
                    startActivity(i);
                }
            }
        };

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailt.getText().toString();
                String password = passwordt.getText().toString();
                if (email.isEmpty()) {
                    emailt.setError("Please enter email");
                    emailt.requestFocus();
                } else if (password.isEmpty()) {
                    emailt.setError("Please enter email");
                    emailt.requestFocus();
                } else if (email.isEmpty() && password.isEmpty()) {
                    Toast.makeText(mem_login.this, "Please fill the fields", Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty() && password.isEmpty())) {
                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(mem_login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                Toast.makeText(mem_login.this, "Sign in done", Toast.LENGTH_SHORT).show();
                                //Intent i = new Intent(MainActivity.this, home.class);
                                //startActivity(i);
                                startActivity(new Intent(mem_login.this,home.class));
                            } else {
                                //Intent i = new Intent(MainActivity.this, home.class);
                                // startActivity(i);
                                Toast.makeText(mem_login.this, "Sign in error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                } else {
                    Toast.makeText(mem_login.this, "Error Occurred", Toast.LENGTH_SHORT).show();
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mem_login.this,mem_register.class);
                startActivity(i);
            }
        });
    }
}
