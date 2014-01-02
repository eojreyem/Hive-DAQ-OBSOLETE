package com.centerorbit.hive_daq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.centerorbit.hive_daq.model.MainDataSource;

/**
 * Created by joe on 12/14/13.
 */
public class CreateQueen extends Activity {

    private MainDataSource datasource;
    private Context appContext;

    private int year;
    private Calendar today;
    private int dayweekyearcount=0;


    private String queenHeader;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_queen);

        this.appContext = this;
        datasource = new MainDataSource(appContext);
        datasource.open();

        // get current date.
        today = Calendar.getInstance();
        year = today.get(Calendar.YEAR);

        // Generate queen name header  changes with "laying for"
        TextView tv_queenNameHeader = (TextView) findViewById(R.id.textView_queen_header);
        queenHeader = Integer.toString(year);
        queenHeader = "Q" + queenHeader.substring(2,4) + "-";
        tv_queenNameHeader.setText(queenHeader);

        // Generate colony name
        String nextAvalibleQueenNumber = Integer.toString(200); // TODO dig Number out of the database!
        EditText et_queenName = (EditText) findViewById(R.id.edit_text_queen_name);
        et_queenName.setText(nextAvalibleQueenNumber);


    }

    public void DayWeekYearToggle(View v)
    {
        dayweekyearcount++;
        if (dayweekyearcount>2)
            dayweekyearcount=0;

        Button DWYtoggle = (Button) findViewById(R.id.bt_dayWeekYearToggle);

        switch (dayweekyearcount){
            case 0: DWYtoggle.setText("days");
               break;
            case 1: DWYtoggle.setText("weeks");
                break;
            case 2: DWYtoggle.setText("years");
                break;
            default:DWYtoggle.setText("Invalid");
                break;
        }


    }

    public void CreateQueenClicked(View v)
    {
          /*
        1. Grab text
        2. Store in DB
        3. Change activities.
         */
        EditText newQueenName = (EditText) findViewById(R.id.edit_text_queen_name);
        EditText number_laying = (EditText) findViewById(R.id.edit_text_number_laying);
        EditText newNote = (EditText) findViewById(R.id.edit_text_queen_note);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        // Using DateFormat format method we can create a string representation of a date with the defined format.
        String createDate = df.format(today.getTime());
        // TODO store createDate in DB.

        //Calculate number of days laying.
        int NumDaysLaying = -1;
        try {
            NumDaysLaying = Integer.parseInt(number_laying.getText().toString());
        }
        catch(NumberFormatException nfe) {
            //TODO need to catch?
        }

        switch (dayweekyearcount){
            case 0:
                break;
            case 1: NumDaysLaying=NumDaysLaying*7;
                break;
            case 2: NumDaysLaying=NumDaysLaying*365;
                break;
            default:NumDaysLaying=-1;
                break;
        }

        //Calendar math to calculate date began laying
        today.add(Calendar.DATE, -NumDaysLaying);

        //rename if from a past year?
        int year2 = today.get(Calendar.YEAR);

        if (year!=year2)
        {   //TODO rename queen.
            Toast.makeText(this.getApplicationContext(),"Rename Queen!!!", Toast.LENGTH_SHORT).show();
            Toast.makeText(this.getApplicationContext(),"No Laying Date entered!", Toast.LENGTH_SHORT).show();
        }

        else if (NumDaysLaying>0 && NumDaysLaying<365){
            // TODO store BeganLayingDate in DB.
            String BeganLayingDate = df.format(today.getTime());
            Toast.makeText(this.getApplicationContext(),BeganLayingDate, Toast.LENGTH_SHORT).show();
        }

        else
        {
            Toast.makeText(this.getApplicationContext(),"No Laying Date entered!", Toast.LENGTH_SHORT).show();
        }


        // datasource.Queen().create(queenHeader + newQueenName.getText().toString());
        datasource.close();

        // Do something in response to button
        Intent intent = new Intent(this, ColonySelect.class);
        startActivity(intent);


    }

}