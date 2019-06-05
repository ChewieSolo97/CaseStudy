package com.example.casestudy;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RaceResults extends AppCompatActivity {

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
        title.setText(getIntent().getStringExtra("RACE"));
    }
}
