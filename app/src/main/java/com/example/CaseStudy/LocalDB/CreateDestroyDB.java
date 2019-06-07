package com.example.CaseStudy.LocalDB;

public class CreateDestroyDB {

    public static final String CREATE_DRIVER_TABLE = "CREATE TABLE " + TableContracts.DriverTable.TABLE_NAME
            + " (" + TableContracts.DriverTable.NAME + " TEXT PRIMARY KEY, " +
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
            TableContracts.DriverTable.LAPS + " INTEGER, " +
            ")";

    public static final String DESTROY_TABLES = "DROP TABLE IF EXISTS " + TableContracts.DriverTable.TABLE_NAME;
}
