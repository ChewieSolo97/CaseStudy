package com.example.CaseStudy.MainPage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.CaseStudy.R;

import java.util.ArrayList;

public class DriversAdapter extends RecyclerView.Adapter<DriversAdapter.DriversViewHolder>{

    private ArrayList<String> mDrivers;
    //private ArrayList<Boolean> deleteDrivers;
    private DriversClickHandler mClickHandler;
    //private boolean delete = false;

    public DriversAdapter(DriversClickHandler clickHandler) {
        mClickHandler = clickHandler;
    }

    public interface DriversClickHandler {
        void onClick(String info);
        void onLongItemClick(View v, int position);
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

    public class DriversViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
    View.OnLongClickListener {

        public final TextView mDriverTextView;

        public DriversViewHolder(View itemView) {
            super(itemView);
            mDriverTextView = itemView.findViewById(R.id.driver);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
                int adapterPosition = getAdapterPosition();
                String driver = mDrivers.get(adapterPosition);
                mClickHandler.onClick(driver);
        }


        @Override
        public boolean onLongClick(View v) {
            mClickHandler.onLongItemClick(v, getAdapterPosition());
            return true;
        }
    }


    public void addDrivers(String driver) {
        if (mDrivers == null) {
            mDrivers = new ArrayList<>();
        }
        mDrivers.add(driver);
        notifyDataSetChanged();
    }

    public void removeDrivers(int position) {
        mDrivers.remove(position);
        notifyDataSetChanged();
    }

}
