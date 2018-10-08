package com.example.sys9.task1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class Main5Activity extends AppCompatActivity {
    ListView listView;
    TextView username,password,emailId,phoneno;
    ArrayList<Map<String,String>> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Intent intent=getIntent();
        String user=intent.getStringExtra(AllUserActivity.MSG_KEY);

        ExampleDb  db= new ExampleDb(this);
        arrayList = new ArrayList<>();
        arrayList = db.getUserData(user);

        username=findViewById(R.id.t1);
        password=findViewById(R.id.t2);
        emailId=findViewById(R.id.t3);
        phoneno=findViewById(R.id.t4);

        username.setText(arrayList.get(0).get(ExampleDb.USERNAME));
        password.setText(arrayList.get(0).get(ExampleDb.PASSWORD));
        emailId.setText(arrayList.get(0).get(ExampleDb.EMAIL));
        phoneno.setText(arrayList.get(0).get(ExampleDb.PHONE));

        
    }
}
