package com.example.sys9.task1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> arr = new ArrayList<>();



    public CustomAdapter(AllUserActivity fourthActivity, ArrayList<String> arrayList) {
        context = fourthActivity;
        arr = arrayList;
    }



    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View customView;
        customView = LayoutInflater.from(context).inflate(R.layout.activity_custom_adapter, viewGroup, false);

        TextView name =  customView.findViewById(R.id.txtview);


        name.setText( arr.get(i));


        return customView;
    }
    }

