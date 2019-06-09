package com.example.CaseStudy.LocalDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.example.CaseStudy.Model.DriverInfo;
import com.example.CaseStudy.Model.DriverStatistics;


public class Driver {


    // this will populate the drivers table using passed results from the api

    public static void populateDriverInfo(DriverInfo info, Context context) {
        SQLiteDatabase db = DatabaseHelper.getInstance(context).getWritableDatabase();
        ContentValues values = new ContentValues();

        for (DriverInfo.Drivers driver : info.getDrivers()) {
            values.put(TableContracts.DriverTable.NAME, driver.getFull_name());
            values.put(TableContracts.DriverTable.HEIGHT, driver.getHeight());
            values.put(TableContracts.DriverTable.BIRTHDAY, driver.getBirthday());
            values.put(TableContracts.DriverTable.ROOKIE_YEAR, driver.getRookie_year());
            values.put(TableContracts.DriverTable.RESIDENCE, driver.getResidence());
            values.put(TableContracts.DriverTable.BIRTHPLACE, driver.getBirth_place());
            if (driver.getTeam() != null) {
                values.put(TableContracts.DriverTable.TEAM, driver.getTeam().getName());
            } else {
                values.put(TableContracts.DriverTable.TEAM, "No Team");
            }
            if (driver.getCars().size() > 0) {
                values.put(TableContracts.DriverTable.CREWCHIEF, driver.getCars().get(0).getCrew_chief());
                values.put(TableContracts.DriverTable.NUMBER, driver.getCars().get(0).getNumber());
            } else {
                values.put(TableContracts.DriverTable.CREWCHIEF, "No Crew Chief");
                values.put(TableContracts.DriverTable.NUMBER, "No Number");
            }

            db.insert(TableContracts.DriverTable.TABLE_NAME, null, values);
            values.clear();
        }
    }
    public static void populateDriverStats(DriverStatistics stats, Context context) {
        SQLiteDatabase db = DatabaseHelper.getInstance(context).getWritableDatabase();
        ContentValues values = new ContentValues();

        int starts = 0;
        int wins = 0;
        int top5s = 0;
        int top10s = 0;
        int poles = 0;
        int DNF = 0;
        int laps = 0;
        for (DriverStatistics.Drivers driver : stats.getDrivers()) {

            // I had to make this a for loop because there are a few drivers that seem to be missing data

            for (int i = 0 ; i < driver.getTrack_type_splits().size(); i++) {
                starts += driver.getTrack_type_splits().get(i).getStarts();
                wins += driver.getTrack_type_splits().get(i).getWins();
                top5s += driver.getTrack_type_splits().get(i).getTop_5();
                top10s += driver.getTrack_type_splits().get(i).getTop_10();
                poles += driver.getTrack_type_splits().get(i).getPoles();
                DNF += driver.getTrack_type_splits().get(i).getDnf();
                laps += driver.getTrack_type_splits().get(i).getLaps_led();
            }
            values.put(TableContracts.DriverTable.STARTS, starts);
            values.put(TableContracts.DriverTable.WINS, wins);
            values.put(TableContracts.DriverTable.TOP5S, top5s);
            values.put(TableContracts.DriverTable.TOP10S, top10s);
            values.put(TableContracts.DriverTable.POLES, poles);
            values.put(TableContracts.DriverTable.DNF, DNF);
            values.put(TableContracts.DriverTable.LAPS, laps);

            starts = 0;
            wins = 0;
            top5s = 0;
            top10s = 0;
            poles = 0;
            DNF = 0;
            laps = 0;

            db.update(TableContracts.DriverTable.TABLE_NAME, values, "name = ?",
                    new String[]{driver.getFull_name()});
            values.clear();
        }
        //Log.wtf("This should be last wins", String.valueOf(wins));
        Update.updatedTable(TableContracts.DriverTable.TABLE_NAME, System.currentTimeMillis(), context);
    }


    public static void addDriver(String driver, Context context) {
        SQLiteDatabase db = DatabaseHelper.getInstance(context).getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TableContracts.DriverTable.NAME, driver);

        db.insert(TableContracts.DriverTable.TABLE_NAME, null, values);
        db.close();

    }

    public static List<String> getDrivers(Context context) {
        SQLiteDatabase db = DatabaseHelper.getInstance(context).getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TableContracts.DriverTable.TABLE_NAME, null);

        List<String> list = new ArrayList<String>();
        while (cursor.moveToNext()) {
            list.add(cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.DriverTable.NAME)));
            //list.add(cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.DriverTable.WINS)));
        }
        cursor.close();
        return list;
    }

    // this will return one driver
    public static String queryDriver() {
        return null;
    }
}
