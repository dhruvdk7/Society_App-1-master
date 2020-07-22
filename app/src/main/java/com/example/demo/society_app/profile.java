package com.example.demo.society_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import javax.annotation.Nullable;

public class profile extends AppCompatActivity {
    private EditText emailt , f_name , s_name , number,address ;
    private FirebaseDatabase rootNode;
    FirebaseAuth mAuth;
    int maxid = 0;
    memberadd madd;
   private DatabaseReference reference ;
    private String userId;
    private Button confirm ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        f_name = findViewById(R.id.f_name);
        s_name = (EditText)findViewById(R.id.s_name);
        number = (EditText)findViewById(R.id.number);
        address = (EditText)findViewById(R.id.address);
        emailt = (EditText)findViewById(R.id.edit_text1);
        confirm = (Button)findViewById(R.id.confirm_button);
        madd = new memberadd();

        mAuth = FirebaseAuth.getInstance();

                rootNode = FirebaseDatabase.getInstance();
                 reference = rootNode.getReference("users");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            maxid = (int) dataSnapshot.getChildrenCount();
                        } else {
                            //
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(f_name.length() == 0) {
                            f_name.setError("enter first name");
                        } else if (emailt.length() == 0) {
                            emailt.setError("Add email");
                        } else if (number.length() == 0) {
                            number.setError("enter number");
                        }
                        else if (s_name.length() == 0) {
                            emailt.setError("enter surname");}
                            else if (number.length() == 0) {
                                number.setError("enter number");
                            }
            else
                        {
                            madd.setMemberemail(emailt.getText().toString());
                            madd.setMemberfname(f_name.getText().toString());
                            madd.setMembersname(s_name.getText().toString());

                          //  madd.setMembernumber(number.getText().toString());
                            madd.setMemberadress(address.getText().toString());

                            madd.setMembernumber(number.getText().toString());
                            reference.child(String.valueOf(maxid + 1)).setValue(madd).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(profile.this, "MEMBER ADDED", Toast.LENGTH_SHORT).show();

                                      //  Intent intent = new Intent(profile.this,Complaint.class);
                                      //  startActivity(intent);
                                    } else {
                                        Toast.makeText(profile.this, "MEMBER NOT  ADDED", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                        }
                        }
        });
    }
}
