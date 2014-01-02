package com.centerorbit.hive_daq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class VisitColony extends Activity
implements WeatherInterface {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_visit);

        Weather test = new Weather();
        test.getLatest(45.427960f, -93.141952f, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inspect_colony, menu);
		return true;
	}

    @Override
    public void weatherHasUpdated(JSONObject weather) {
        try{
            Double temperature = weather.getJSONObject("currently").getDouble("temperature");
            Double cloudCover = weather.getJSONObject("currently").getDouble("cloudCover");

            //TODO: yeah, Toast is great... but instead we should update the UI, and store in DB.
            Toast.makeText(this.getApplicationContext(), "The temp is: "+temperature.toString(), Toast.LENGTH_SHORT).show();
            Toast.makeText(this.getApplicationContext(), "The cloud cover is: "+cloudCover.toString(), Toast.LENGTH_SHORT).show();
        }
        catch (JSONException error){
            //Do nothing about it?
        }
    }

    @Override
    public void weatherFailedUpdate() {
        //TODO: Perhaps a real fail thing.
        Toast.makeText(this.getApplicationContext(), "Weather failed to update.", Toast.LENGTH_SHORT).show();
    }
    
    public void Queen_menu(View view) {
        Toast.makeText(this.getApplicationContext(), "Open QueenEval Menu", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, QueenEval.class);
        startActivity(intent);
    }

    public void Evaluation(View view) {
        Toast.makeText(this.getApplicationContext(), "Open Evaluation Form", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Evaluation.class);
        startActivity(intent);
    }

    public void Disease(View view) {
        Toast.makeText(this.getApplicationContext(), "Open Disease Menu", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Disease.class);
        startActivity(intent);
    }

    public void Management(View view) {
        Toast.makeText(this.getApplicationContext(), "Open Management Menu", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Management.class);
        startActivity(intent);
    }

    public void ColonyDetails(View view) {
        Toast.makeText(this.getApplicationContext(), "Open Colony Details", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ColonyDetail.class);
        startActivity(intent);
    }

    public void Camera(View view) {
        Toast.makeText(this.getApplicationContext(), "Take a picture", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(intent, 0);
        // TODO store image on SD card.  (currently doesn't store image at all)

    }


    public void Take_note(View view) {
        Toast.makeText(this.getApplicationContext(), "Take a Note", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, VisitNote.class);
        startActivity(intent);
    }

 
}
