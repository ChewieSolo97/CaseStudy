package com.example.CaseStudy.LocalDB;

public class CreateDestroyDB {

    public static final String CREATE_DRIVER_TABLE = "CREATE TABLE " +
            TableContracts.DriverTable.TABLE_NAME + " (" +
            TableContracts.DriverTable.NAME + " TEXT PRIMARY KEY, " +
            TableContracts.DriverTable.HEIGHT + " INTEGER, " +
            TableContracts.DriverTable.BIRTHDAY + " TEXT, " +
            TableContracts.DriverTable.ROOKIE_YEAR + " INTEGER, " +
            TableContracts.DriverTable.RESIDENCE + " TEXT, " +
            TableContracts.DriverTable.BIRTHPLACE + " TEXT, " +
            TableContracts.DriverTable.TEAM + " TEXT, " +
            TableContracts.DriverTable.CREWCHIEF + " TEXT, " +
            TableContracts.DriverTable.NUMBER + " TEXT, " +
            TableContracts.DriverTable.STARTS + " INTEGER, " +
            TableContracts.DriverTable.WINS + " INTEGER, " +
            TableContracts.DriverTable.TOP5S + " INTEGER, " +
            TableContracts.DriverTable.TOP10S + " INTEGER, " +
            TableContracts.DriverTable.POLES + " INTEGER, " +
            TableContracts.DriverTable.DNF + " INTEGER, " +
            TableContracts.DriverTable.LAPS + " INTEGER " +
            ")";

    public static final String DESTROY_DRIVER_TABLE = "DROP TABLE IF EXISTS "
            + TableContracts.DriverTable.TABLE_NAME;

    public static final String CREATE_UPDATE_TABLE = "CREATE TABLE "
            + TableContracts.UpdatesTable.TABLE_NAME
            + " (" + TableContracts.UpdatesTable.NAME + " TEXT, "
            + TableContracts.UpdatesTable.LAST_UPDATE + " INTEGER, " +
            "PRIMARY KEY (" + TableContracts.UpdatesTable.NAME
            + ", " + TableContracts.UpdatesTable.LAST_UPDATE + ") )";

    public static final String DESTROY_UPDATE_TABLE = "DROP TABLE IF EXISTS "
            + TableContracts.UpdatesTable.TABLE_NAME;

    public static final String CREATE_SAVED_DRIVERS_TABLE = "CREATE TABLE " +
            TableContracts.SavedDriversTable.TABLE_NAME + " ("
            + TableContracts.SavedDriversTable.NAME + " TEXT PRIMARY KEY)";

    public static final String DESTROY_SAVED_DRIVERS_TABLE = "DROP TABLE IF EXISTS "
            + TableContracts.SavedDriversTable.TABLE_NAME;

    public static final String CREATE_RESULTS_TABLE = " CREATE TABLE " +
            TableContracts.ResultsTable.TABLE_NAME + " (" +
            TableContracts.ResultsTable.YEAR + " TEXT, " +
            TableContracts.ResultsTable.RANK + " INTEGER, " +
            TableContracts.ResultsTable.FULL_NAME + " TEXT, " +
            TableContracts.ResultsTable.POINTS + " INTEGER, " +
            TableContracts.ResultsTable.STARTS + " INTEGER, " +
            TableContracts.ResultsTable.WINS + " INTEGER, " +
            TableContracts.ResultsTable.POLES + " INTEGER, " +
            TableContracts.ResultsTable.TOP5 + " INTEGER, " +
            TableContracts.ResultsTable.TOP10 + " INTEGER, " +
            TableContracts.ResultsTable.DNF + " INTEGER, " +
            TableContracts.ResultsTable.LAPS_LED + " INTEGER, " +
            TableContracts.ResultsTable.AVG_START + " REAL, " +
            TableContracts.ResultsTable.AVG_FINISH + " REAL, " +
            "PRIMARY KEY (" + TableContracts.ResultsTable.YEAR
            + ", " + TableContracts.ResultsTable.RANK + ") )";

    public static final String DESTROY_RESULTS_TABLE = "DROP TABLE IF EXISTS "
            + TableContracts.ResultsTable.TABLE_NAME;

    public static final String CREATE_SCHEDULE_TABLE = "CREATE TABLE " +
            TableContracts.ScheduleTable.TABLE_NAME + " (" +
            TableContracts.ScheduleTable.RACE_ID + " TEXT PRIMARY KEY, " +
            TableContracts.ScheduleTable.YEAR + " TEXT, " +
            TableContracts.ScheduleTable.TRACK + " TEXT, " +
            TableContracts.ScheduleTable.RACE + " TEXT )";

    public static final String DESTROY_SCHEDULE_TABLE = "DROP TABLE IF EXISTS "
            + TableContracts.ScheduleTable.TABLE_NAME;

}
