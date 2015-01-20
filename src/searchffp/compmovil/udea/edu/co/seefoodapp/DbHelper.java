package searchffp.compmovil.udea.edu.co.seefoodapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {
    private static final String TAG = DbHelper.class.getSimpleName();

    public DbHelper(Context context) {
        super(context, DataBaseManager.DB_NAME, null, DataBaseManager.DB_SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataBaseManager.DB_SCHEMA);        
        /*db.execSQL("INSERT INTO " +DataBaseManager.TABLE_NAME+ " ("+DataBaseManager.CN_TYPE+", "+DataBaseManager.CN_NAME+") VALUES ('Cafeteria2','COESDUA2')");           
        Log.d(TAG, "onCreate with SQL: " + DataBaseManager.CREATE_TABLE);*/
    }

        @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {        	
        	Log.d(TAG, "Upgrading database. Existing contents will be lost. ["
                    + oldVersion + "]->[" + newVersion + "]");
            db.execSQL("DROP TABLE IF EXISTS " + DataBaseManager.TABLE_NAME);
            onCreate(db);
    }
}
