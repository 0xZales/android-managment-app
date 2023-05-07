package com.example.tiggestion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseClass extends SQLiteOpenHelper {
    public static  final String DBNAME ="user.db";

    public DatabaseClass(@Nullable Context context) {
        super(context,"user.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table users(email TEXT primary key,password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
    }

    public Boolean createUser(String email,String password){
        SQLiteDatabase database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long result = database.insert("users",null,contentValues);
        if(result==-1) return false;
        return true;


    }
    public Boolean checkEmail(String email){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("Select * from users where email = ?",new String[]{email});

        if(cursor.getCount()>0) return true;
        return false;


    }
    public Boolean authentication(String email,String password){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("Select * from users where email = ? and password=?",new String[]{email,password});

        if(cursor.getCount()>0) return true;
        return false;


    }
}
