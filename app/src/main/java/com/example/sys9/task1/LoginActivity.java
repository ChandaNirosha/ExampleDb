package com.example.sys9.task1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    Button login;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        login=(Button)findViewById(R.id.btn1);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(LoginActivity.this,AllUserActivity.class);
                startActivity(i);
            }
        });

        signUp=(Button)findViewById(R.id.btn2) ;
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(i);
            }
        });



    }
}
