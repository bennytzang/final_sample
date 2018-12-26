package com.example.penguin.sqlitetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "HotlineDB";
    private static final int version = 1;


    MyDBHelper(Context context){
        super(context, DB_NAME, null,version );
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
     db.execSQL("CREATE TABLE IF NOT EXISTS  myTable(_id INTEGER PRIMARY KEY,name VARCHAR(32),phone VARCHAR, email VARCHAR NO NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS myTable");
        onCreate(db);
    }
}
