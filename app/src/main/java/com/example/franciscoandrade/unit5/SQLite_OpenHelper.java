package com.example.franciscoandrade.unit5;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by franciscoandrade on 1/23/18.
 */

public class SQLite_OpenHelper extends SQLiteOpenHelper {

    static final int DB_VERSION= 1;


    public SQLite_OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        onUpgrade(db, 0, DB_VERSION);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if(oldVersion<1){
            String query= "CREATE TABLE person(_id INTEGER PRIMARY KEY autoincrement, name TEXT);";
            db.execSQL(query);
        }
    }


    public  void addPerson(String name){
        ContentValues values= new ContentValues();
        values.put("name", name);
        this.getWritableDatabase().insert("colors", null, values);
    }

    //Method allow to open DB
    public void openDB(){
        this.getWritableDatabase();
    }

    //Method allow to close DB
    public void closeDB(){
        this.close();
    }

}
