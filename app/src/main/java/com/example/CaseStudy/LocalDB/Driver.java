package com.example.CaseStudy.LocalDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


public class Driver {

    // this hold all the methods for interacting with the driver table


    public static void addDriver(String driver, Context context) {
        SQLiteDatabase db = DatabaseHelper.getInstance(context).getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DriverTableContract.DriverTable.NAME, driver);

        db.insert(DriverTableContract.DriverTable.TABLE_NAME, null, values);
        db.close();

    }

    public static List<String> getDrivers(Context context) {
        SQLiteDatabase db = DatabaseHelper.getInstance(context).getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DriverTableContract.DriverTable.TABLE_NAME, null);

        List<String> list = new ArrayList<String>();
        while (cursor.moveToNext()) {
            list.add(cursor.getString(cursor.getColumnIndexOrThrow(DriverTableContract.DriverTable.NAME)));
        }
        return list;
    }

    // this will return one driver
    public static String queryDriver() {
        return null;
    }
}
