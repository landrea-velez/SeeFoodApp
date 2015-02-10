package searchffp.compmovil.udea.edu.co.seefoodapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PlacesActivity extends Activity {
	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_places);

		listView = (ListView) findViewById(R.id.placesList);
		String[] values = new String[] { "CC Premium Plaza",
				"CC Puerta del Norte", "Universidad de Antioquia",
				"Terminal de Transportes Norte", "Estación Envigado",
				"Éxito San Antonio", "Biblioteca España", };

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, values);

		// Set the adapter needed in ListView
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view,
					int position, long id) {
				// ListView Clicked item index
				throwActivity(position, (String)listView.getItemAtPosition(position));

			}

		});

	}

	public void throwActivity(int position, String name) {
		Bundle bundle = new Bundle();
		bundle.putInt("position", position);
		bundle.putString("name", name);
		Intent intent = new Intent();
		intent.setClass(this, MapsActivity.class);
		intent.putExtras(bundle);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.places, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
