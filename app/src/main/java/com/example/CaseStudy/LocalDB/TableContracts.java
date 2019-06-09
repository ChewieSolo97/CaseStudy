package com.example.CaseStudy.LocalDB;

import android.provider.BaseColumns;

public final class TableContracts {

    private TableContracts() {

    }

    public static class DriverTable implements BaseColumns {

        public static final String TABLE_NAME = "driver";

        public static final String NAME = "name";
        public static final String HEIGHT = "height";
        public static final String BIRTHDAY = "birthday";
        public static final String ROOKIE_YEAR = "rookie_year";
        public static final String RESIDENCE = "residence";
        public static final String BIRTHPLACE = "birthplace";
        public static final String TEAM = "team";
        public static final String CREWCHIEF = "crew_chief";
        public static final String NUMBER = "number";
        public static final String STARTS = "starts";
        public static final String WINS = "wins";
        public static final String TOP5S = "top5s";
        public static final String TOP10S = "top10s";
        public static final String POLES = "poles";
        public static final String DNF = "dnf";
        public static final String LAPS = "laps";
    }

    public static class UpdatesTable implements BaseColumns {

        public static final String TABLE_NAME = "updates";
        public static final String NAME = "table_name";
        public static final String LAST_UPDATE = "last_update";
    }

    public static class SavedDriversTable implements BaseColumns {

        public static final String TABLE_NAME = "saved_drivers";
        public static final String NAME = "name";
    }
}
