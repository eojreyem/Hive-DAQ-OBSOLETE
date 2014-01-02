package com.centerorbit.hive_daq.model;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class MainDataSource {
	private DatabaseOpenHelper databaseOpener;
	protected SQLiteDatabase database;
	private Context appContext;

    //Somewhat Table specific datasources.
    private ColonyDataSource colony;
	
	public MainDataSource(Context context) {
		this.appContext = context;
		databaseOpener = new DatabaseOpenHelper(appContext);
	}



    public ColonyDataSource Colony(){
        return colony;
    }

    protected void notice(String message, int ToastMessageDuration){
        Toast.makeText(appContext, message, ToastMessageDuration).show();
    }

	 public void open() throws SQLException {
		 database = databaseOpener.getWritableDatabase();

         /*So here we are moving any Colony specific functions
         to it's own class. in this way, we can better organize the functions
         since no doubt there will be many.
          */
         colony = new ColonyDataSource(this);

	  }
	 
	 public void close() {
		 databaseOpener.close();
	  }

}
