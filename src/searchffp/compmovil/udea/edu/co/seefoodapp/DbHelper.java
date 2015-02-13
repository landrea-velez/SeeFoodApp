package searchffp.compmovil.udea.edu.co.seefoodapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {
    private static final String TAG = DbHelper.class.getSimpleName();

    public DbHelper(Context context, String name, String cursorFactory, int version) {
        super(context, DataBaseManager.DB_NAME, null, DataBaseManager.DB_SCHEMA_VERSION);
    }
    

    @Override
    public void onCreate(SQLiteDatabase db) {
    	
        db.execSQL(DataBaseManager.CREATE_TABLE_LOCAL);  
        Log.d(TAG, "onCreate with SQL: " + DataBaseManager.CREATE_TABLE_LOCAL);
        
       
        
        db.execSQL("INSERT INTO " +DataBaseManager.TABLE_NAME_LOCAL+ " ("+DataBaseManager.CN_ID+", "+DataBaseManager.CN_TYPE+", "+DataBaseManager.CN_NAME+", "+DataBaseManager.CN_LATITUDE+", "+DataBaseManager.CN_LONGITUDE+", "+DataBaseManager.CN_ADDRESS+") "
        		+ "VALUES ('"+DataBaseManager.DATA_ID+"', '"+DataBaseManager.DATA_TYPE+"', '"+DataBaseManager.DATA_NAME+"', '"+DataBaseManager.DATA_LATITUDE+"', '"+DataBaseManager.DATA_LONGITUDE+"', '"+DataBaseManager.DATA_ADDRESS+"');");
        
        db.execSQL("INSERT INTO " +DataBaseManager.TABLE_NAME_LOCAL+ " ("+DataBaseManager.CN_ID+", "+DataBaseManager.CN_TYPE+", "+DataBaseManager.CN_NAME+", "+DataBaseManager.CN_LATITUDE+", "+DataBaseManager.CN_LONGITUDE+", "+DataBaseManager.CN_ADDRESS+") "
        		+ "VALUES ('"+DataBaseManager.DATA_ID1+"', '"+DataBaseManager.DATA_TYPE1+"', '"+DataBaseManager.DATA_NAME1+"', '"+DataBaseManager.DATA_LATITUDE1+"', '"+DataBaseManager.DATA_LONGITUDE1+"', '"+DataBaseManager.DATA_ADDRESS1+"');");
       
        db.execSQL("INSERT INTO " +DataBaseManager.TABLE_NAME_LOCAL+ " ("+DataBaseManager.CN_ID+", "+DataBaseManager.CN_TYPE+", "+DataBaseManager.CN_NAME+", "+DataBaseManager.CN_LATITUDE+", "+DataBaseManager.CN_LONGITUDE+", "+DataBaseManager.CN_ADDRESS+") "
        		+ "VALUES ('"+DataBaseManager.DATA_ID2+"', '"+DataBaseManager.DATA_TYPE2+"', '"+DataBaseManager.DATA_NAME2+"', '"+DataBaseManager.DATA_LATITUDE2+"', '"+DataBaseManager.DATA_LONGITUDE2+"', '"+DataBaseManager.DATA_ADDRESS2+"');");
        
        
        db.execSQL(DataBaseManager.CREATE_TABLE_COMENTARIO);  
        Log.d(TAG, "onCreate with SQL: " + DataBaseManager.CREATE_TABLE_COMENTARIO);
        
        db.execSQL("INSERT INTO " +DataBaseManager.TABLE_NAME_COMENTARIO+ " ("+DataBaseManager.CN_NAME+", "+DataBaseManager.CN_PUNTOS+", "+DataBaseManager.CN_COMENTARIO+") "
        		+ "VALUES ('"+DataBaseManager.DATA_NAME_COMENT1+"', '"+DataBaseManager.DATA_PUNTOS1+"', '"+DataBaseManager.DATA_COMENT1+"');");
        
        db.execSQL("INSERT INTO " +DataBaseManager.TABLE_NAME_COMENTARIO+ " ("+DataBaseManager.CN_NAME+", "+DataBaseManager.CN_PUNTOS+", "+DataBaseManager.CN_COMENTARIO+") "
        		+ "VALUES ('"+DataBaseManager.DATA_NAME_COMENT2+"', '"+DataBaseManager.DATA_PUNTOS2+"', '"+DataBaseManager.DATA_COMENT2+"');");
        
        db.execSQL("INSERT INTO " +DataBaseManager.TABLE_NAME_COMENTARIO+ " ("+DataBaseManager.CN_NAME+", "+DataBaseManager.CN_PUNTOS+", "+DataBaseManager.CN_COMENTARIO+") "
        		+ "VALUES ('"+DataBaseManager.DATA_NAME_COMENT3+"', '"+DataBaseManager.DATA_PUNTOS1+"', '"+DataBaseManager.DATA_COMENT1+"');");
        
        db.execSQL("INSERT INTO " +DataBaseManager.TABLE_NAME_COMENTARIO+ " ("+DataBaseManager.CN_NAME+", "+DataBaseManager.CN_PUNTOS+", "+DataBaseManager.CN_COMENTARIO+") "
        		+ "VALUES ('"+DataBaseManager.DATA_NAME_COMENT4+"', '"+DataBaseManager.DATA_PUNTOS4+"', '"+DataBaseManager.DATA_COMENT4+"');");
        
        db.execSQL("INSERT INTO " +DataBaseManager.TABLE_NAME_COMENTARIO+ " ("+DataBaseManager.CN_NAME+", "+DataBaseManager.CN_PUNTOS+", "+DataBaseManager.CN_COMENTARIO+") "
        		+ "VALUES ('"+DataBaseManager.DATA_NAME_COMENT5+"', '"+DataBaseManager.DATA_PUNTOS5+"', '"+DataBaseManager.DATA_COMENT5+"');");
       
    }

        @Override
	    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {        	
	        	Log.d(TAG, "Upgrading database. Existing contents will be lost. ["
	                    + oldVersion + "]->[" + newVersion + "]");
	            db.execSQL("DROP TABLE IF EXISTS " + DataBaseManager.TABLE_NAME_LOCAL);
	            onCreate(db);
	    }
}
