package com.example.demo.society_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class payment extends AppCompatActivity {
    private EditText payed , remain;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        payed = (EditText)findViewById(R.id.ed1);
        remain = (EditText)findViewById(R.id.ed2);
        submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                String paid=payed.getText().toString();

                String to_pay=remain.getText().toString();
               // int remain = paid - to_pay;
            }

        }

    );
}

}
