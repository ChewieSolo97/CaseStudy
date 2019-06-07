package com.example.CaseStudy.MainPage;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.CaseStudy.R;

public class AddDriver extends AppCompatActivity {

    EditText addDriver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Add a Driver");
        setContentView(R.layout.activity_add_driver);

        addDriver = findViewById(R.id.et_add_driver);
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
            intent.putExtra("DATA", addDriver.getText().toString());
            setResult(Activity.RESULT_OK, intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
