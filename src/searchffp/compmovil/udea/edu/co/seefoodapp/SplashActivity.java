package searchffp.compmovil.udea.edu.co.seefoodapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {
	 
    // Duración en milisegundos que se mostrará el splash
    private final int DURACION_SPLASH = 3000; // 3 segundos
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        // Tenemos una plantilla llamada splash.xml donde mostraremos la información que queramos (logotipo, etc.)
        setContentView(R.layout.splash);
 
        new Handler().postDelayed(new Runnable(){
            public void run(){
		// Cuando pasen los 3 segundos, pasamos a la actividad principal de la aplicación
        	Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        	startActivity(intent);
        	finish();
            };
        }, DURACION_SPLASH);
    }
}