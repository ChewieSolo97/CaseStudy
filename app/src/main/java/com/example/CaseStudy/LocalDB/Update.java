package com.example.CaseStudy.LocalDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Update {

    public static void updatedTable(String tableName, Long timeStamp, Context context) {
        SQLiteDatabase db = DatabaseHelper.getInstance(context).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TableContracts.UpdatesTable.NAME, tableName);
        values.put(TableContracts.UpdatesTable.LAST_UPDATE, timeStamp);
        db.replace(TableContracts.UpdatesTable.TABLE_NAME, null, values);
    }
}
