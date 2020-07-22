package com.example.demo.society_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class Complaint extends AppCompatActivity {
    private EditText name , complaint  ;
    private FirebaseDatabase rootNode;
    FirebaseAuth mAuth;
    complaintadd cadd;
    private DatabaseReference reference ;
    int maxid = 0;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
        name = (EditText)findViewById(R.id.ed1);
        complaint = (EditText)findViewById(R.id.ed2);
        submit = (Button)findViewById(R.id.btn_submit);

        cadd = new complaintadd();

        mAuth = FirebaseAuth.getInstance();

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("complaint");
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

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.length() == 0) {
                    name.setError("enter name");
                } else if (complaint.length() == 0) {
                    complaint.setError("enter complaint");
                } else {

                    cadd.setMembername(name.getText().toString());
                    cadd.setComplaint(complaint.getText().toString());

                    reference.child(String.valueOf(maxid + 1)).setValue(cadd).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Complaint.this, "COMPLAINT ADDED", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Complaint.this, "COMPLAINT ADDED", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });
    }
}
