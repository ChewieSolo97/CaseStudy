package com.example.CaseStudy.LocalDB;

public class CreateDestroyDB {

    public static final String CREATE_TABLES = "CREATE TABLE " + DriverTableContract.DriverTable.TABLE_NAME
            + " (" + DriverTableContract.DriverTable.NAME + " TEXT PRIMARY KEY)";

    public static final String DESTROY_TABLES = "DROP TABLE IF EXISTS " + DriverTableContract.DriverTable.TABLE_NAME;
}
