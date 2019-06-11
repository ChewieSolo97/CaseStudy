package com.example.CaseStudy.DriverProfile;

import android.util.Log;

import com.example.CaseStudy.Model.RaceStandings;

public class RaceData {


    public static RaceStandings standings;

    public static RaceStandings getStandings() {
        return standings;
    }

    public static void setStandings(RaceStandings standings) {
        Log.wtf("am i in here?", standings.getName());
        RaceData.standings = standings;
    }


}
