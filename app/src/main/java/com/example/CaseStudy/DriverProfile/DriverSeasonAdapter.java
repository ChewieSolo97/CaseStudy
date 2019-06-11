package com.example.CaseStudy.DriverProfile;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.CaseStudy.LocalDB.CurrentSchedule;
import com.example.CaseStudy.Model.SeasonSchedule;
import com.example.CaseStudy.R;

import java.util.ArrayList;
import java.util.Calendar;

public class DriverSeasonAdapter extends RecyclerView.Adapter<DriverSeasonAdapter.DriversSeasonViewHolder> {

    private ArrayList<SeasonSchedule> races;
    private DriversSeasonClickHandler mClickHandler;
    private Context context;

    public DriverSeasonAdapter(DriversSeasonClickHandler clickHandler, Context context) {
        mClickHandler = clickHandler;
        races = new ArrayList<>();
        races.addAll(CurrentSchedule.getSchedule(context,
                Calendar.getInstance().get(Calendar.YEAR)));
        this.context = context;
    }

    public interface DriversSeasonClickHandler {
        void onClick(String info);
    }

    @NonNull
    @Override
    public DriversSeasonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.driver_season_list;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);

        return new DriversSeasonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DriversSeasonViewHolder driversViewHolder, int i) {
        SeasonSchedule driver = races.get(i);
        driversViewHolder.driverRaceTV.setText(driver.getName());
    }

    @Override
    public int getItemCount() {
        if (null == races) return 0;
        return races.size();
    }

    public class DriversSeasonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView driverRaceTV;

        public DriversSeasonViewHolder(View itemView) {
            super(itemView);
            driverRaceTV = itemView.findViewById(R.id.driver_race);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            SeasonSchedule race = races.get(adapterPosition);
            mClickHandler.onClick(race.getID());
        }
    }

    public void refresh(int year) {
        races.clear();
        races.addAll(CurrentSchedule.getSchedule(context, year));
        notifyDataSetChanged();
    }
}
