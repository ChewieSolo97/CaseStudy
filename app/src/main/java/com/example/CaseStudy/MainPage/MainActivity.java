package com.example.CaseStudy.MainPage;

import android.content.Intent;
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


import com.example.CaseStudy.R;

import java.util.List;

import POJO.Classes.DriverInfo.Drivers;
import POJO.Classes.DriverInfo;
import Retrofit.RetrofitObjectAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
        getRetrofitObject();
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

    void getRetrofitObject() {

        // the mc at the end can be changed to the other series
        String url = "http://api.sportradar.us/nascar-ot3/mc/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitObjectAPI service = retrofit.create(RetrofitObjectAPI.class);

        Call<DriverInfo> call = service.getDriversDetails();

        call.enqueue(new Callback<DriverInfo>() {
            @Override
            public void onResponse(@NonNull Call<DriverInfo> called, @NonNull Response<DriverInfo> responses) {


                try {
                    DriverInfo test = responses.body();
                    List<Drivers> testing = test.getDrivers();

                    for (Drivers sup : testing) {
                        Log.v("THISBETTERWORK", sup.getFull_name());
                    }

                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(@NonNull Call<DriverInfo> called, Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });
    }
}
