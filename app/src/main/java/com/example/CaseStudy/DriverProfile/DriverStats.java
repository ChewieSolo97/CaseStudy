package com.example.CaseStudy.DriverProfile;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.CaseStudy.LocalDB.DatabaseHelper;
import com.example.CaseStudy.LocalDB.TableContracts;
import com.example.CaseStudy.R;
import com.example.CaseStudy.Retrofit.APICalls;

import java.util.ArrayList;
import java.util.Calendar;

import static java.lang.Thread.sleep;

public class DriverStats extends AppCompatActivity {

    public static int year;
    public static String name;
    public static Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_stats);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        TextView title = findViewById(R.id.title);
        title.setText(getString(R.string.drivers_stats, getIntent().getStringExtra("DRIVER")));

        name = getIntent().getStringExtra("DRIVER");
        year = Calendar.getInstance().get(Calendar.YEAR);
        spinner = findViewById(R.id.spinner);
    }
}