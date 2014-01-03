package com.centerorbit.hive_daq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Calendar;
import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.TextView;


import com.centerorbit.hive_daq.model.MainDataSource;

/**
 * Created by andy on 11/6/13.
 */
public class CreateColony extends Activity {

    private MainDataSource datasource;
    private Context appContext;

    private int year;
    private int month;
    private int day;
    private String dateEntered;
    private String colonyHeader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_colony);
        this.appContext = this;
        datasource = new MainDataSource(appContext);
        datasource.open();

        // get current date.
        Calendar rightNow = Calendar.getInstance();
        month = rightNow.get(Calendar.MONTH);
        day = rightNow.get(Calendar.DAY_OF_MONTH);
        year = rightNow.get(Calendar.YEAR);
        dateEntered = AMElib.dateInt_to_String(month,day,year);

        Button bt_created = (Button) findViewById(R.id.bt_created_date);
        String today = month + 1 + "/" + day + "/" + year;
        bt_created.setText(today);

        // Generate colony header  changes with date created
        TextView tv_colonyNameHeader = (TextView) findViewById(R.id.textView_name_header);
        colonyHeader = Integer.toString(year);
        colonyHeader = "C" + colonyHeader.substring(2,4) + "-";
        tv_colonyNameHeader.setText(colonyHeader);

        // Generate colony name
        String nextAvalibleColonyNumber = Integer.toString(200); // TODO dig Number out of the database!
        EditText et_colonyName = (EditText) findViewById(R.id.edit_text_name);
        et_colonyName.setText(nextAvalibleColonyNumber);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inspect_colony, menu);
        return true;
    }


        // Called when the user clicks the "Create Colony" button
    public void CreateButton(View view) {

        /*
        1. Grab text
        2. Store in DB
        3. Change activities.
         */
        EditText newColonyName = (EditText) findViewById(R.id.edit_text_name);
        EditText newColonyYard = (EditText) findViewById(R.id.edit_text_yard);
        EditText newColonySourceType = (EditText) findViewById(R.id.edit_text_source_type);
        EditText newColonySource = (EditText) findViewById(R.id.edit_text_source);
        EditText newHiveType = (EditText) findViewById(R.id.edit_text_hive);
        EditText newNote = (EditText) findViewById(R.id.edit_text_colony_note);

        //converts Int from date picker into String to be stored in SQLite in date format.
        String createdDate = AMElib.dateInt_to_String(month, day, year);

        datasource.Colony().create(colonyHeader + newColonyName.getText().toString(), createdDate, newNote.getText().toString());
       // datasource.Colony().create(1, newColonyName.getText().toString(), null, newColonyDateCreated.getText().toString(), 1, 1, 1, 1, newNote.getText().toString());
        // TODO add dateEntered into database.  Needs column!
        datasource.close();

        // Do something in response to button
        Intent intent = new Intent(this, ColonySelect.class);
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

    public void CreateDateClicked(View view) {
        //clicked Date Created button, launch the DatePicker dialog.
        DatePickerDialog newdatepickerdialog = new DatePickerDialog(this, datePickerListener, year, month, day);
        newdatepickerdialog.show();
    }


    private DatePickerDialog.OnDateSetListener datePickerListener
            = new DatePickerDialog.OnDateSetListener()
    {

        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay)
        {

            //set the datapicker values to the month day and year.
            month=selectedMonth;
            day=selectedDay;
            year=selectedYear;

            // set date created button text to current date.
            Button bt_created = (Button) findViewById(R.id.bt_created_date);
            String today = month+1 + "/" + day + "/" + year;
            bt_created.setText(today);

            // Change colony name header
            TextView tv_colonyNameHeader = (TextView) findViewById(R.id.textView_name_header);
            colonyHeader = Integer.toString(year);
            colonyHeader = "C" + colonyHeader.substring(2,4) + "-";
            tv_colonyNameHeader.setText(colonyHeader);
        }

    };


}