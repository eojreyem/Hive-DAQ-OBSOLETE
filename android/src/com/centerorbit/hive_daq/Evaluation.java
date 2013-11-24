package com.centerorbit.hive_daq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;
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

    public void Queen_menu(View view) {
        Toast.makeText(this.getApplicationContext(), "Open QueenEval Menu", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, QueenEval.class);
        startActivity(intent);
    }

    public void Disease(View view) {
        Toast.makeText(this.getApplicationContext(), "Open Disease Menu", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Disease.class);
        startActivity(intent);
    }

}
