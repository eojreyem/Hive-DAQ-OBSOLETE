package com.centerorbit.hive_daq;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class QueenEval extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_queen_eval);

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

        Toast.makeText(this.getApplicationContext(), "Seen", Toast.LENGTH_SHORT).show();

        ToggleButton seen = (ToggleButton) findViewById(R.id.toggle_seen);

        if (seen.isChecked())
        {
            Button bt_move_queen = (Button) findViewById(R.id.bt_move_queen);
            bt_move_queen.setVisibility(View.VISIBLE);

            Button bt_kill_queen = (Button) findViewById(R.id.bt_kill_queen);
            bt_kill_queen.setVisibility(View.VISIBLE);

            Button bt_confine = (Button) findViewById(R.id.bt_confine);
            bt_confine.setVisibility(View.VISIBLE);

            Button bt_sell_queen = (Button) findViewById(R.id.bt_sell_queen);
            bt_sell_queen.setVisibility(View.VISIBLE);

            Button bt_not_seen = (Button) findViewById(R.id.bt_not_seen);
            bt_not_seen.setVisibility(View.INVISIBLE);

            Button bt_not_found = (Button) findViewById(R.id.bt_not_found);
            bt_not_found.setVisibility(View.INVISIBLE);

            Button bt_gone = (Button) findViewById(R.id.bt_gone);
            bt_gone.setVisibility(View.INVISIBLE);

        }

        else
        {
            Button bt_move_queen = (Button) findViewById(R.id.bt_move_queen);
            bt_move_queen.setVisibility(View.INVISIBLE);

            Button bt_kill_queen = (Button) findViewById(R.id.bt_kill_queen);
            bt_kill_queen.setVisibility(View.INVISIBLE);

            Button bt_confine = (Button) findViewById(R.id.bt_confine);
            bt_confine.setVisibility(View.INVISIBLE);

            Button bt_sell_queen = (Button) findViewById(R.id.bt_sell_queen);
            bt_sell_queen.setVisibility(View.INVISIBLE);

            Button bt_not_seen = (Button) findViewById(R.id.bt_not_seen);
            bt_not_seen.setVisibility(View.VISIBLE);

            Button bt_not_found = (Button) findViewById(R.id.bt_not_found);
            bt_not_found.setVisibility(View.VISIBLE);

            Button bt_gone = (Button) findViewById(R.id.bt_gone);
            bt_gone.setVisibility(View.VISIBLE);
        }


    }

}


