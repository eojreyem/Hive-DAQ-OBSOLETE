package com.centerorbit.hive_daq.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "AME.db";


    //USER TABLE
    public static final String TABLE_NAME_USER = "User";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PASSWORD = "password";


    //YARD TABLE
    public static final String TABLE_NAME_YARD = "Yard";
    public static final String COLUMN_YARD_ID = "yard_id";
    //"name"
    public static final String COLUMN_DATE_CREATED = "date_created";


    //COLONY TABLE
    public static final String TABLE_NAME_COLONY = "Colony";
    public static final String COLUMN_COLONY_ID = "colony_id";
    // "name"
    public static final String COLUMN_NFC_TAG = "nfc_tag";
    //"yard_id"
    //"date_created"
    public static final String COLUMN_DATE_DELETED = "date_deleted";
    public static final String COLUMN_REASON_DELETED = "reason_deleted_id";
    public static final String COLUMN_SOURCE_TYPE = "source_type_id";
    public static final String COLUMN_SOURCE = "bee_source_id";
    public static final String COLUMN_PARENT_COLONY = "parent_colony_id";
    public static final String COLUMN_HIVE_TYPE = "hive_type_id";
    public static final String COLUMN_QUEEN_STATUS = "queen_status_id";
    public static final String COLUMN_REIGNING_QUEEN = "reigning_queen_id";
    public static final String COLUMN_NOTE = "note";


    //QUEEN TABLE
    public static final String TABLE_NAME_QUEEN = "Queen";
    public static final String COLUMN_QUEEN_ID = "queen_id";
    // "name"
    public static final String COLUMN_IN_COLONY = "in_colony_id";
    public static final String COLUMN_MOTHER = "mother_queen_id";
    // COLUMN_SOURCE = "bee_source_id"
    // "date_created"
    public static final String COLUMN_WEEKS_LAYING = "weeks_laying";
    // "date_deleted"
    // COLUMN_REASON_DELETED = "reason_deleted_id";
    public static final String COLUMN_RACE = "race_id";
    public static final String COLUMN_MARK_COLOR = "mark_color";
    // "note"


    //VISIT TABLE  TODO- check over
    public static final String TABLE_NAME_VISIT = "Visit";
    public static final String COLUMN_VISIT_ID = "visit_id";
    // "yard_id"
    // "colony_id"
    // "queen_id"
    public static final String COLUMN_QUEEN_ID_NEW = "queen_id_new";
    public static final String COLUMN_DATE_TIME_START = "date_time_start";
    public static final String COLUMN_DATE_TIME_CLOSED = "date_time_closed";
    // "user_id"
    public static final String COLUMN_QTY_SUPER = "qty_super";
    public static final String COLUMN_QTY_DEEP = "qty_deep";
    public static final String COLUMN_POLLEN_SUB = "feeding_pollen_sub";
    public static final String COLUMN_FEEDING_SYRUP = "feeding_syrup";

    //VISIT_NOTE TABLE
    public static final String TABLE_NAME_VISIT_NOTE = "Visit_Note";
    public static final String COLUMN_NOTE_ID = "note_id";
    // "visit_id"
    // "note"
    public static final String COLUMN_REMINDER = "note_reminder";

    //VISIT_ACTION TABLE
    public static final String TABLE_NAME_VISIT_ACTION = "Visit_Action";
    public static final String COLUMN_VISIT_ACTION_ID = "visit_action_id";
    // "visit_id"
    public static final String COLUMN_ACTION_ID = "action_id";

    private static final String DICTIONARY_TABLE_CREATE_USER =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_USER + " (" +
                    COLUMN_USER_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_PASSWORD + " TEXT);";


    private static final String DICTIONARY_TABLE_CREATE_YARD =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_YARD + " (" +
                    COLUMN_YARD_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_DATE_CREATED + " TEXT);";

    private static final String DICTIONARY_TABLE_CREATE_COLONY =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_COLONY + " (" +
                    COLUMN_COLONY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_NFC_TAG + " TEXT, " +
                    COLUMN_YARD_ID + " INTEGER, " +
                    COLUMN_DATE_CREATED + " TEXT, " +
                    COLUMN_DATE_DELETED + " TEXT, " +
                    COLUMN_REASON_DELETED + " INTEGER, " +
                    COLUMN_SOURCE_TYPE + " INTEGER, " +
                    COLUMN_SOURCE + " INTEGER, " +
                    COLUMN_PARENT_COLONY + " INTEGER, " +
                    COLUMN_HIVE_TYPE + " INTEGER, " +
                    COLUMN_QUEEN_STATUS + " INTEGER, " +
                    COLUMN_REIGNING_QUEEN + " INTEGER, " +
                    COLUMN_NOTE + " TEXT);";

    private static final String DICTIONARY_TABLE_CREATE_QUEEN =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_QUEEN + " (" +
                    COLUMN_QUEEN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_IN_COLONY + " INTEGER, " +
                    COLUMN_MOTHER + " INTEGER, " +
                    COLUMN_SOURCE + " INTEGER, " +
                    COLUMN_DATE_CREATED + " TEXT, " +
                    COLUMN_WEEKS_LAYING + " INTEGER, " +
                    COLUMN_DATE_DELETED + " TEXT, " +
                    COLUMN_REASON_DELETED + " INTEGER, " +
                    COLUMN_RACE + " INTEGER, " +
                    COLUMN_MARK_COLOR + " TEXT, " +
                    COLUMN_NOTE + " TEXT);";

    private static final String DICTIONARY_TABLE_CREATE_VISIT =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_VISIT + " (" +
                    COLUMN_VISIT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_YARD_ID + " INTEGER, " +
                    COLUMN_COLONY_ID + " INTEGER, " +
                    COLUMN_QUEEN_ID + " INTEGER, " +
                    COLUMN_QUEEN_ID_NEW + " INTEGER, " +
                    COLUMN_DATE_TIME_START + " TEXT, " +
                    COLUMN_DATE_TIME_CLOSED + " TEXT, " +
                    COLUMN_USER_ID + " INTEGER, " +
                    COLUMN_QTY_SUPER + " INTEGER, " +
                    COLUMN_QTY_DEEP + " INTEGER, " +
                    COLUMN_POLLEN_SUB + " INTEGER, " +
                    COLUMN_FEEDING_SYRUP + " INTEGER);";

    private static final String DICTIONARY_TABLE_CREATE_VISIT_NOTE =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_VISIT_NOTE + " (" +
                    COLUMN_NOTE_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_VISIT_ID + " INTEGER, " +
                    COLUMN_NOTE + " TEXT, " +
                    COLUMN_REMINDER + " INTEGER);";

    private static final String DICTIONARY_TABLE_CREATE_VISIT_ACTION =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_VISIT_ACTION + " (" +
                    COLUMN_VISIT_ACTION_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_VISIT_ID + " INTEGER, " +
                    COLUMN_ACTION_ID + " INTEGER);";



    DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DICTIONARY_TABLE_CREATE_USER);
        db.execSQL(DICTIONARY_TABLE_CREATE_YARD);
        db.execSQL(DICTIONARY_TABLE_CREATE_COLONY);
        db.execSQL(DICTIONARY_TABLE_CREATE_QUEEN);
        db.execSQL(DICTIONARY_TABLE_CREATE_VISIT);
        db.execSQL(DICTIONARY_TABLE_CREATE_VISIT_NOTE);
        db.execSQL(DICTIONARY_TABLE_CREATE_VISIT_ACTION);

    }
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_COLONY);
        onCreate(db);
	}
}
