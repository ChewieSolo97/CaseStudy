package com.example.CaseStudy.LocalDB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper sInstance;

    private static final String DATABASE_NAME = "database_name";
    //    private static final String DATABASE_TABLE = "table_name";
    private static final int DATABASE_VERSION = 1;

    public static synchronized DatabaseHelper getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CreateDestroyDB.CREATE_DRIVER_TABLE);
            db.execSQL(CreateDestroyDB.CREATE_UPDATE_TABLE);
            db.execSQL(CreateDestroyDB.CREATE_SAVED_DRIVERS_TABLE);
            db.execSQL(CreateDestroyDB.CREATE_RESULTS_TABLE);
            db.execSQL(CreateDestroyDB.CREATE_SCHEDULE_TABLE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(CreateDestroyDB.DESTROY_DRIVER_TABLE);
        db.execSQL(CreateDestroyDB.DESTROY_UPDATE_TABLE);
        db.execSQL(CreateDestroyDB.DESTROY_SAVED_DRIVERS_TABLE);
        db.execSQL(CreateDestroyDB.DESTROY_RESULTS_TABLE);
        db.execSQL(CreateDestroyDB.DESTROY_SCHEDULE_TABLE);
        onCreate(db);
    }

    /**
     * Constructor should be private to prevent direct instantiation.
     * make call to static method "getInstance()" instead.
     */
    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}