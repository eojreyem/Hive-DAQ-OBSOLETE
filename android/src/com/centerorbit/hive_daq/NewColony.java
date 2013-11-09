package com.centerorbit.hive_daq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.centerorbit.hive_daq.model.MainDataSource;

/**
 * Created by andy on 11/6/13.
 */
public class NewColony extends Activity {

    private MainDataSource datasource;
    private Context appContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_colony);
        this.appContext = this;

        datasource = new MainDataSource(appContext);
        datasource.open();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inspect_hive, menu);
        return true;
    }

    /** Called when the user clicks the Select a Hive */
    public void create(View view) {
        /*
        1. Grab text
        2. Store in DB
        3. Change activities.
         */
        EditText newColonyName = (EditText) findViewById(R.id.new_colony_name);


        datasource.Colony().create(newColonyName.getText().toString());
        datasource.close();

        // Do something in response to button
        Intent intent = new Intent(this, HiveSelect.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        datasource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        datasource.close();
        super.onPause();
    }
}