package searchffp.compmovil.udea.edu.co.seefoodapp;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class MyPlaces extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_places);
        final String TAG = MyPlaces.class.getSimpleName();

        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        try {
            values.clear();
            values.put(DataBaseManager.CN_ADDRESS, DataBaseManager.DATA_ADDRESS);
            values.put(DataBaseManager.CN_LONGITUDE, DataBaseManager.DATA_LONGITUDE);
            values.put(DataBaseManager.CN_LATITUDE, DataBaseManager.DATA_LATITUDE);
            values.put(DataBaseManager.CN_NAME, DataBaseManager.DATA_NAME);
            values.put(DataBaseManager.CN_ID, DataBaseManager.DATA_ID);
            Log.d(TAG, " " + values);

            Uri uri = getContentResolver().insert(DataBaseManager.CONTENT_URI, values);


            // Get content provider and cursor
            ContentResolver cr = getContentResolver();
            Cursor cursor = cr.query(DataBaseManager.CONTENT_URI, null,null, null, null);
            Log.d(TAG, "cursor " + cursor );
            // Let activity manage the cursor
           // startManagingCursor(cursor);
            //Log.d(TAG, "cursor.getCount" + cursor.getCount());            

            String[] from = { DataBaseManager.CN_NAME, DataBaseManager.CN_ADDRESS };
            int[] to = { R.id.textName, R.id.textValue };

            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.row, cursor, from, to,0);
            Log.d(TAG, "adapter " + adapter );
                                
         // Get the list view
            ListView listView = (ListView) findViewById(R.id.listView);
            listView.setAdapter(adapter);


            /*String[] from = { Settings.System.NAME, Settings.System.VALUE};
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.row, cursor, from, to);
            listView.setAdapter(adapter);*/

        } catch (Exception e) {
            Log.e("exception: ", "Failed", e);
            e.printStackTrace();
        }
   }

    public void mostrarMap(View view) {

        Intent intent = new Intent(this, MapActivity.class );
        startActivity(intent);

    }
}


