package com.example.CaseStudy.MainPage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.CaseStudy.R;

public class AddDriver extends AppCompatActivity implements SuggestionsAdapter.SuggestionsClickHandler {

    SearchView addDriver;
    private SuggestionsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Add a Driver");
        setContentView(R.layout.activity_add_driver);

        addDriver = findViewById(R.id.sv_add_driver);

        addDriver.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent();
                intent.putExtra("DATA", addDriver.getQuery().toString());
                setResult(Activity.RESULT_OK, intent);
                finish();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.setSuggestions(newText);
                return false;
            }
        });

        RecyclerView suggestions = findViewById(R.id.suggestions_RV);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        suggestions.setLayoutManager(layoutManager);
        adapter = new SuggestionsAdapter(this, getApplicationContext());
        suggestions.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_driver_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.cancel_add_driver) {
            setResult(Activity.RESULT_CANCELED);
            finish();
        } else if (id == R.id.confirm_add_driver) {
            Intent intent = new Intent();
            intent.putExtra("DATA", addDriver.getQuery().toString());
            setResult(Activity.RESULT_OK, intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(String driver) {
        Intent intent = new Intent();
        intent.putExtra("DATA", driver);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
