package com.example.CaseStudy.LocalDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.CaseStudy.Model.SeasonResults;
import com.example.CaseStudy.Model.SeasonStandings;

public class Standings {

    public static void populateStandings(SeasonStandings standings, Context context) {

        SQLiteDatabase db = DatabaseHelper.getInstance(context).getWritableDatabase();
        ContentValues values = new ContentValues();

        for (SeasonStandings.Drivers driver : standings.getDrivers()) {
            values.put(TableContracts.ResultsTable.YEAR, standings.getSeason().getYear());
            values.put(TableContracts.ResultsTable.RANK, driver.getRank());
            values.put(TableContracts.ResultsTable.FULL_NAME, driver.getFull_name());
            values.put(TableContracts.ResultsTable.POINTS, driver.getPoints());
            values.put(TableContracts.ResultsTable.STARTS, driver.getStarts());
            values.put(TableContracts.ResultsTable.WINS, driver.getWins());
            values.put(TableContracts.ResultsTable.POLES, driver.getPoles());
            values.put(TableContracts.ResultsTable.TOP5, driver.getTop_5());
            values.put(TableContracts.ResultsTable.TOP10, driver.getTop_10());
            values.put(TableContracts.ResultsTable.DNF, driver.getDnf());
            values.put(TableContracts.ResultsTable.LAPS_LED, driver.getLaps_led());
            values.put(TableContracts.ResultsTable.AVG_START, driver.getAvg_start_position());
            values.put(TableContracts.ResultsTable.AVG_FINISH, driver.getAvg_finish_position());

            db.insert(TableContracts.ResultsTable.TABLE_NAME, null, values);
            values.clear();
        }
    }


    public static SeasonResults queryStandings(String name, int year, Context context) {


        SQLiteDatabase db = DatabaseHelper.getInstance(context).getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TableContracts.ResultsTable.TABLE_NAME +
                " WHERE name = '" + name + "' AND year = '" + year + "'", null);

        SeasonResults results = new SeasonResults();
        cursor.moveToNext();

        results.setYear(cursor.getString(cursor.getColumnIndex(TableContracts.ResultsTable.YEAR)));
        results.setRank(cursor.getInt(cursor.getColumnIndex(TableContracts.ResultsTable.RANK)));
        results.setFull_name(cursor.getString(cursor.getColumnIndex(TableContracts.ResultsTable.FULL_NAME)));
        results.setPoints(cursor.getInt(cursor.getColumnIndex(TableContracts.ResultsTable.POINTS)));
        results.setStarts(cursor.getInt(cursor.getColumnIndex(TableContracts.ResultsTable.STARTS)));
        results.setWins(cursor.getInt(cursor.getColumnIndex(TableContracts.ResultsTable.WINS)));
        results.setPoles(cursor.getInt(cursor.getColumnIndex(TableContracts.ResultsTable.POLES)));
        results.setTop5(cursor.getInt(cursor.getColumnIndex(TableContracts.ResultsTable.TOP5)));
        results.setTop10(cursor.getInt(cursor.getColumnIndex(TableContracts.ResultsTable.TOP10)));
        results.setDnf(cursor.getInt(cursor.getColumnIndex(TableContracts.ResultsTable.DNF)));
        results.setLaps_led(cursor.getInt(cursor.getColumnIndex(TableContracts.ResultsTable.LAPS_LED)));
        results.setAvg_start(cursor.getDouble(cursor.getColumnIndex(TableContracts.ResultsTable.AVG_START)));
        results.setAvg_finish(cursor.getDouble(cursor.getColumnIndex(TableContracts.ResultsTable.AVG_FINISH)));

        cursor.close();

        return results;
    }
}
