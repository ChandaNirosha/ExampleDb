package com.example.sys9.task1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {


    EditText e1, e2, e3, e4;

    Button signUp;
    String username,email,password,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        e1 = (EditText) findViewById(R.id.etxt1);
        e2 = (EditText) findViewById(R.id.etxt2);
        e3 = (EditText) findViewById(R.id.etxt3);
        e4 = (EditText) findViewById(R.id.etxt4);





        signUp = (Button) findViewById(R.id.btn1);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = e1.getText().toString().trim();
                email = e2.getText().toString().trim();
                password = e3.getText().toString().trim();
                phone = e4.getText().toString().trim();

                ExampleDb db = new ExampleDb(SignUpActivity.this);
                db.insert(username, email, password, phone);
                Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

    }

}




