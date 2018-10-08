package com.example.sys9.task1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AllUserActivity extends AppCompatActivity {
ListView listView;
public  static  final  String MSG_KEY="msg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth2);
        listView = findViewById(R.id.listview2);


        ExampleDb db = new ExampleDb(this);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList = db.getDataFromDatabase();
        CustomAdapter adapter = new CustomAdapter(AllUserActivity.this, arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView t1=findViewById(R.id.txtview);

                String username=t1.getText().toString();

                startActivity(new Intent(AllUserActivity.this,Main5Activity.class).putExtra(MSG_KEY,username));
            }


        });
    }
}
