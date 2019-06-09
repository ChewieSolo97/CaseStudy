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
}
