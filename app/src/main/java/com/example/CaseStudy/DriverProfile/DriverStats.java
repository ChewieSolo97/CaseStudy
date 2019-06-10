package com.example.CaseStudy.DriverProfile;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.util.Log;
import android.widget.TextView;

import com.example.CaseStudy.LocalDB.TableContracts;
import com.example.CaseStudy.MainPage.MainActivity;
import com.example.CaseStudy.Model.Schedule;
import com.example.CaseStudy.Model.SeasonSchedule;
import com.example.CaseStudy.R;
import com.example.CaseStudy.Retrofit.APICalls;

import java.util.ArrayList;
import java.util.Calendar;

public class DriverStats extends AppCompatActivity {

    public static String name;
    public TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_stats);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        title = findViewById(R.id.title);
        title.setText(getString(R.string.drivers_stats, getIntent().getStringExtra("DRIVER")));
        name =  getIntent().getStringExtra("DRIVER");
    }


}