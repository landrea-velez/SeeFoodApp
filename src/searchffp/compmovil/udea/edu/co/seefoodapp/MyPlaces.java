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
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class MyPlaces extends ActionBarActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	 final String TAG = MyPlaces.class.getSimpleName();    	 
    	 super.onCreate(savedInstanceState);       
    	 setContentView(R.layout.my_places);        
            	 

        try {         	         
            
        	String[] from = { Settings.System.NAME, Settings.System.VALUE };
            //String[] from = { DataBaseManager.CN_NAME, DataBaseManager.CN_TYPE };
            int[] to = { R.id.textName, R.id.textValue };

            // Get content provider and cursor
            ContentResolver cr = getContentResolver();
            Cursor cursor = cr.query(Settings.System.CONTENT_URI, null,null, null, null);
            //Cursor cursor = cr.query(DataBaseManager.CONTENT_URI, null,null, null, null);
            
         // Let activity manage the cursor
            startManagingCursor(cursor);

            // Get the list view
            ListView listView = (ListView) findViewById(R.id.listView);
                       

            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.row, cursor, from, to);
           

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
    
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about, menu);
        return super.onCreateOptionsMenu(menu);
    }
 
  public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_ayuda:
                startActivity(new Intent(this, MainActivity.class));
                return true;	            
            default:
                return false;
        }
    }
}


