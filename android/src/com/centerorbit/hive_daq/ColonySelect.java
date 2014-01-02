package com.centerorbit.hive_daq;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.centerorbit.hive_daq.model.Colony;
import com.centerorbit.hive_daq.model.MainDataSource;

import java.util.List;

public class ColonySelect extends Activity {

    private MainDataSource datasource;
    private Context appContext;
    private ArrayAdapter<Colony> adapter;
    private Activity that;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_colony_select);

        this.appContext = this;
        that = this;

        ListView listView = (ListView) findViewById(R.id.colony_list);

        datasource = new MainDataSource(appContext);
        datasource.open();

        List<Colony> values = datasource.Colony().getAll();

        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data
        adapter = new ArrayAdapter<Colony>(
                this,
                android.R.layout.simple_list_item_1,
                values
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                final String selectedFromList = parent.getItemAtPosition(position).toString();

                AlertDialog.Builder builder = new AlertDialog.Builder(appContext);
                builder.setMessage("An inspection of colony \"" + selectedFromList + "\" on [DATE] is already in progress!")
                        .setCancelable(false)
                        .setPositiveButton("Resume last inspection", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(getApplicationContext(),
                                        "Resume "+selectedFromList, Toast.LENGTH_SHORT)
                                        .show();
                                Intent intent = new Intent(that, VisitColony.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Begin a new inspection", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(getApplicationContext(),
                                        "New session "+selectedFromList, Toast.LENGTH_SHORT)
                                        .show();
                                Intent intent = new Intent(that, VisitColony.class);
                                startActivity(intent);
                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {

                final Colony selectedFromList = (Colony) parent.getItemAtPosition(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(appContext);
                builder.setMessage("Are you sure you want to delete "+selectedFromList.getName()+"?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                deleteColony(selectedFromList);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();


                return true;
            }
        });
    }

    private void deleteColony(Colony colony){
        datasource.Colony().delete(colony);
        adapter.remove(colony);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.colony_select, menu);
		return true;
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
}
