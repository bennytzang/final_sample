package com.example.user.spinner_test.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "spinnerExample";
    private static final String TABLE_NAME = "labels";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";

    public MyDBHelper (Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        String CREATE_ITEM_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_NAME + " TEXT)";
        db.execSQL(CREATE_ITEM_TABLE);
    }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Drop older table if existed
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

            onCreate(db);
        }
    public void insertLabel(String label){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, label);//column name, column value

        // Inserting Row
        db.insert(TABLE_NAME, null, values);//tableName, nullColumnHack, CotentValues
        db.close(); // Closing database connection
    }

    public List<String> getAllLabels(){
        List<String> list = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);//selectQuery,selectedArguments

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(1));//adding 2nd column data
            } while (cursor.moveToNext());
        }
        // closing connection
        cursor.close();
        db.close();
        // returning lables
        return list;
    }
}
