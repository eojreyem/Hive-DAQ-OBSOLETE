package com.centerorbit.hive_daq.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ColonyDataSource {
    private MainDataSource home;
	private String[] allColumns = {
			DatabaseOpenHelper.COLUMN_COLONY_ID,
			DatabaseOpenHelper.COLUMN_NAME,
            DatabaseOpenHelper.COLUMN_NFC_TAG,
            DatabaseOpenHelper.COLUMN_YARD_ID,
            DatabaseOpenHelper.COLUMN_DATE_CREATED,
            DatabaseOpenHelper.COLUMN_DATE_DELETED,
            DatabaseOpenHelper.COLUMN_REASON_DELETED,
            DatabaseOpenHelper.COLUMN_SOURCE_TYPE,
            DatabaseOpenHelper.COLUMN_SOURCE,
            DatabaseOpenHelper.COLUMN_PARENT_COLONY,
            DatabaseOpenHelper.COLUMN_HIVE_TYPE,
            DatabaseOpenHelper.COLUMN_QUEEN_STATUS,
            DatabaseOpenHelper.COLUMN_REIGNING_QUEEN,
            DatabaseOpenHelper.COLUMN_NOTE
    };

	public ColonyDataSource(MainDataSource home) {
		this.home = home;
	}

	 public List<Colony> getAll(){
		 List<Colony> colonies = new ArrayList<Colony>();
		 
		 Cursor cursor = home.database.query(DatabaseOpenHelper.TABLE_NAME_COLONY, allColumns, null, null, null, null, null);
		 cursor.moveToFirst();
	    while (!cursor.isAfterLast()) {
	    	Colony colony = this.cursorToColony(cursor);
	    	colonies.add(colony);
	    	cursor.moveToNext();
	    }
	    // Make sure to close the cursor
	    cursor.close();
	    return colonies;
	 }
	 
	 public Colony create(String colonyName, String createDate, String note) { /*, String colonyNFC, int colonyYardId,  String dateCreated,
                          int sourceTypeId, int beeSourceId, int parentColonyId, int hiveTypeId,
                          String note){ */
        Cursor cursor;

        //Name should be unique. Query DB and check.
        cursor = home.database.query(DatabaseOpenHelper.TABLE_NAME_COLONY,
                allColumns, DatabaseOpenHelper.COLUMN_NAME + " = ?",
                new String[]{colonyName},
                null, null, null);
        long exists = cursor.getCount();

        if (exists != 0){
            home.notice("It appears that "+colonyName+" already exists!", Toast.LENGTH_LONG);
            return null;  //returns null if colony is not unique.
        }

         // If unique, create colony.
         ContentValues insertValues = new ContentValues();
         insertValues.put(DatabaseOpenHelper.COLUMN_NAME, colonyName);
         insertValues.put(DatabaseOpenHelper.COLUMN_DATE_CREATED, createDate);
         insertValues.put(DatabaseOpenHelper.COLUMN_NOTE, note);
         /*
         insertValues.put(DatabaseOpenHelper.COLUMN_NFC_TAG, colonyNFC);
         insertValues.put(DatabaseOpenHelper.COLUMN_DATE_CREATED, dateCreated);
         insertValues.put(DatabaseOpenHelper.COLUMN_SOURCE_TYPE, sourceTypeId);
         insertValues.put(DatabaseOpenHelper.COLUMN_SOURCE, beeSourceId);
         insertValues.put(DatabaseOpenHelper.COLUMN_PARENT_COLONY, parentColonyId);
         insertValues.put(DatabaseOpenHelper.COLUMN_HIVE_TYPE, hiveTypeId);
         insertValues.put(DatabaseOpenHelper.COLUMN_NOTE, note);
         insertValues.put(DatabaseOpenHelper.COLUMN_YARD_ID, colonyYardId);
*/

        long insertId = home.database.insert(DatabaseOpenHelper.TABLE_NAME_COLONY, null, insertValues);

         //TODO check to make sure it worked. Throw an exception if something went wrong.

        cursor = home.database.query(DatabaseOpenHelper.TABLE_NAME_COLONY,
                allColumns, DatabaseOpenHelper.COLUMN_COLONY_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Colony newColony = cursorToColony(cursor);
        cursor.close();
        return newColony;
	 }


	 public void delete(Colony colony) {
		    long id = colony.getId();
		    home.notice("Deleted " + colony.getName(), Toast.LENGTH_LONG);

            home.database.delete(DatabaseOpenHelper.TABLE_NAME_COLONY, DatabaseOpenHelper.COLUMN_COLONY_ID
		        + " = " + id, null);
		  }

	 
	 private Colony cursorToColony(Cursor cursor) {
		 Colony colony = new Colony();

		 colony.setId(cursor.getLong(0));
		 colony.setName(cursor.getString(1));
         colony.setDateCreated(cursor.getString(2));
         colony.setNote(cursor.getString(3)); /*
         colony.setNFC(cursor.getString(2));
         colony.setYardId(cursor.getInt(3));
         colony.setDateDeleted(cursor.getString(5));
         colony.setReasonDeletedId(cursor.getInt(6));
         colony.setSourceTypeId(cursor.getInt(7));
         colony.setBeeSourceId(cursor.getInt(8));
         colony.setParentColonyId(cursor.getInt(9));
         colony.setParentColonyId(cursor.getInt(10));
         colony.setHiveTypeId(cursor.getInt(11));
         colony.setQueenStatusId(cursor.getInt(12));
         colony.setReigningQueenId(cursor.getInt(13));*/

		 return colony;
	  }
}
