package searchffp.compmovil.udea.edu.co.seefoodapp;

import java.util.ArrayList;

import searchffp.compmovil.udea.edu.co.beans.Local;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ConsultaLocales extends ActionBarActivity implements OnClickListener {
	
	Button btn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_consulta_locales);
		
		ArrayList<Local> locales = new ArrayList<Local>();
		
		try {
			
			DbHelper dbMy =  new DbHelper(this, null, null, DataBaseManager.DB_SCHEMA_VERSION);
			
			SQLiteDatabase db = dbMy.getReadableDatabase();
			Cursor rs = db.rawQuery("select * from " + DataBaseManager.TABLE_NAME_LOCAL, null);
			Local objLocal;
			while (rs.moveToNext()) {
				objLocal = new Local();
				objLocal.setCN_ID(rs.getString(0));
				objLocal.setCN_TYPE(rs.getString(1));
				objLocal.setCN_NAME(rs.getString(2));				
				objLocal.setCN_LATITUDE(rs.getString(3));
				objLocal.setCN_LONGITUD(rs.getString(4));
				objLocal.setCN_ADDRESS(rs.getString(5));
				locales.add(objLocal);				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		final ListView ls = (ListView)findViewById(R.id.lstLocal);		
		ArrayAdapter<Local> adaptador = new ArrayAdapter<Local>(this, android.R.layout.simple_list_item_1,locales);		
		ls.setAdapter(adaptador);
	

		 ls.setOnItemClickListener(new OnItemClickListener() {

	            public void onItemClick(AdapterView<?> customerAdapter, View footer, int selectedInt, long selectedLong) {            
	                
	                String listChoice = (String) (ls.getItemAtPosition(selectedInt).toString());               
	                verComentariosActivity(listChoice);
	            }
	        });
	}
	

		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.menu_about, menu);
	        return super.onCreateOptionsMenu(menu);
		}
	
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// Handle action bar item clicks here. The action bar will
			// automatically handle clicks on the Home/Up button, so long
			// as you specify a parent activity in AndroidManifest.xml.
			switch (item.getItemId()) {
	        case R.id.menu_ayuda:
	            startActivity(new Intent(this, MainActivity.class));
	            return true;	            
	        default:
	            return false;
			}
		}
	
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(this, ComentariosLocal.class );
	        startActivity(intent);
			
		}
		
		public void verComentariosActivity(String name) {					
			
			Intent intent = new Intent();		
			intent.setClass(this, ComentariosLocal.class);
			
			//Create the bundle
            Bundle bundle = new Bundle();

            //Add your data to bundle
            bundle.putString("name",name);
            bundle.putString("PhoneNumber",name);

            //Add the bundle to the intent
            intent.putExtras(bundle);

          //Fire that second activity
             startActivity(intent);
		}

	}
