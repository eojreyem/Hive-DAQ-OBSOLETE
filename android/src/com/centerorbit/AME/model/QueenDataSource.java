package com.centerorbit.AME.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joe on 1/5/14.
 */
public class QueenDataSource {
    private MainDataSource home;
    private String[] allColumns = {
            DatabaseOpenHelper.COLUMN_QUEEN_ID,
            DatabaseOpenHelper.COLUMN_NAME,
            DatabaseOpenHelper.COLUMN_IN_COLONY_ID,
            DatabaseOpenHelper.COLUMN_MOTHER_QUEEN_ID,
            DatabaseOpenHelper.COLUMN_BEE_SOURCE_ID,
            DatabaseOpenHelper.COLUMN_DATE_CREATED,
            DatabaseOpenHelper.COLUMN_DATE_MATED,
            DatabaseOpenHelper.COLUMN_DATE_DELETED,
            DatabaseOpenHelper.COLUMN_REASON_DELETED_ID,
            DatabaseOpenHelper.COLUMN_RACE_ID,
            DatabaseOpenHelper.COLUMN_MARK_COLOR_HEX,
            DatabaseOpenHelper.COLUMN_NOTE
    };

    public QueenDataSource(MainDataSource home) {
        this.home = home;
    }

    public List<Queen> getAll(){
        List<Queen> Queens = new ArrayList<Queen>();

        Cursor cursor = home.database.query(DatabaseOpenHelper.TABLE_NAME_QUEEN, allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Queen queen = this.cursorToQueen(cursor);
            Queens.add(queen);
            cursor.moveToNext();
        }
        // Make sure to close the cursor
        cursor.close();
        return Queens;
    }

    public Queen create(String queenName, String createDate, String note) { /*, String mother...
                          String note){ */
        Cursor cursor;

        //Name should be unique. Query DB and check.
        cursor = home.database.query(DatabaseOpenHelper.TABLE_NAME_QUEEN,
                allColumns, DatabaseOpenHelper.COLUMN_NAME + " = ?",
                new String[]{queenName},
                null, null, null);
        long exists = cursor.getCount();

        if (exists != 0){
            home.notice("It appears that "+queenName+" already exists!", Toast.LENGTH_LONG);
            return null;  //returns null if queen is not unique.
        }

        // If unique, create queen.
        ContentValues insertValues = new ContentValues();
        insertValues.put(DatabaseOpenHelper.COLUMN_NAME, queenName);
        insertValues.put(DatabaseOpenHelper.COLUMN_DATE_CREATED, createDate);
        insertValues.put(DatabaseOpenHelper.COLUMN_NOTE, note);


        long insertId = home.database.insert(DatabaseOpenHelper.TABLE_NAME_QUEEN, null, insertValues);

        //TODO check to make sure it worked. Throw an exception if something went wrong.

        cursor = home.database.query(DatabaseOpenHelper.TABLE_NAME_QUEEN,
                allColumns, DatabaseOpenHelper.COLUMN_QUEEN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Queen newQueen = cursorToQueen(cursor);
        cursor.close();
        return newQueen;
    }


    public void delete(Queen queen) {
        long id = queen.getId();
        home.notice("Deleted " + queen.getName(), Toast.LENGTH_LONG);

        home.database.delete(DatabaseOpenHelper.TABLE_NAME_QUEEN, DatabaseOpenHelper.COLUMN_QUEEN_ID
                + " = " + id, null);
    }


    private Queen cursorToQueen(Cursor cursor) {
        Queen queen = new Queen();

        queen.setId(cursor.getLong(0));
        queen.setName(cursor.getString(1));
        queen.setDateCreated(cursor.getString(2));
        queen.setNote(cursor.getString(3));

        return queen;
    }
}
