package com.example.CaseStudy.DriverProfile;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.CaseStudy.LocalDB.Driver;
import com.example.CaseStudy.Model.DriverObject;
import com.example.CaseStudy.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ProfileFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static ProfileFragment newInstance(int index) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        //pageViewModel.setIndex(index);
    }

    // this method is what loads the fragment
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_driver_stats, container, false);

        DriverObject driver = Driver.queryDriver(DriverStats.name, getContext());

        TextView name = root.findViewById(R.id.name);
        TextView number = root.findViewById(R.id.number);
        TextView height = root.findViewById(R.id.height);
        TextView bday = root.findViewById(R.id.birthday);
        TextView rookieYear = root.findViewById(R.id.rookie_year);
        TextView residence = root.findViewById(R.id.residence);
        TextView birthplace = root.findViewById(R.id.birthplace);
        TextView team = root.findViewById(R.id.team);
        TextView crewchief = root.findViewById(R.id.crew_chief);

        name.setText(DriverStats.name);
        number.setText(driver.getNumber());
        height.setText(getString(R.string.height, driver.getHeight()));
        bday.setText(getString(R.string.bday, driver.getBirthday()));
        rookieYear.setText(getString(R.string.rookie, driver.getRookieYear()));
        residence.setText(getString(R.string.residence, driver.getResidence()));
        birthplace.setText(getString(R.string.birthplace, driver.getBirthplace()));
        team.setText(getString(R.string.team, driver.getTeam()));
        crewchief.setText(getString(R.string.crewchief, driver.getCrewchief()));

        TextView starts = root.findViewById(R.id.starts);
        TextView wins = root.findViewById(R.id.wins);
        TextView top5 = root.findViewById(R.id.top5);
        TextView top10 = root.findViewById(R.id.top10);
        TextView poles = root.findViewById(R.id.poles);
        TextView dnf = root.findViewById(R.id.dnf);
        TextView lapsled = root.findViewById(R.id.laps_led);

        starts.setText(getString(R.string.starts, driver.getStarts()));
        wins.setText(getString(R.string.wins, driver.getWins()));
        top5.setText(getString(R.string.top5, driver.getTop5s()));
        top10.setText(getString(R.string.top10, driver.getTop10s()));
        poles.setText(getString(R.string.poles, driver.getPoles()));
        dnf.setText(getString(R.string.dnf, driver.getDnf()));
        lapsled.setText(getString(R.string.laps, driver.getLapsled()));

        return root;
    }
}
