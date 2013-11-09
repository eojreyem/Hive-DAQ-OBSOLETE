package com.centerorbit.hive_daq.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Hive_DAQ";
    //TODO: Table name should be uppercase.
    public static final String TABLE_NAME = "hive";
    public static final String COLUMN_ID = "hive_id";
    public static final String COLUMN_TITLE = "title";
    
    private static final String DICTIONARY_TABLE_CREATE =
	"CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
            COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_TITLE + " TEXT);";

    DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DICTIONARY_TABLE_CREATE);
    }
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		
	}
}
