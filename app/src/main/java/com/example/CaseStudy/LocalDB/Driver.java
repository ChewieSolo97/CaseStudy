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
import com.example.CaseStudy.Model.DriverObject;
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

    public static List<DriverObject> getDrivers(Context context) {
        SQLiteDatabase db = DatabaseHelper.getInstance(context).getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TableContracts.DriverTable.TABLE_NAME, null);

        List<DriverObject> list = new ArrayList<>();
        DriverObject driver;
        while (cursor.moveToNext()) {
            driver = new DriverObject();
            driver.setName(cursor.getString(cursor.getColumnIndex(TableContracts.DriverTable.NAME)));
            driver.setHeight(cursor.getInt(cursor.getColumnIndex(TableContracts.DriverTable.HEIGHT)));
            driver.setBirthday(cursor.getString(cursor.getColumnIndex(TableContracts.DriverTable.BIRTHDAY)));
            driver.setRookieYear(cursor.getInt(cursor.getColumnIndex(TableContracts.DriverTable.ROOKIE_YEAR)));
            driver.setResidence(cursor.getString(cursor.getColumnIndex(TableContracts.DriverTable.RESIDENCE)));
            driver.setBirthplace(cursor.getString(cursor.getColumnIndex(TableContracts.DriverTable.BIRTHPLACE)));
            driver.setTeam(cursor.getString(cursor.getColumnIndex(TableContracts.DriverTable.TEAM)));
            driver.setCrewchief(cursor.getString(cursor.getColumnIndex(TableContracts.DriverTable.CREWCHIEF)));
            driver.setNumber(cursor.getString(cursor.getColumnIndex(TableContracts.DriverTable.NUMBER)));
            driver.setStarts(cursor.getInt(cursor.getColumnIndex(TableContracts.DriverTable.STARTS)));
            driver.setWins(cursor.getInt(cursor.getColumnIndex(TableContracts.DriverTable.WINS)));
            driver.setTop5s(cursor.getInt(cursor.getColumnIndex(TableContracts.DriverTable.TOP5S)));
            driver.setTop10s(cursor.getInt(cursor.getColumnIndex(TableContracts.DriverTable.TOP10S)));
            driver.setPoles(cursor.getInt(cursor.getColumnIndex(TableContracts.DriverTable.POLES)));
            driver.setDnf(cursor.getInt(cursor.getColumnIndex(TableContracts.DriverTable.DNF)));
            driver.setLapsled(cursor.getInt(cursor.getColumnIndex(TableContracts.DriverTable.LAPS)));

            list.add(driver);
        }
        cursor.close();
        return list;
    }

    // this will return one driver
    public static DriverObject queryDriver(String name, Context context) {

        SQLiteDatabase db = DatabaseHelper.getInstance(context).getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TableContracts.DriverTable.TABLE_NAME +
                " WHERE name = '" + name + "'", null);

        DriverObject driver;
        cursor.moveToNext();
            driver = new DriverObject();
            driver.setName(cursor.getString(cursor.getColumnIndex(TableContracts.DriverTable.NAME)));
            driver.setHeight(cursor.getInt(cursor.getColumnIndex(TableContracts.DriverTable.HEIGHT)));
            driver.setBirthday(cursor.getString(cursor.getColumnIndex(TableContracts.DriverTable.BIRTHDAY)));
            driver.setRookieYear(cursor.getInt(cursor.getColumnIndex(TableContracts.DriverTable.ROOKIE_YEAR)));
            driver.setResidence(cursor.getString(cursor.getColumnIndex(TableContracts.DriverTable.RESIDENCE)));
            driver.setBirthplace(cursor.getString(cursor.getColumnIndex(TableContracts.DriverTable.BIRTHPLACE)));
            driver.setTeam(cursor.getString(cursor.getColumnIndex(TableContracts.DriverTable.TEAM)));
            driver.setCrewchief(cursor.getString(cursor.getColumnIndex(TableContracts.DriverTable.CREWCHIEF)));
            driver.setNumber(cursor.getString(cursor.getColumnIndex(TableContracts.DriverTable.NUMBER)));
            driver.setStarts(cursor.getInt(cursor.getColumnIndex(TableContracts.DriverTable.STARTS)));
            driver.setWins(cursor.getInt(cursor.getColumnIndex(TableContracts.DriverTable.WINS)));
            driver.setTop5s(cursor.getInt(cursor.getColumnIndex(TableContracts.DriverTable.TOP5S)));
            driver.setTop10s(cursor.getInt(cursor.getColumnIndex(TableContracts.DriverTable.TOP10S)));
            driver.setPoles(cursor.getInt(cursor.getColumnIndex(TableContracts.DriverTable.POLES)));
            driver.setDnf(cursor.getInt(cursor.getColumnIndex(TableContracts.DriverTable.DNF)));
            driver.setLapsled(cursor.getInt(cursor.getColumnIndex(TableContracts.DriverTable.LAPS)));

        cursor.close();
        return driver;
    }
}
