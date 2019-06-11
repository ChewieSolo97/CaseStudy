package com.example.CaseStudy.LocalDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.CaseStudy.Model.Schedule;
import com.example.CaseStudy.Model.SeasonSchedule;

import java.util.ArrayList;
import java.util.List;

public class CurrentSchedule {

    public static void populateSchedule(Schedule schedule, Context context) {

        SQLiteDatabase db = DatabaseHelper.getInstance(context).getWritableDatabase();
        ContentValues values = new ContentValues();

        for (Schedule.Events event : schedule.getEvents()) {
            for (Schedule.Races race : event.getRaces()) {
                values.put(TableContracts.ScheduleTable.YEAR, schedule.getSeason().getYear());
                values.put(TableContracts.ScheduleTable.TRACK, event.getTrack().getName());
                values.put(TableContracts.ScheduleTable.RACE, race.getName());
                values.put(TableContracts.ScheduleTable.RACE_ID, race.getId());

                db.insert(TableContracts.ScheduleTable.TABLE_NAME, null, values);
                values.clear();
            }
        }
        Update.updatedTable(TableContracts.ScheduleTable.TABLE_NAME, System.currentTimeMillis(), context);
    }

    public static List<SeasonSchedule> getSchedule(Context context, int year) {

        SQLiteDatabase db = DatabaseHelper.getInstance(context).getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TableContracts.ScheduleTable.TABLE_NAME
                + " WHERE years = " + year, null);

        List<SeasonSchedule> list = new ArrayList<>();
        SeasonSchedule race;

        while (cursor.moveToNext()) {

            race = new SeasonSchedule();
            race.setID(cursor.getString(cursor.getColumnIndex(TableContracts.ScheduleTable.RACE_ID)));
            race.setName(cursor.getString(cursor.getColumnIndex(TableContracts.ScheduleTable.RACE)));
            race.setYear(cursor.getInt(cursor.getColumnIndex(TableContracts.ScheduleTable.YEAR)));
            race.setTrack(cursor.getString(cursor.getColumnIndex(TableContracts.ScheduleTable.TRACK)));
            list.add(race);
        }
        return list;
    }
}
