package com.centerorbit.hive_daq.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ColonyDataSource {
	private ColonyOpenHelper databaseOpener;
	private SQLiteDatabase database;
	private String[] allColumns = {
			ColonyOpenHelper.COLUMN_ID,
			ColonyOpenHelper.COLUMN_TITLE,
			ColonyOpenHelper.COLUMN_URL
	};
	private Context appContext;
	
	public ColonyDataSource(Context context) {
		this.appContext = context;
		databaseOpener = new ColonyOpenHelper(appContext);
	}
	
	 public void open() throws SQLException {
		 database = databaseOpener.getWritableDatabase();
	  }
	 
	 public void close() {
		 databaseOpener.close();
	  }
	 
	 public List<Colony> getAllColonies(){
		 List<Colony> colonies = new ArrayList<Colony>();
		 
		 Cursor cursor = database.query(ColonyOpenHelper.TABLE_NAME, allColumns, null, null, null, null,null);
		 cursor.moveToFirst();
	    while (!cursor.isAfterLast()) {
	    	Colony colony = cursorToColony(cursor);
	    	colonies.add(colony);
	    	cursor.moveToNext();
	    }
	    // Make sure to close the cursor
	    cursor.close();
	    return colonies;
	 }
	 
	 public Colony createColony(String hiveName) {

        Cursor cursor;

        //Now check for a duplicate entry
        cursor = database.query(ColonyOpenHelper.TABLE_NAME,
                allColumns, ColonyOpenHelper.COLUMN_TITLE + " = ?",
                new String[]{hiveName},
                null, null, null);
        long exists = cursor.getCount();

        if (exists != 0){
            Toast.makeText(appContext,
                       "It appears that "+hiveName+" already exists!", Toast.LENGTH_LONG)
            .show();
            return null;
        }
        ContentValues insertValues = new ContentValues();
        insertValues.put(ColonyOpenHelper.COLUMN_TITLE, hiveName);
        insertValues.put(ColonyOpenHelper.COLUMN_URL, "");
        long insertId = database.insert(ColonyOpenHelper.TABLE_NAME, null, insertValues);
        cursor = database.query(ColonyOpenHelper.TABLE_NAME,
                allColumns, ColonyOpenHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Colony newColony = cursorToColony(cursor);
        cursor.close();
        return newColony;
	 }
	 
	 public void deleteColony(Colony colony) {
		    long id = colony.getId();
		    Toast.makeText(appContext,
					   "Deleted " + colony.getTitle(), Toast.LENGTH_LONG)
			.show();
		    database.delete(ColonyOpenHelper.TABLE_NAME, ColonyOpenHelper.COLUMN_ID
		        + " = " + id, null);
		  }

	 
	 private Colony cursorToColony(Cursor cursor) {
		 Colony colony = new Colony();
		 colony.setId(cursor.getLong(0));
		 colony.setTitle(cursor.getString(1));
		 colony.setUrl(cursor.getString(2));
		 return colony;
	  }
}
