package com.example.CaseStudy.DriverRace;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.CaseStudy.R;

public class Qualifying extends Fragment {


    public static Qualifying newInstance() {
        return new Qualifying();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_qualifying, container, false);

        // TODO: send the data to the adapter
        return root;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mViewModel = ViewModelProviders.of(this).get(DriverSeasonTabViewModel.class);
        // TODO: Use the ViewModel to load the data

    }
}
