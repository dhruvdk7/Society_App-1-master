package com.example.demo.society_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class announcement extends AppCompatActivity {
    ListView listView;
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    viewanno anno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);

        anno=new viewanno();
        listView=(ListView)findViewById(R.id.lsview);
        database=FirebaseDatabase.getInstance();
        ref=database.getReference("MEETING");
        list=new ArrayList<>();
        adapter=new ArrayAdapter<String>(this,R.layout.anno_info,R.id.mtn_info_id,list);


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren()){
                    anno=ds.getValue(viewanno.class);
                    list.add("TOPIC  "+anno.getTopic().toString()+"\n"+"DATE  "+anno.getDate().toString()+" \n"+"TIME  "+anno.getTime().toString());

                }


                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





    }
}
