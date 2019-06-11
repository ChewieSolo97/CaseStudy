package com.example.CaseStudy.DriverRace;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.CaseStudy.DriverProfile.RaceData;
import com.example.CaseStudy.Model.RaceStandings;
import com.example.CaseStudy.R;
import com.example.CaseStudy.Retrofit.APICalls;

public class RaceResults extends AppCompatActivity {

    public static String name;
    public static String ID;


    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race_results);
        ResultsPagerAdapter resultsPagerAdapter = new ResultsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.results_view_pager);
        viewPager.setAdapter(resultsPagerAdapter);
        TabLayout tabs = findViewById(R.id.results_tabs);
        tabs.setupWithViewPager(viewPager);
        title = findViewById(R.id.results_title);
        name = getIntent().getStringExtra("NAME");
        title.setText(name);
        ID = getIntent().getStringExtra("ID");

        //APICalls.getRaceResults();
    }
}
