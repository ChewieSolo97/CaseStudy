package com.example.CaseStudy.MainPage;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


import com.example.CaseStudy.LocalDB.DatabaseHelper;
import com.example.CaseStudy.LocalDB.Driver;
import com.example.CaseStudy.R;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import POJO.Classes.DriverInfo.Drivers;
import POJO.Classes.DriverInfo;
import Retrofit.RetrofitObjectAPI;
import Retrofit.APICalls;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//import static com.example.CaseStudy.LocalDB.Driver.getDrivers;

public class MainActivity extends AppCompatActivity implements DriversAdapter.DriversClickHandler {

    public static int ADD_DRIVER = 0;
    private DriversAdapter mDriversAdapter;
    private RecyclerView mRecyclerView;
    private int adapterPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.main_RV);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(layoutManager);
        mDriversAdapter = new DriversAdapter(this);
        mRecyclerView.setAdapter(mDriversAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public void onClick(String info) {

        new testAsync().execute("asas");

//        List<String> list = Driver.getDrivers(getApplicationContext());
//        for (String item : list) {
//            Log.v("THISBETTERWORK", item);
//        }

        // what actually happens here
//        Intent intent = new Intent(MainActivity.this, DriverStats.class);
//        intent.putExtra("DRIVER", info);
//        startActivity(intent);
    }

    @Override
    public void onLongItemClick(View v, int position) {
        adapterPosition = position;
        registerForContextMenu( v );
        openContextMenu( v );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.add_driver) {
            startActivityForResult(new Intent(MainActivity.this, AddDriver.class), ADD_DRIVER);

        }


        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == ADD_DRIVER) {
            if (resultCode == RESULT_OK) {
                mDriversAdapter.addDrivers(data.getStringExtra("DATA"));
            }
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.delete_drivers_menu, menu);
        menu.setHeaderTitle("Do you want to remove this driver?");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getItemId()==R.id.delete_driver){
            mDriversAdapter.removeDrivers(adapterPosition);
        }
        return true;
    }

    public class testAsync extends AsyncTask<String, Void, String> {

        // COMPLETED (2) Override the doInBackground method to perform the query. Return the results. (Hint: You've already written the code to perform the query)
        @Override
        protected String doInBackground(String... params) {

            try {
                APICalls.getDriverData(getApplicationContext());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "done";
        }

        // COMPLETED (3) Override onPostExecute to display the results in the TextView
//        @Override
//        protected void onPostExecute(String githubSearchResults) {
//            if (githubSearchResults != null && !githubSearchResults.equals("")) {
//                mSearchResultsTextView.setText(githubSearchResults);
//            }
//        }
    }
}
