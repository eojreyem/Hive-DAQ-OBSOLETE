package com.centerorbit.hive_daq.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {


    //TODO Can you review this Andy LeT?

    //delete this replace with comment below?
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Hive_DAQ";
    public static final String TABLE_NAME = "hive";
    public static final String COLUMN_ID = "hive_id";
    public static final String COLUMN_TITLE = "title";


/*
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "AME";


    //USER TABLE
    public static final String TABLE_NAME_USER = "User";
    public static final String COLUMN_ID_USER = "user_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PASSWORD = "password";


    //YARD TABLE
    public static final String TABLE_NAME_YARD = "Yard";
    public static final String COLUMN_ID_YARD = "yard_id";
    //public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DATE_CREATED = "date_created";


    //COLONY TABLE
    public static final String TABLE_NAME_COLONY = "Colony";
    public static final String COLUMN_ID_COLONY = "colony_id";
    //public static final String COLUMN_NAME = "name";
    public static final String COLUMN_NFC_TAG = "nfc_tag";
    public static final String COLUMN_YARD_ID = "yard_id";
    //public static final String COLUMN_DATE_CREATED = "date_created";
    public static final String COLUMN_DATE_DELETED = "date_deleted";
    public static final String COLUMN_REASON_DELETED = "reason_deleted";
    public static final String COLUMN_SOURCE_TYPE = "source_type";
    public static final String COLUMN_SOURCE = "source";
    public static final String COLUMN_PARENT_COLONY = "parent_colony";
    public static final String COLUMN_HIVE_TYPE = "hive_type";
    public static final String COLUMN_QUEEN_STATUS = "queen_status";
    public static final String COLUMN_REIGNING_QUEEN = "reigning_queen";
    public static final String COLUMN_NOTE = "note";


    //QUEEN TABLE
    public static final String TABLE_NAME_QUEEN = "Queen";
    public static final String COLUMN_ID_QUEEN = "queen_id";
    //public static final String COLUMN_NAME = "name";
    public static final String COLUMN_IN_COLONY = "in_colony";
    public static final String COLUMN_MOTHER = "mother";
    //public static final String COLUMN_SOURCE = "source";
    //public static final String COLUMN_DATE_CREATED = "date_created";
    public static final String COLUMN_WEEKS_LAYING = "weeks_laying";
    //public static final String COLUMN_DATE_DELETED = "date_deleted";
    public static final String COLUMN_RACE = "race";
    public static final String COLUMN_MARK_COLOR = "mark_color";
    public static final String COLUMN_DATE_LAST_SEEN = "date_last_seen"; //is date last seen needed? Or just query Visit table?
    //public static final String COLUMN_NOTE = "note";



    */



    //delete this replace with comment below?
    private static final String DICTIONARY_TABLE_CREATE =
	"CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
            COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_TITLE + " TEXT);";

/*
    private static final String DICTIONARY_TABLE_CREATE_USER =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_USER + " (" +
                    COLUMN_ID_USER +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +COLUMN_PASSWORD + " TEXT);";


    private static final String DICTIONARY_TABLE_CREATE_YARD =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_YARD + " (" +
                    COLUMN_ID_YARD +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +COLUMN_DATE_CREATED + " TEXT);";

    private static final String DICTIONARY_TABLE_CREATE_COLONY =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_COLONY + " (" +
                    COLUMN_ID_COLONY +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " + COLUMN_NFC_TAG + " TEXT, " + COLUMN_YARD_ID + " INTEGER, " +
                    COLUMN_DATE_CREATED + " TEXT, " + COLUMN_DATE_DELETED + " TEXT, " + COLUMN_REASON_DELETED + " INTEGER, " +
                    COLUMN_SOURCE_TYPE + " INTEGER, " + COLUMN_SOURCE + " INTEGER, " + COLUMN_PARENT_COLONY + " INTEGER, " +
                    COLUMN_HIVE_TYPE + " INTEGER, " + COLUMN_QUEEN_STATUS + " INTEGER, " + COLUMN_REIGNING_QUEEN + " INTEGER, " +
                    COLUMN_NOTE + " TEXT);";

    private static final String DICTIONARY_TABLE_CREATE_QUEEN =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_QUEEN + " (" +
                    COLUMN_ID_QUEEN +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " + COLUMN_IN_COLONY + " INTEGER, " + COLUMN_MOTHER + " INTEGER, " +
                    COLUMN_SOURCE + " INTEGER, " + COLUMN_DATE_CREATED + " TEXT, " + COLUMN_WEEKS_LAYING + " INTEGER, " +
                    COLUMN_DATE_DELETED + " TEXT, " + COLUMN_REASON_DELETED + " INTEGER, " + COLUMN_RACE + " INTEGER, " +
                    COLUMN_MARK_COLOR + " TEXT, " + COLUMN_DATE_LAST_SEEN + " TEXT, " +
                    COLUMN_NOTE + " TEXT);";

*/



    DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DICTIONARY_TABLE_CREATE);
        /*
        db.execSQL(DICTIONARY_TABLE_CREATE_USER);
        db.execSQL(DICTIONARY_TABLE_CREATE_YARD);
        db.execSQL(DICTIONARY_TABLE_CREATE_COLONY);
        db.execSQL(DICTIONARY_TABLE_CREATE_QUEEN);
         */




    }
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		
	}
}
