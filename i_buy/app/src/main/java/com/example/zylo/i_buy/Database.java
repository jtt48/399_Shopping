package com.example.zylo.i_buy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Zylo on 11/8/2015.
 */
public class Database extends SQLiteOpenHelper {
    public Database(Context context) {
        super(context, "item_list.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE item_list (ID INTEGER, NAME varchar(255))";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void set_name(String name)
    {
        SQLiteDatabase db = getWritableDatabase();

        // activate if you need to clear the table.
        db.delete("item_list",null,null);

        ContentValues values = new ContentValues();

        values.put("ID", 1);
        values.put("NAME", name);

        db.insert("item_list",null,values );

        db.close();

    }

    public String get_name()
    {
        String string = "";
        SQLiteDatabase db = getReadableDatabase();

        String sql = "SELECT * FROM item_list ORDER BY ID";
        Cursor curssor = db.rawQuery(sql, null);
        int i = 0;
        while(curssor.moveToNext())
        {
            string = curssor.getString(i);
            i++;
        }
        db.close();
        return string;


    }
}
