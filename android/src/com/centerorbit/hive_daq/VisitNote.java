package com.centerorbit.hive_daq;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.centerorbit.hive_daq.R;

/**
 * Created by joe on 12/14/13.
 */
public class VisitNote extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
    }

    public void SaveNote(View view) {
        //TODO save note to database
        ToggleButton reminder_toggle = (ToggleButton) findViewById(R.id.tb_reminder);

        if (reminder_toggle.isChecked())
            Toast.makeText(this.getApplicationContext(), "TODO Note NOT Saved Reminder On", Toast.LENGTH_SHORT).show();
            //TODO set reminder flag in note database

        else
            Toast.makeText(this.getApplicationContext(), "TODO Note NOT Saved Reminder off", Toast.LENGTH_SHORT).show();


        setResult(Activity.RESULT_OK);
        finish();
    }

    public void Preset1(View view) {
        //These presets might be able to save us some typing.  This one is just an example examples.

        EditText preset = (EditText) findViewById(R.id.edit_text_note);
        preset.setText(preset.getText()+"Bring a deep out");

        ToggleButton reminder_toggle = (ToggleButton) findViewById(R.id.tb_reminder);
        reminder_toggle.setChecked(true);

    }

    public void Preset2(View view) {
        EditText preset = (EditText) findViewById(R.id.edit_text_note);
        preset.setText(preset.getText()+"Keep and eye on this colony, it wants to swarm!");

        ToggleButton reminder_toggle = (ToggleButton) findViewById(R.id.tb_reminder);
        reminder_toggle.setChecked(true);

    }

}