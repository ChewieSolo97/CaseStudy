package com.example.CaseStudy.MainPage;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.CaseStudy.LocalDB.Driver;
import com.example.CaseStudy.Model.DriverObject;
import com.example.CaseStudy.R;

import java.util.ArrayList;
import java.util.List;

public class SuggestionsAdapter extends RecyclerView.Adapter<SuggestionsAdapter.SuggestionsViewHolder>{

    private ArrayList<String> suggestions;
    private SuggestionsClickHandler clickHandler;
    //private Context context;
    private List<String> list;

    public interface SuggestionsClickHandler {
        void onClick(String driver);
    }

    public SuggestionsAdapter(SuggestionsClickHandler clickHandler, Context context) {
        this.clickHandler = clickHandler;
        suggestions = new ArrayList<>();
        list = new ArrayList<>();
        new loadDrivers().execute(context);
    }


    public class SuggestionsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView suggestion;

        public SuggestionsViewHolder(View view) {
            super(view);
            suggestion = view.findViewById(R.id.suggestion);
            view.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            String driver = suggestions.get(adapterPosition);
            clickHandler.onClick(driver);
        }
    }

    @NonNull
    @Override
    public SuggestionsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.suggestions_list;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);
        return new SuggestionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SuggestionsViewHolder suggestionsViewHolder, int i) {
        String text = suggestions.get(i);
        suggestionsViewHolder.suggestion.setText(text);
    }

    @Override
    public int getItemCount() {
        return suggestions.size();
    }

    public void setSuggestions(String text) {
        try {
            if (text.equals("")) {
                suggestions.clear();
                notifyDataSetChanged();
            } else {
                List<String> matches = new ArrayList<>();
                for (String driver : list) {
                    if (driver.toLowerCase().contains(text.toLowerCase())) {
                        matches.add(driver);
                    }
                }
                suggestions.clear();
                suggestions.addAll(matches);
                notifyDataSetChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class loadDrivers extends AsyncTask<Context, Void, String> {

        List<DriverObject> drivers;
        @Override
        protected String doInBackground(Context... params) {

            try {
                drivers = Driver.getDrivers(params[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "done";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            for (DriverObject driver : drivers) {
                list.add(driver.getName());
            }
        }
    }
}
