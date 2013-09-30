package com.centerorbit.hive_daq;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class HiveSelect extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hive_select);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hive_select, menu);
		return true;
	}
	
	/** Called when the user clicks the Select a Hive */
	public void inspectHive(View view) {
	    // Do something in response to button
		Intent intent = new Intent(this, InspectHive.class);
		startActivity(intent);
	}
	
	/** Called when the user clicks the Select a Hive */
	public void back(View view) {
	    // Do something in response to button
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

}
