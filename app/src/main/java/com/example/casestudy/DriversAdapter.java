package com.example.casestudy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DriversAdapter extends RecyclerView.Adapter<DriversAdapter.DriversViewHolder>{

    private ArrayList<String> mDrivers;
    private DriversClickHandler mClickHandler;

    public DriversAdapter(DriversClickHandler clickHandler) {
        mClickHandler = clickHandler;
    }

    public interface DriversClickHandler {
        void onClick(String info);
    }

    @NonNull
    @Override
    public DriversViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.drivers_list;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        return new DriversViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DriversViewHolder driversViewHolder, int i) {
        String driver = mDrivers.get(i);
        driversViewHolder.mDriverTextView.setText(driver);
    }

    @Override
    public int getItemCount() {
        if (null == mDrivers) return 0;
        return mDrivers.size();
    }

    public class DriversViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView mDriverTextView;

        public DriversViewHolder(View itemView) {
            super(itemView);
            mDriverTextView = itemView.findViewById(R.id.driver);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            String weatherForDay = mDrivers.get(adapterPosition);
            mClickHandler.onClick(weatherForDay);
        }
    }


    public void addDrivers(String driver) {
        if (mDrivers == null) {
            mDrivers = new ArrayList<>();
        }
        mDrivers.add(driver);
        notifyDataSetChanged();
    }

}
