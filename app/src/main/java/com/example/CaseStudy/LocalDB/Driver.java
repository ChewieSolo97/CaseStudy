package com.example.CaseStudy.LocalDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import POJO.Classes.DriverInfo;
import POJO.Classes.DriverStatistics;


public class Driver {


    // this will populate the drivers table using passed results from the api
    public static void populateDriver(DriverInfo info, DriverStatistics stats, Context context) {
        SQLiteDatabase db = DatabaseHelper.getInstance(context).getWritableDatabase();
        ContentValues values = new ContentValues();

        for (DriverInfo.Drivers driver : info.getDrivers()) {
            values.put(TableContracts.DriverTable.NAME, driver.getFull_name());
            values.put(TableContracts.DriverTable.HEIGHT, driver.getHeight());
            values.put(TableContracts.DriverTable.BIRTHDAY, driver.getBirthday());
            values.put(TableContracts.DriverTable.ROOKIE_YEAR, driver.getRookie_year());
            values.put(TableContracts.DriverTable.RESIDENCE, driver.getResidence());
            values.put(TableContracts.DriverTable.BIRTHPLACE, driver.getBirth_place());
            values.put(TableContracts.DriverTable.TEAM, driver.getTeam().getName());
            values.put(TableContracts.DriverTable.CREWCHIEF, driver.getCars().get(0).getCrew_chief());
            values.put(TableContracts.DriverTable.NUMBER, driver.getCars().get(0).getNumber());

            db.insert(TableContracts.DriverTable.TABLE_NAME, null, values);
            values.clear();
        }
        int starts = 0;
        int wins = 0;
        int top5s = 0;
        int top10s = 0;
        int poles = 0;
        int DNF = 0;
        int laps = 0;
        for (DriverStatistics.Drivers driver : stats.getDrivers()) {
            starts = driver.getTrack_type_splits().get(0).getStarts() +
                    driver.getTrack_type_splits().get(1).getStarts() +
                    driver.getTrack_type_splits().get(2).getStarts() +
                    driver.getTrack_type_splits().get(3).getStarts();
            values.put(TableContracts.DriverTable.STARTS, starts);
            wins = driver.getTrack_type_splits().get(0).getWins() +
                    driver.getTrack_type_splits().get(1).getWins() +
                    driver.getTrack_type_splits().get(2).getWins() +
                    driver.getTrack_type_splits().get(3).getWins();
            values.put(TableContracts.DriverTable.STARTS, wins);
            top5s = driver.getTrack_type_splits().get(0).getTop_5() +
                    driver.getTrack_type_splits().get(1).getTop_5() +
                    driver.getTrack_type_splits().get(2).getTop_5() +
                    driver.getTrack_type_splits().get(3).getTop_5();
            values.put(TableContracts.DriverTable.STARTS, top5s);
            top10s = driver.getTrack_type_splits().get(0).getTop_10() +
                    driver.getTrack_type_splits().get(1).getTop_10() +
                    driver.getTrack_type_splits().get(2).getTop_10() +
                    driver.getTrack_type_splits().get(3).getTop_10();
            values.put(TableContracts.DriverTable.STARTS, top10s);
            poles = driver.getTrack_type_splits().get(0).getPoles() +
                    driver.getTrack_type_splits().get(1).getPoles() +
                    driver.getTrack_type_splits().get(2).getPoles() +
                    driver.getTrack_type_splits().get(3).getPoles();
            values.put(TableContracts.DriverTable.STARTS, poles);
            DNF = driver.getTrack_type_splits().get(0).getDnf() +
                    driver.getTrack_type_splits().get(1).getDnf() +
                    driver.getTrack_type_splits().get(2).getDnf() +
                    driver.getTrack_type_splits().get(3).getDnf();
            values.put(TableContracts.DriverTable.STARTS, DNF);
            laps = driver.getTrack_type_splits().get(0).getLaps_led() +
                    driver.getTrack_type_splits().get(1).getLaps_led() +
                    driver.getTrack_type_splits().get(2).getLaps_led() +
                    driver.getTrack_type_splits().get(3).getLaps_led();
            values.put(TableContracts.DriverTable.STARTS, laps);

            db.update(TableContracts.DriverTable.TABLE_NAME, values, "name = "
                    + driver.getFull_name(), null);
            values.clear();
        }

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
        }
        cursor.close();
        return list;
    }

    // this will return one driver
    public static String queryDriver() {
        return null;
    }
}
