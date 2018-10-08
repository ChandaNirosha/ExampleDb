package com.example.sys9.task1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExampleDb extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "sample_db";
    private static final String TABLE_NAME = "student";

    public static final String USERNAME = "USER_NAME";
    public static final String EMAIL = "EMAIL";
    public static final String PASSWORD = "PASSWORD";
    public static final String PHONE = "PHONE";

    public ExampleDb(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + "("
                + USERNAME + " TEXT,"
                + EMAIL + " TEXT,"
                + PASSWORD + " TEXT,"
                + PHONE + " TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    public void insert(String username, String email, String password, String phone) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERNAME, username);
        contentValues.put(EMAIL, email);
        contentValues.put(PASSWORD, password);
        contentValues.put(PHONE, phone);

        sqLiteDatabase.insert(TABLE_NAME, null,contentValues);
    }

    public ArrayList<String> getDataFromDatabase() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        ArrayList<String> data = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT USER_NAME FROM " + TABLE_NAME, null);

        if (cursor != null && cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                data.add(cursor.getString(0));
                cursor.moveToNext();
            }
        }
        return data;

    }

    public ArrayList<Map<String, String>> getUserData(String username) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        ArrayList<Map<String, String>> arrayList = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM STUDENT WHERE USER_NAME = ? ", new String[]{username});
        if (cursor != null && cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Map<String, String> map = new HashMap();
                map.put(USERNAME, cursor.getString(0));
                map.put(PASSWORD, cursor.getString(1));
                map.put(EMAIL, cursor.getString(2));
                map.put(PHONE, cursor.getString(3));
                arrayList.add(map);
                cursor.moveToNext();
            }
        }
        return arrayList;
    }
            }





