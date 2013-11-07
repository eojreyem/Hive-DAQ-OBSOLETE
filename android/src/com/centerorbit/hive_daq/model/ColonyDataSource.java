package com.centerorbit.hive_daq.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ColonyDataSource {
    private MainDataSource home;
	private String[] allColumns = {
			DatabaseOpenHelper.COLUMN_ID,
			DatabaseOpenHelper.COLUMN_TITLE
	};

	public ColonyDataSource(MainDataSource home) {
		this.home = home;
	}

	 public List<Colony> getAll(){
		 List<Colony> colonies = new ArrayList<Colony>();
		 
		 Cursor cursor = home.database.query(DatabaseOpenHelper.TABLE_NAME, allColumns, null, null, null, null,null);
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
	 
	 public Colony create(String hiveName) {

        Cursor cursor;

        //Now check for a duplicate entry
        cursor = home.database.query(DatabaseOpenHelper.TABLE_NAME,
                allColumns, DatabaseOpenHelper.COLUMN_TITLE + " = ?",
                new String[]{hiveName},
                null, null, null);
        long exists = cursor.getCount();

        if (exists != 0){
            home.notice("It appears that "+hiveName+" already exists!", Toast.LENGTH_LONG);
            return null;
        }
        ContentValues insertValues = new ContentValues();
        insertValues.put(DatabaseOpenHelper.COLUMN_TITLE, hiveName);
        long insertId = home.database.insert(DatabaseOpenHelper.TABLE_NAME, null, insertValues);
        cursor = home.database.query(DatabaseOpenHelper.TABLE_NAME,
                allColumns, DatabaseOpenHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Colony newColony = cursorToColony(cursor);
        cursor.close();
        return newColony;
	 }


	 public void delete(Colony colony) {
		    long id = colony.getId();
		    home.notice("Deleted " + colony.getTitle(), Toast.LENGTH_LONG);

            home.database.delete(DatabaseOpenHelper.TABLE_NAME, DatabaseOpenHelper.COLUMN_ID
		        + " = " + id, null);
		  }

	 
	 private Colony cursorToColony(Cursor cursor) {
		 Colony colony = new Colony();
		 colony.setId(cursor.getLong(0));
		 colony.setTitle(cursor.getString(1));
		 return colony;
	  }
}
