package com.example.demo.society_app;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

public class mem_register extends AppCompatActivity {
    private FirebaseAuth mAuth;
    DatabaseReference dataRef;
//    private String userId
//    private String TAG; //
//    private FirebaseFirestore fstore;
//    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText emailt , passwordt , f_name , s_name , number,address ;
    private Button register , signin;
    String first,second,no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mem_register);

        emailt = (EditText)findViewById(R.id.edit_text1);
        passwordt = (EditText)findViewById(R.id.edit_text2);
        register = (Button)findViewById(R.id.register_button);
        mAuth = FirebaseAuth.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailt.getText().toString();
                String password = passwordt.getText().toString();
                if(email.isEmpty())
                {
                    emailt.setError("Please enter email");
                    emailt.requestFocus();
                }
                else if(password.isEmpty())
                {
                    emailt.setError("Please enter email");
                    emailt.requestFocus();
                }
                else if(email.isEmpty() && password.isEmpty())
                {
                    Toast.makeText(mem_register.this,"Please fill the fields",Toast.LENGTH_SHORT).show();
                }
                else if(!(email.isEmpty() && password.isEmpty()))
                {
                    mAuth.createUserWithEmailAndPassword(email , password).addOnCompleteListener(mem_register.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(mem_register.this,"Sign in successful",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(mem_register.this,MainActivity.class));
                            }
                            else
                            {
                                Toast.makeText(mem_register.this,"Sign in successful",Toast.LENGTH_SHORT).show();
                               // startActivity(new Intent(registeration.this,MainActivity.class));
                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(mem_register.this,"Error Occurred",Toast.LENGTH_SHORT).show();
                }
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mem_register.this,mem_login.class);
                startActivity(i);
            }
        });
    }
}