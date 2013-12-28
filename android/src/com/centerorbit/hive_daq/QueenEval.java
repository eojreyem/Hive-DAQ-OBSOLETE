package com.centerorbit.hive_daq;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class QueenEval extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_queen_eval);

        Button queen_number = (Button) findViewById(R.id.bt_queen_number);

        ToggleButton t_remove_queen = (ToggleButton) findViewById(R.id.t_remove_queen);
        Button bt_confine = (Button) findViewById(R.id.bt_confine);
        ToggleButton t_introduce = (ToggleButton) findViewById(R.id.t_introduce);
        Button bt_not_found = (Button) findViewById(R.id.bt_not_found);
        Button bt_kill = (Button) findViewById(R.id.bt_kill);
        Button bt_sell = (Button) findViewById(R.id.bt_sell);
        Button bt_move = (Button) findViewById(R.id.bt_move);
        Button bt_existing = (Button) findViewById(R.id.bt_existing);
        Button bt_laying_workers = (Button) findViewById(R.id.bt_laying_workers);
        ToggleButton t_queen_right = (ToggleButton) findViewById(R.id.t_queen_right);
        Button bt_create_queen = (Button) findViewById(R.id.bt_create_queen);
        Button bt_not_seen2 = (Button) findViewById(R.id.bt_not_seen2);
        Button bt_not_seen = (Button) findViewById(R.id.bt_not_seen);
        ToggleButton t_culled = (ToggleButton) findViewById(R.id.t_culled);
        ToggleButton t_emerged = (ToggleButton) findViewById(R.id.t_emerged);




        //pull info from last visit in database
        Integer reigning_queen = 1;

        if (reigning_queen != null) {
            t_remove_queen.setVisibility(View.INVISIBLE);
            bt_existing.setVisibility(View.INVISIBLE);
            bt_confine.setVisibility(View.INVISIBLE);
            t_introduce.setVisibility(View.INVISIBLE);
            bt_not_found.setVisibility(View.INVISIBLE);
            bt_kill.setVisibility(View.INVISIBLE);
            bt_sell.setVisibility(View.INVISIBLE);
            bt_move.setVisibility(View.INVISIBLE);
            bt_laying_workers.setVisibility(View.INVISIBLE);
            t_queen_right.setVisibility(View.INVISIBLE);
            bt_create_queen.setVisibility(View.INVISIBLE);
            bt_not_seen.setVisibility(View.INVISIBLE);
            bt_not_seen2.setVisibility(View.INVISIBLE);
            t_culled.setVisibility(View.INVISIBLE);
            t_emerged.setVisibility(View.INVISIBLE);

        }


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.queen, menu);
		return true;

    }

    public void Take_note(View view) {
        Toast.makeText(this.getApplicationContext(), "Take a Note", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, VisitNote.class);
        startActivity(intent);
    }


    public void QueenDetails(View view) {
        Toast.makeText(this.getApplicationContext(), "Queen Details", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, QueenDetails.class);
        startActivity(intent);
    }


    public void CreateQueen(View view) {
        Toast.makeText(this.getApplicationContext(), "Create Queen", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, CreateQueen.class);
        startActivity(intent);
    }

    public void QueenSeen(View view) {

        ToggleButton t_gone = (ToggleButton) findViewById(R.id.t_gone);
        ToggleButton t_not_seen_found = (ToggleButton) findViewById(R.id.t_not_seen_found);
        ToggleButton t_remove_queen = (ToggleButton) findViewById(R.id.t_remove_queen);
        Button bt_confine = (Button) findViewById(R.id.bt_confine);
        ToggleButton seen = (ToggleButton) findViewById(R.id.t_seen);

        Toast.makeText(this.getApplicationContext(), "Seen", Toast.LENGTH_SHORT).show();



        if (seen.isChecked())
        {
            t_remove_queen.setVisibility(View.VISIBLE);
            bt_confine.setVisibility(View.VISIBLE);

            t_not_seen_found.setEnabled(false);
            t_gone.setEnabled(false);

        }

        else
        {
            t_remove_queen.setVisibility(View.INVISIBLE);
            bt_confine.setVisibility(View.INVISIBLE);

            t_not_seen_found.setEnabled(true);
            t_gone.setEnabled(true);
        }

    }

    public void QueenNotSeenFound(View view){
        ToggleButton t_gone = (ToggleButton) findViewById(R.id.t_gone);
        ToggleButton t_not_seen_found = (ToggleButton) findViewById(R.id.t_not_seen_found);
        ToggleButton t_seen = (ToggleButton) findViewById(R.id.t_seen);
        Button bt_not_found = (Button) findViewById(R.id.bt_not_found);
        Button bt_not_seen = (Button) findViewById(R.id.bt_not_seen);

        if (t_not_seen_found.isChecked())
        {
            bt_not_found.setVisibility(View.VISIBLE);
            bt_not_seen.setVisibility(View.VISIBLE);
            t_gone.setEnabled(false);
            t_seen.setEnabled(false);
        }

        else
        {
            bt_not_found.setVisibility(View.INVISIBLE);
            bt_not_seen.setVisibility(View.INVISIBLE);
            t_seen.setEnabled(true);
            t_gone.setEnabled(true);

        }

    }


    public void QueenGone(View view) {
        ToggleButton t_gone = (ToggleButton) findViewById(R.id.t_gone);
        ToggleButton t_not_seen_found = (ToggleButton) findViewById(R.id.t_not_seen_found);
        ToggleButton t_seen = (ToggleButton) findViewById(R.id.t_seen);
        ToggleButton t_introduce = (ToggleButton) findViewById(R.id.t_introduce);
        Button bt_laying_workers = (Button) findViewById(R.id.bt_laying_workers);
        ToggleButton t_queen_right = (ToggleButton) findViewById(R.id.t_queen_right);

        if (t_gone.isChecked())
        {
            bt_laying_workers.setVisibility(View.VISIBLE);
            t_introduce.setVisibility(View.VISIBLE);
            t_queen_right.setVisibility(View.VISIBLE);

            t_not_seen_found.setEnabled(false);
            t_seen.setEnabled(false);

        }

        else
        {
            bt_laying_workers.setVisibility(View.INVISIBLE);
            t_introduce.setVisibility(View.INVISIBLE);
            t_queen_right.setVisibility(View.INVISIBLE);

            t_not_seen_found.setEnabled(true);
            t_seen.setEnabled(true);
        }
    }

    public void Introduce(View view){
        ToggleButton t_introduce = (ToggleButton) findViewById(R.id.t_introduce);
        ToggleButton t_gone = (ToggleButton) findViewById(R.id.t_gone);
        Button bt_create_queen = (Button) findViewById(R.id.bt_create_queen);
        Button bt_existing = (Button) findViewById(R.id.bt_existing);
        Button bt_laying_workers = (Button) findViewById(R.id.bt_laying_workers);
        ToggleButton t_queen_right = (ToggleButton) findViewById(R.id.t_queen_right);



        if (t_introduce.isChecked())
        {
            bt_create_queen.setVisibility(View.VISIBLE);
            bt_existing.setVisibility(View.VISIBLE);
            t_gone.setEnabled(false);
            bt_laying_workers.setEnabled(false);
            t_queen_right.setEnabled(false);
        }

        else
        {
            bt_create_queen.setVisibility(View.INVISIBLE);
            bt_existing.setVisibility(View.INVISIBLE);
            t_gone.setEnabled(true);
            bt_laying_workers.setEnabled(true);
            t_queen_right.setEnabled(true);


        }


    }

    public void QueenRight(View view){
        ToggleButton t_queen_right = (ToggleButton) findViewById(R.id.t_queen_right);
        ToggleButton t_gone = (ToggleButton) findViewById(R.id.t_gone);
        Button bt_create_queen = (Button) findViewById(R.id.bt_create_queen);
        Button bt_kill = (Button) findViewById(R.id.bt_kill);
        Button bt_laying_workers = (Button) findViewById(R.id.bt_laying_workers);
        ToggleButton t_introduce = (ToggleButton) findViewById(R.id.t_introduce);
        Button bt_not_seen2 = (Button) findViewById(R.id.bt_not_seen2);


        if (t_queen_right.isChecked())
        {
            bt_create_queen.setVisibility(View.VISIBLE);
            bt_not_seen2.setVisibility(View.VISIBLE);
            t_gone.setEnabled(false);
            bt_kill.setVisibility(View.VISIBLE);
            bt_laying_workers.setEnabled(false);
            t_introduce.setEnabled(false);


        }

        else
        {

            bt_create_queen.setVisibility(View.INVISIBLE);
            bt_not_seen2.setVisibility(View.INVISIBLE);
            bt_kill.setVisibility(View.INVISIBLE);
            t_gone.setEnabled(true);
            bt_laying_workers.setEnabled(true);
            t_introduce.setEnabled(true);
        }
    }

    public void Remove(View view){
        ToggleButton t_remove_queen = (ToggleButton) findViewById(R.id.t_remove_queen);
        Button bt_confine = (Button) findViewById(R.id.bt_confine);
        Button bt_kill = (Button) findViewById(R.id.bt_kill);
        Button bt_sell = (Button) findViewById(R.id.bt_sell);
        Button bt_move = (Button) findViewById(R.id.bt_move);
        ToggleButton t_seen = (ToggleButton) findViewById(R.id.t_seen);



        if (t_remove_queen.isChecked())
        {
            bt_confine.setEnabled(false);
            t_seen.setEnabled(false);
            bt_kill.setVisibility(View.VISIBLE);
            bt_sell.setVisibility(View.VISIBLE);
            bt_move.setVisibility(View.VISIBLE);
        }

        else
        {
            bt_confine.setEnabled(true);
            t_seen.setEnabled(true);
            bt_kill.setVisibility(View.INVISIBLE);
            bt_sell.setVisibility(View.INVISIBLE);
            bt_move.setVisibility(View.INVISIBLE);

        }


    }


    public void QcellsSeen(View view){
        ToggleButton t_culled = (ToggleButton) findViewById(R.id.t_culled);
        ToggleButton t_emerged = (ToggleButton) findViewById(R.id.t_emerged);
        ToggleButton t_Qcells = (ToggleButton) findViewById(R.id.t_queen_cells);


        if (t_Qcells.isChecked())
        {
            t_culled.setVisibility(View.VISIBLE);
            t_emerged.setVisibility(View.VISIBLE);
        }

        else
        {
            t_culled.setVisibility(View.INVISIBLE);
            t_emerged.setVisibility(View.INVISIBLE);

        }


    }









}


