package com.example.casestudy;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.zip.Inflater;

public class DriverSeasonTab extends Fragment {

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
        adapter = new DriverSeasonAdapter(null);
        season.setAdapter(adapter);

        // TODO: send the data to the adapter
        return root;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DriverSeasonTabViewModel.class);
        // TODO: Use the ViewModel to load the data

    }

}
