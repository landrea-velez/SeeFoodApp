package searchffp.compmovil.udea.edu.co.seefoodapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
	 * funcion de onClick para poner el mapa de tipo normal
	 * 
	 * @param view
	 */
	public void setNormalType(View view) {

		googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
	}

	/**
	 * funcion de onClick para poner el mapa de tipo Híbrido
	 * 
	 * @param view
	 */
	public void setHybridType(View view) {
		googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

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
				googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
				googleMap.getUiSettings().setMyLocationButtonEnabled(true);
				googleMap.getUiSettings().setCompassEnabled(true);

				switch (position) {
				case 0:
					setPosition(6.268082729, -75.568285882, Float.parseFloat("300.0"),name);
					break;
				case 1:
					setPosition(6.268301355, -75.568414629, Float.parseFloat("300.0"),name);
					break;
				case 2:
					setPosition(6.266451027, -75.569525063, Float.parseFloat("300.0"),name);
					break;
				case 3:
					setPosition(6.279059, -75.571128, Float.parseFloat("300.0"),name);
					break;
				case 4:
					setPosition(6.174158, -75.597024, Float.parseFloat("300.0"),name);
					break;
				case 5:
					setPosition(6.246773, -75.567612, Float.parseFloat("300.0"),name);
					break;
				default:
					break;
				}

			}
		}
	}

	public void setPosition(double latitude, double longitude, float color, String title) {
		CameraPosition cameraPosition = new CameraPosition.Builder()
				.target(new LatLng(latitude, longitude)).zoom(16).build();

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
