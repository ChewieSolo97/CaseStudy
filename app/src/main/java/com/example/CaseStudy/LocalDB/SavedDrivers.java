package com.example.CaseStudy.LocalDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SavedDrivers {

    public static void saveDriver(String driver, Context context) {
        SQLiteDatabase db = DatabaseHelper.getInstance(context).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TableContracts.SavedDriversTable.NAME, driver);
        db.replace(TableContracts.SavedDriversTable.TABLE_NAME, null, values);
    }

    public static void removeDriver(String driver, Context context) {
        SQLiteDatabase db = DatabaseHelper.getInstance(context).getWritableDatabase();
        db.delete(TableContracts.SavedDriversTable.TABLE_NAME,
                TableContracts.SavedDriversTable.NAME + " = ?", new String[]{driver});
    }

    public static List<String> getDrivers(Context context) {

        SQLiteDatabase db = DatabaseHelper.getInstance(context).getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TableContracts.SavedDriversTable.TABLE_NAME, null);

        List<String> list = new ArrayList<String>();
        while (cursor.moveToNext()) {
            list.add(cursor.getString(cursor.getColumnIndex(TableContracts.SavedDriversTable.NAME)));
        }
        cursor.close();
        return list;
    }
}
