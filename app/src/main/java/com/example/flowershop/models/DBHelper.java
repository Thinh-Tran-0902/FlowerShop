package com.example.flowershop.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

import com.example.flowershop.Database.DataBaseFlowerShop;
import com.example.flowershop.Users;


public class DBHelper extends SQLiteOpenHelper {
    private static final String DBNAME = "FlowerShop";
    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

      //  sqLiteDatabase.execSQL("create table users(" +
        //        "username TEXT primary key ,password TEXT, name TEXT, " +
        //        " address TEXT, gender TEXT , roleId INTEGER) ");

        sqLiteDatabase.execSQL(DataBaseFlowerShop.CREATE_TABLE_User);

    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" Drop table if exists " + DataBaseFlowerShop.TABLE_User);
        sqLiteDatabase.execSQL("Drop table if exists orders");
        onCreate(sqLiteDatabase);
    }
    public Boolean insertData(Users users){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
         values.put("username",users.getUsername());
         values.put("password",users.getPassword());
         values.put("name",users.getName());
         values.put("address",users.getAddress());
         values.put("gender",users.getGender());
         values.put("roleId",users.getRoleId());
        long result = db.insert("User",null, values);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkUsername(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from User where username=?", new String[] {username});
        if(cursor.getCount()>0){
            return true;
        }else
            return false;
    }

    public Boolean checkUsernamePasswordForUser(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from User where username=? and password=? and roleId=2", new String[] {username,password});
        if(cursor.getCount()>0){
            return true;
        }else
            return false;
    }
    public Boolean checkUsernamePasswordForAdmin(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from User where username=? and password=? and roleId=1", new String[] {username,password});
        if(cursor.getCount()>0){
            return true;
        }else
            return false;
    }




}
