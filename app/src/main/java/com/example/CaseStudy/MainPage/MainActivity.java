package com.example.CaseStudy.MainPage;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.CaseStudy.DriverProfile.DriverStats;
import com.example.CaseStudy.LocalDB.DatabaseHelper;
import com.example.CaseStudy.LocalDB.TableContracts;
import com.example.CaseStudy.R;
import com.example.CaseStudy.Retrofit.APICalls;

import java.util.Calendar;

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
        mDriversAdapter = new DriversAdapter(this, getApplicationContext());
        mRecyclerView.setAdapter(mDriversAdapter);
        new testAsync().execute("saj");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public void onClick(String info) {

        new otherAsync().execute("asdad");
        // what actually happens here
        Intent intent = new Intent(MainActivity.this, DriverStats.class);
        intent.putExtra("DRIVER", info);
        startActivity(intent);
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

        @Override
        protected String doInBackground(String... params) {

            try {
                // checks if the table already exists and is up to date
                if (upgrade(TableContracts.DriverTable.TABLE_NAME, getApplicationContext())) {
                    APICalls.getDriverInfo(getApplicationContext());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return "done";
        }
    }

    public class otherAsync extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            try {
                // checks if the table already exists and is up to date
                if (upgrade(TableContracts.DriverTable.TABLE_NAME, getApplicationContext())) {
                    APICalls.getDriverStats(getApplicationContext());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return "done";
        }
    }

    public static boolean upgrade(String tableName, Context context) {
        boolean upgrade;
        // this is to get the exact time since epoch at midnight of the current day utc
        Calendar midnight = Calendar.getInstance();
        midnight.set(Calendar.AM_PM, 0);
        midnight.set(Calendar.HOUR, 0);
        midnight.set(Calendar.MINUTE, 0);
        midnight.set(Calendar.SECOND, 0);
        midnight.set(Calendar.MILLISECOND, 0);

        SQLiteDatabase db = DatabaseHelper.getInstance(context).getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT last_update FROM  updates"
                + " where table_name = ?", new String[]{tableName});

        cursor.moveToFirst();
        if (cursor.getCount() <= 0) {
            upgrade = true;
        } else if (cursor.getLong(cursor.getColumnIndex("last_update")) > midnight.getTimeInMillis()) {
            upgrade = false; // table has been updated today
        } else {
            upgrade = true;
        }
        cursor.close();
        db.close();
        return upgrade;
    }
}
