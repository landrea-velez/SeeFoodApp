package searchffp.compmovil.udea.edu.co.seefoodapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class AboutActivity extends ActionBarActivity{
	 @Override
	    public void onCreate(Bundle savedInstanceState) {	    	 
	    	 super.onCreate(savedInstanceState);       
	    	 setContentView(R.layout.about_layout);	    	 
	    	 ActionBar actionBar = getSupportActionBar();
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
