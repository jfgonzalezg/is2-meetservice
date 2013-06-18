package com.example.meetservice2;

import java.util.ArrayList;
import java.util.Iterator;

import com.example.DAO.ServiceDAO;
import com.example.negocio.Service;
import com.example.session.UserGlobal;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class OfferService extends Activity {
	private Button newservice;
	private ListView listview;
	private String[] opciones/* ={"hola","fuuuu"} */;
	private ServiceDAO servdao;
	private ArrayList<Service> servicess;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		servdao = new ServiceDAO();
		asignarOpciones();
		setContentView(R.layout.activity_offer_service);

		newservice = (Button) findViewById(R.id.buttonOfferNewService);
		listview = (ListView) findViewById(R.id.listViewOfferServicelist);

		listview.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, opciones));

		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				for (Iterator iterator = servicess.iterator(); iterator
						.hasNext();) {

					Service service = (Service) iterator.next();

					if (opciones[position].equals(service.getName())) {
						UserGlobal.serviceactual = service;
						Intent intent = new Intent(OfferService.this,
								ServiceSelectedActivity.class);
						startActivity(intent);

					}

				}

			}

		});

		newservice.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent intent = new Intent(OfferService.this,
						NewServiceOffer.class);
				startActivity(intent);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.offer, menu);
		return true;
	}

	private void asignarOpciones() {
		servicess = new ArrayList<Service>();

		servicess = servdao.queryServiceThis();
		opciones = new String[servicess.size()];

		int i = 0;
		for (Iterator iterator = servicess.iterator(); iterator.hasNext();) {
			Service service = (Service) iterator.next();
			opciones[i] = service.getName();

			i++;
		}

	}

}
