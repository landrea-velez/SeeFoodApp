package searchffp.compmovil.udea.edu.co.seefoodapp;

import java.util.ArrayList;
import java.util.StringTokenizer;

import searchffp.compmovil.udea.edu.co.beans.Comentario;
import searchffp.compmovil.udea.edu.co.beans.Local;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ComentariosLocal extends ActionBarActivity implements OnClickListener{

Button btn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_comentarios_local);

		String name="";
		Bundle bundle = this.getIntent().getExtras();
		if (bundle != null) {
			name = bundle.getString("name");
		}
		
		TextView txtnom = (TextView) findViewById(R.id.textView_tipoLocal);
		txtnom.setText(name);
		
		String entrada = getNomLocal(name);
		Log.e("LogsAndroid", "" + entrada);
		
		
		
		
		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		
		try {
			
			
			DbHelper dbMy =  new DbHelper(this, null, null, DataBaseManager.DB_SCHEMA_VERSION);
			
			SQLiteDatabase db = dbMy.getReadableDatabase();
			Cursor rs = db.rawQuery("select * from " + DataBaseManager.TABLE_NAME_COMENTARIO + " where "+DataBaseManager.CN_NAME +" = '"+entrada+"' " , null);
			Log.e("try LogsAndroid", ""+entrada.length());
			Comentario objComentario;
			while (rs.moveToNext()) {
				objComentario = new Comentario();
				objComentario.setCN_ID(rs.getString(0));
				objComentario.setCN_PUNTOS(rs.getString(1));
				objComentario.setCN_COMENTARIO(rs.getString(2));				
				comentarios.add(objComentario);				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}		
		
		ListView lv = (ListView)findViewById(R.id.lstComentario);		
		ArrayAdapter<Comentario> adaptador = new ArrayAdapter<Comentario>(this, android.R.layout.simple_list_item_1,comentarios);		
		lv.setAdapter(adaptador);
		
		 	        
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
	            startActivity(new Intent(this, ConsultaLocales.class));
	            return true;	            
	        default:
	            return false;
			}
		}
	
		@Override
		public void onClick(View v) {
					
		}
		
		public String getNomLocal(String entrada){
			String local="";
			
			StringTokenizer st = new StringTokenizer(entrada, ":");
			   while(st.hasMoreTokens()) {
			   String tipo = st.nextToken();
			   local = st.nextToken();	
			   }			
			return local;
		}
	

}
