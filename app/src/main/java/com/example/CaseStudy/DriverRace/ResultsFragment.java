package com.example.CaseStudy.DriverRace;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.CaseStudy.DriverProfile.RaceData;
import com.example.CaseStudy.R;
import com.example.CaseStudy.Retrofit.APICalls;

public class ResultsFragment extends Fragment {

    private TextView raceName;
    private TextView start;
    private TextView finish;
    private TextView rating;
    private TextView lapsLed;
    private TextView pitStops;
    private TextView avgPos;
    private String status;

    public static ResultsFragment newInstance() {
        return new ResultsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.results_fragment, container, false);

        raceName = root.findViewById(R.id.race_name);
        start = root.findViewById(R.id.starting);
        finish = root.findViewById(R.id.finished);
        rating = root.findViewById(R.id.rating);
        lapsLed = root.findViewById(R.id.led_laps);
        pitStops = root.findViewById(R.id.pit_stops);
        avgPos = root.findViewById(R.id.avg_pos);

        new loadRace().execute(RaceResults.ID);

        return root;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void fillData() {

        int position = -1;

        for (int i = 0; i < RaceData.getStandings().getResults().size(); i++) {
            if (RaceData.getStandings().getResults().get(i).getDriver().getFull_name().equals(RaceResults.name)) {
                position = i;
            }
        }

        if (position >= 0) {
            raceName.setText(RaceData.getStandings().getName());
            start.setText(getString(R.string.started, RaceData.getStandings().getResults().get(position).getStart_position()));
            finish.setText(getString(R.string.finished, RaceData.getStandings().getResults().get(position).getPosition()));
            rating.setText(getString(R.string.rating, RaceData.getStandings().getResults().get(position).getDriver_rating()));
            lapsLed.setText(getString(R.string.laps, RaceData.getStandings().getResults().get(position).getLaps_led()));
            pitStops.setText(getString(R.string.pit_stops, RaceData.getStandings().getResults().get(position).getPit_stops().size()));
            avgPos.setText(getString(R.string.avg_pos, RaceData.getStandings().getResults().get(position).getAvg_position()));
        } else {
            raceName.setText(RaceResults.name + " wasn't in this race.");
        }

    }

    public class loadRace extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... params) {

            APICalls.getRaceResults(params[0]);

            return "done";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Handler handler = new Handler();
            handler.postDelayed(otherTask, 2000);
        }
    }



    private Runnable otherTask = new Runnable() {
        public void run() {
            fillData();
        }
    };
}
