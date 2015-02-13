package searchffp.compmovil.udea.edu.co.seefoodapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends ActionBarActivity {

	private GoogleMap googleMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maps);
		int position = -1;
		String name="";
		Bundle bundle = this.getIntent().getExtras();
		if (bundle != null) {
			position = bundle.getInt("position");
			name = bundle.getString("name");

		}
		try {
			// Loading map
			initilizeMap(position,name );

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * funcion de onClick para  el tipo de mapa
	 * 
	 * @param view
	 */

	
	public void setType(View view) {
		Button btn= (Button)findViewById(R.id.buttonHybrid);
		if (btn.getText().equals("Hibrido")){
			googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			btn.setText("Tierra");
		}else if (btn.getText().equals("Tierra")){
			googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
			btn.setText("Hibrido");
		}
		
	}

	

	/**
	 * function to load map. If map is not created it will create it for you
	 * */
	private void initilizeMap(int position, String name) {

		if (googleMap == null) {
			googleMap = ((MapFragment) getFragmentManager().findFragmentById(
					R.id.map)).getMap();

			// check if map is created successfully or not
			if (googleMap == null) {
				Toast.makeText(getApplicationContext(),
						"Sorry! unable to create maps", Toast.LENGTH_SHORT)
						.show();
			} else {
				googleMap.setMyLocationEnabled(true);
				googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
				googleMap.getUiSettings().setMyLocationButtonEnabled(true);
				googleMap.getUiSettings().setCompassEnabled(true);

				switch (position) {
				case 0:
					setPosition(6.268539533, -75.568485260, Float.parseFloat("300.0"),name);
					setPosition(6.265729380, -75.569230914, Float.parseFloat("300.0"),name);
					break;
				case 1:
					setPosition(6.268091616, -75.567455292, Float.parseFloat("300.0"),name);
					setPosition(6.266363932, -75.567938090, Float.parseFloat("300.0"),name);
					setPosition(6.268091616, -75.568270684, Float.parseFloat("300.0"),name);
					setPosition(6.266747862, -75.570330620, Float.parseFloat("300.0"),name);
					setPosition(6.267856993, -75.569418669, Float.parseFloat("300.0"),name);
					break;
				case 2:
					setPosition(6.268656845, -75.568517447, Float.parseFloat("300.0"),name);
					setPosition(6.268048957, -75.570137501, Float.parseFloat("300.0"),name);
					setPosition(6.266321273, -75.569536686, Float.parseFloat("300.0"),name);
					setPosition(6.266033325, -75.569214821, Float.parseFloat("300.0"),name);			
					break;
				case 3:
					setPosition(6.268038293, -75.568289459, Float.parseFloat("300.0"),name);
					setPosition(6.266559452, -75.570420027, Float.parseFloat("300.0"),name);
					setPosition(6.266042213, -75.569540262, Float.parseFloat("300.0"),name);
					break;
				case 4:
					setPosition(6.266033325, -75.569214821, Float.parseFloat("300.0"),name);
					setPosition(6.268582192, -75.568463803, Float.parseFloat("300.0"),name);
					break;
				case 5:
					setPosition(6.266474134, -75.569497347, Float.parseFloat("300.0"),name);
					setPosition(6.266170189, -75.569561720, Float.parseFloat("300.0"),name);
					setPosition(6.267849883, -75.569502712, Float.parseFloat("300.0"),name);
					setPosition(6.268358233, -75.568777621, Float.parseFloat("300.0"),name);
					break;
				default:
					break;
				}

			}
		}
	}

	public void setPosition(double latitude, double longitude, float color, String title) {
		CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(latitude, longitude)).zoom(16).build();

		googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
		MarkerOptions marker = new MarkerOptions().position(new LatLng(latitude, longitude)).title(title);
		marker.icon(BitmapDescriptorFactory.defaultMarker(color));
		// adding marker
		googleMap.addMarker(marker);
	}

	@Override
	protected void onResume() {
		super.onResume();
		initilizeMap(-1,"");
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
