package searchffp.compmovil.udea.edu.co.seefoodapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ListActivity;
import android.database.MatrixCursor;
import android.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends ListActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Simulamos que extraemos los datos de la base de datos a un cursor
        String[] columnasBD = new String[] {"_id", "imagen", "textoSuperior", "textoInferior"};
        MatrixCursor cursor = new MatrixCursor(columnasBD);
        cursor.addRow(new Object[] {"0", R.drawable.watermelon3, "FRUTAS", "Jugos y ensalada de frutas"});
        cursor.addRow(new Object[] {"1", R.drawable.christmas230, "BURBUJAS", "Dulces"});
        cursor.addRow(new Object[] {"2", R.drawable.burger9, "COMIDA R�PIDA", "Hamburguesas, patacones, pollo"});
        cursor.addRow(new Object[] {"3", R.drawable.snacks1, "CAFETER�AS", "Aperitivos y platos combinados"});
        cursor.addRow(new Object[] {"4", R.drawable.ice63, "HELADOS", "Helados, malteadas, salpic�n"});
        cursor.addRow(new Object[] {"5", R.drawable.plate9, "RESTAURANTES", "Almuerzos"});

        //Añadimos los datos al Adapter y le indicamos donde dibujar cada dato en la fila del Layout
        String[] desdeEstasColumnas = {"imagen", "textoSuperior", "textoInferior"};
        int[] aEstasViews = {R.id.imageView_imagen, R.id.textView_superior, R.id.textView_inferior};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.activity_main, cursor, desdeEstasColumnas, aEstasViews, 0);

        ListView listado = getListView();
        listado.setAdapter(adapter);
        
        listado.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
				// ListView Clicked item index
				TextView textoTitulo = (TextView) view.findViewById(R.id.textView_superior);
		        String texto = " " + textoTitulo.getText();
				throwActivity(position, texto);

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
// Inflate the menu items to the action bar.
        getMenuInflater().inflate(R.menu.main, menu);
        return true; //
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_places:
                startActivity(new Intent(this, ConsultaLocales.class));
                return true;                          
            case R.id.action_about:
                startActivity(new Intent(this,AboutActivity.class));
                return true;                
            default:
                return false;
        }
    }

}
