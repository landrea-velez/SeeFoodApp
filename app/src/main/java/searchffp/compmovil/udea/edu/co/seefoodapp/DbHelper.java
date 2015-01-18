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
        db.execSQL(DataBaseManager.CREATE_TABLE);
        Log.d(TAG, "onCreate with SQL: " + DataBaseManager.CREATE_TABLE);
    }

        @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //db.execSQL("drop table if exists " + StatusContract.TABLE_NAME);
        //onCreate(db);

    }
}
