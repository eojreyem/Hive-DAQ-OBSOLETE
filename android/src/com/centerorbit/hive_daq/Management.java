package com.centerorbit.hive_daq;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.ToggleButton;

/**
 * Created by joe on 11/23/13.
 */
public class Management extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mgmt);

        NumberPicker number_of_supers = (NumberPicker) findViewById(R.id.num_pic_supers);
        number_of_supers.setMaxValue(10);
        number_of_supers.setMinValue(0);;
    }
}