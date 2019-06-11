package com.example.CaseStudy.DriverProfile;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.CaseStudy.DriverRace.RaceResults;
import com.example.CaseStudy.LocalDB.DatabaseHelper;
import com.example.CaseStudy.LocalDB.Standings;
import com.example.CaseStudy.LocalDB.TableContracts;
import com.example.CaseStudy.Model.SeasonResults;
import com.example.CaseStudy.R;
import com.example.CaseStudy.Retrofit.APICalls;

import java.util.ArrayList;
import java.util.Calendar;

public class DriverSeasonTab extends Fragment implements DriverSeasonAdapter.DriversSeasonClickHandler,
        AdapterView.OnItemSelectedListener {

    private DriverSeasonAdapter adapter;
    private int selectedYear;
    private RecyclerView season;
    private Context context;

    TextView wins;
    TextView starts;
    TextView poles;
    TextView top5;
    TextView top10;
    TextView dnf;
    TextView laps_led;
    TextView points;

    public static DriverSeasonTab newInstance() {
        return new DriverSeasonTab();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.driver_season_tab_fragment, container, false);
        season = root.findViewById(R.id.driver_season_RV);
        season.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new DriverSeasonAdapter(this, getContext());
        season.setAdapter(adapter);

        context = getContext();
        SeasonResults results = Standings.queryStandings(DriverStats.name,
                Calendar.getInstance().get(Calendar.YEAR), getContext());

        wins = root.findViewById(R.id.season_wins);
        starts = root.findViewById(R.id.season_starts);
        poles = root.findViewById(R.id.season_poles);
        top5 = root.findViewById(R.id.season_top5);
        top10 = root.findViewById(R.id.season_top10);
        dnf = root.findViewById(R.id.season_dnf);
        laps_led = root.findViewById(R.id.season_laps_led);
        points = root.findViewById(R.id.points_pos);

        wins.setText(getString(R.string.wins, results.getWins()));
        starts.setText(getString(R.string.starts, results.getStarts()));
        poles.setText(getString(R.string.poles, results.getPoles()));
        top5.setText(getString(R.string.top5, results.getTop5()));
        top10.setText(getString(R.string.top10, results.getTop10()));
        dnf.setText(getString(R.string.dnf, results.getDnf()));
        laps_led.setText(getString(R.string.laps, results.getLaps_led()));
        points.setText(getString(R.string.point_pos, results.getRank()));


        ArrayAdapter<String> adapter = new ArrayAdapter<>(context,
                android.R.layout.simple_spinner_item, getYears());

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        DriverStats.spinner.setAdapter(adapter);
        DriverStats.spinner.setOnItemSelectedListener(this);

        return root;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onClick(String info) {
        Intent intent = new Intent(this.getContext(), RaceResults.class);
        intent.putExtra("ID", info);
        intent.putExtra("NAME", DriverStats.name);

        startActivity(intent);
    }

    public void refresh(int year) {

        SeasonResults results = Standings.queryStandings(DriverStats.name,
                year, getContext());

        wins.setText(getString(R.string.wins, results.getWins()));
        starts.setText(getString(R.string.starts, results.getStarts()));
        poles.setText(getString(R.string.poles, results.getPoles()));
        top5.setText(getString(R.string.top5, results.getTop5()));
        top10.setText(getString(R.string.top10, results.getTop10()));
        dnf.setText(getString(R.string.dnf, results.getDnf()));
        laps_led.setText(getString(R.string.laps, results.getLaps_led()));
        points.setText(getString(R.string.point_pos, results.getRank()));
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        ArrayList<String> years = getYears();
        String stringYear = years.get(position);


        new loadYearData().execute(stringYear);
        new loadScheduleData().execute(stringYear);

    }

    private static ArrayList<String> getYears() {

        int baseYear = 2013; // the earliest year available is 2012, but its very incomplete
        ArrayList<String> years = new ArrayList<>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        for (int i = currentYear; i >= baseYear; i--) {
            years.add(String.valueOf(i));
        }
        return years;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // do nothing
    }

    public class loadYearData extends AsyncTask<String, Void, String> {

        boolean update = false;
        int temp;

        @Override
        protected String doInBackground(String... params) {

            temp = Integer.valueOf(params[0]);
            selectedYear = temp;
            SQLiteDatabase db = DatabaseHelper.getInstance(context).getWritableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM " + TableContracts.ResultsTable.TABLE_NAME
                    + " WHERE years = '" + params[0] + "'", null);
            int count = cursor.getCount();

            cursor.close();

            if (count == 0) {
                APICalls.getSeasonStandings(context, Integer.valueOf(params[0]));
                update = true;
            }

            return "done";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (update) {
                Toast.makeText(context, "Please wait while the data is loading", Toast.LENGTH_LONG).show();
                Handler handler = new Handler();
                handler.postDelayed(task, 5000);
            } else {
                refresh(selectedYear);
            }
        }
    }

    private Runnable task = new Runnable() {
        public void run() {
            refresh(selectedYear);
            adapter.refresh(selectedYear);
        }
    };

    public class loadScheduleData extends AsyncTask<String, Void, String> {

        boolean update = false;
        int temp;

        @Override
        protected String doInBackground(String... params) {

            temp = Integer.valueOf(params[0]);
            selectedYear = temp;
            SQLiteDatabase db = DatabaseHelper.getInstance(context).getWritableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM " + TableContracts.ScheduleTable.TABLE_NAME
                    + " WHERE years = '" + params[0] + "'", null);
            int otherCount = cursor.getCount();
            cursor.close();

            if (otherCount == 0) {
                APICalls.getSeasonSchedule(context, Integer.valueOf(params[0]));
                update = true;
            }

            return "done";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (update) {
                //Toast.makeText(context, "Please wait while the data is loading", Toast.LENGTH_LONG).show();
                Handler handler = new Handler();
                handler.postDelayed(otherTask, 5000);
            } else {
                adapter.refresh(selectedYear);
            }
        }
    }

    private Runnable otherTask = new Runnable() {
        public void run() {
            adapter.refresh(selectedYear);
        }
    };
}
