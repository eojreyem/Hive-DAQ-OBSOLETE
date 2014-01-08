package com.centerorbit.AME.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.widget.Toast;

/**
 * Created by joe on 1/7/14.
 */
public class VisitDataSource {
    private MainDataSource home;
    private String[] allColumns = {
            DatabaseOpenHelper.COLUMN_VISIT_ID,
            DatabaseOpenHelper.COLUMN_YARD_ID,
            DatabaseOpenHelper.COLUMN_USER_ID,
            DatabaseOpenHelper.COLUMN_COLONY_ID,
            DatabaseOpenHelper.COLUMN_QUEEN_STATUS_ID,
            DatabaseOpenHelper.COLUMN_QUEEN_ID,
            DatabaseOpenHelper.COLUMN_DATE_TIME_START,
            DatabaseOpenHelper.COLUMN_DATE_TIME_CLOSE,
            DatabaseOpenHelper.COLUMN_QTY_DEEP,
            DatabaseOpenHelper.COLUMN_QTY_SUPER,
    };

    public VisitDataSource(MainDataSource home) {
        this.home = home;
    }






}

