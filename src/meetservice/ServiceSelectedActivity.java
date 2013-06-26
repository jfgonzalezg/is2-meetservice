package meetservice;

import java.util.ArrayList;

import com.example.meetservice2.R;

import business.Service;

import dao.ServiceDAO;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ServiceSelectedActivity extends Activity {

	private ListView listview;
	private String[] opciones;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service_selected);
		opciones = new String[4];

		opciones[0] = "Ver Peticiones";
		opciones[1] = "Habilitar/Deshabilitar";
		opciones[2] = "Ver Calificaciones";
		opciones[3] = "Ver Estadisticas";
		listview = (ListView) findViewById(R.id.listViewServiceSelectedlist);

		listview.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, opciones));
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				switch (position) {
				case 0: {
					Intent intent = new Intent(ServiceSelectedActivity.this,
							ViewRequestServiceActivity.class);
					startActivity(intent);
					break;
				}
				case 1: {

					break;
				}
				case 2: {

					break;
				}
				case 3: {

					break;
				}

				}

			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.service_selected, menu);
		return true;
	}

}
