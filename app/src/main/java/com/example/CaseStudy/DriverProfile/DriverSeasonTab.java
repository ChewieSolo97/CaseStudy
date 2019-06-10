package com.example.CaseStudy.DriverProfile;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.CaseStudy.LocalDB.Standings;
import com.example.CaseStudy.Model.SeasonResults;
import com.example.CaseStudy.R;
import com.example.CaseStudy.DriverRace.RaceResults;

import java.util.Calendar;

public class DriverSeasonTab extends Fragment implements DriverSeasonAdapter.DriversSeasonClickHandler {

    private DriverSeasonTabViewModel mViewModel;
    private DriverSeasonAdapter adapter;

    private RecyclerView season;

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

        SeasonResults results = Standings.queryStandings(DriverStats.name,
                Calendar.getInstance().get(Calendar.YEAR), getContext());

        TextView wins = root.findViewById(R.id.season_wins);
        TextView starts = root.findViewById(R.id.season_starts);
        TextView poles = root.findViewById(R.id.season_poles);
        TextView top5 = root.findViewById(R.id.season_top5);
        TextView top10 = root.findViewById(R.id.season_top10);
        TextView dnf = root.findViewById(R.id.season_dnf);
        TextView laps_led = root.findViewById(R.id.season_laps_led);

        wins.setText(getString(R.string.wins, results.getWins()));
        starts.setText(getString(R.string.starts, results.getStarts()));
        poles.setText(getString(R.string.poles, results.getPoles()));
        top5.setText(getString(R.string.top5, results.getTop5()));
        top10.setText(getString(R.string.top10, results.getTop10()));
        dnf.setText(getString(R.string.dnf, results.getDnf()));
        laps_led.setText(getString(R.string.laps, results.getLaps_led()));

        // TODO: send the data to the adapter
        return root;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mViewModel = ViewModelProviders.of(this).get(DriverSeasonTabViewModel.class);
        // TODO: Use the ViewModel to load the data

    }

    @Override
    public void onClick(String info) {
        Intent intent = new Intent(this.getContext(), RaceResults.class);
        intent.putExtra("RACE", info);
        startActivity(intent);
    }
}
