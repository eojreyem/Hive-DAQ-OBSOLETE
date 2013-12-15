package com.centerorbit.hive_daq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Evaluation extends Activity {



    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_eval);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.evaluation, menu);
		return true;
	}

    public void Take_note(View view) {
        Toast.makeText(this.getApplicationContext(), "Take a Note", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, VisitNote.class);
        startActivity(intent);
    }

    public void Open_Eval2(View view) {
        Toast.makeText(this.getApplicationContext(), "Evaluations Pt2", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Evaluation2.class);
        startActivity(intent);
    }

    public void Brood_all_stages_no(View view) {
        Toast.makeText(this.getApplicationContext(), "NO?", Toast.LENGTH_SHORT).show();

        ToggleButton toggle_eggs = (ToggleButton) findViewById(R.id.toggle_eggs);
        toggle_eggs.setVisibility(View.VISIBLE);
        ToggleButton toggle_larvae = (ToggleButton) findViewById(R.id.toggle_larvae);
        toggle_larvae.setVisibility(View.VISIBLE);
        ToggleButton toggle_pupae = (ToggleButton) findViewById(R.id.toggle_pupae);
        toggle_pupae.setVisibility(View.VISIBLE);
        Button bt_cancel_brood = (Button) findViewById(R.id.bt_cancel_brood);
        bt_cancel_brood.setVisibility(View.VISIBLE);

        Button bt_brood_all_stage_no = (Button) findViewById(R.id.bt_brood_all_stage_no);
        bt_brood_all_stage_no.setVisibility(View.INVISIBLE);
        Button bt_brood_all_stage_yes = (Button) findViewById(R.id.bt_brood_all_stage_yes);
        bt_brood_all_stage_yes.setVisibility(View.INVISIBLE);

    }

    public void Brood_all_stages_cancel(View view) {
        Toast.makeText(this.getApplicationContext(), "Cancel", Toast.LENGTH_SHORT).show();

        ToggleButton toggle_eggs = (ToggleButton) findViewById(R.id.toggle_eggs);
        toggle_eggs.setVisibility(View.INVISIBLE);
        ToggleButton toggle_larvae = (ToggleButton) findViewById(R.id.toggle_larvae);
        toggle_larvae.setVisibility(View.INVISIBLE);
        ToggleButton toggle_pupae = (ToggleButton) findViewById(R.id.toggle_pupae);
        toggle_pupae.setVisibility(View.INVISIBLE);
        Button bt_cancel_brood = (Button) findViewById(R.id.bt_cancel_brood);
        bt_cancel_brood.setVisibility(View.INVISIBLE);

        Button bt_brood_all_stage_no = (Button) findViewById(R.id.bt_brood_all_stage_no);
        bt_brood_all_stage_no.setVisibility(View.VISIBLE);
        Button bt_brood_all_stage_yes = (Button) findViewById(R.id.bt_brood_all_stage_yes);
        bt_brood_all_stage_yes.setVisibility(View.VISIBLE);

    }


}
