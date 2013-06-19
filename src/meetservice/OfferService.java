package meetservice;

import java.util.ArrayList;
import java.util.Iterator;

import com.example.meetservice2.R;

import session.UserGlobal;

import business.Service;

import dao.ServiceDAO;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class OfferService extends Activity {
	private Button newservice;
	private ListView listview;
	private String[] opciones/* ={"hola","fuuuu"} */;
	private ServiceDAO servdao;
	private ArrayList<Service> servicess;
	private ProgressDialog pDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_offer_service);

		
		AsyncLoadOptions async = new AsyncLoadOptions(this);
		async.execute("?");
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.offer, menu);
		return true;
	}

	class AsyncLoadOptions extends AsyncTask<String, String, String> {

		Context mcontext;

		public AsyncLoadOptions(Context context) {

			mcontext = context;

		}

		protected void onPreExecute() {

			servdao = new ServiceDAO();
			servicess = new ArrayList<Service>();
			listview = (ListView) findViewById(R.id.listViewOfferServicelist);
			newservice = (Button) findViewById(R.id.buttonOfferNewService);

			pDialog = new ProgressDialog(OfferService.this);
			pDialog.setMessage("loading...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();

		}

		@Override
		protected String doInBackground(String... params) {
			servicess = servdao.queryServiceThis();
			
			return "ok";
		}

		protected void onPostExecute(String result) {

			opciones = new String[servicess.size()];

			
			int i = 0;
			for (Iterator<Service> iterator = servicess.iterator(); iterator
					.hasNext();) {
				Service service = (Service) iterator.next();
				opciones[i] = service.getName();

				i++;
			}

			

			listview.setAdapter(new ArrayAdapter<String>(mcontext,
					android.R.layout.simple_list_item_1, opciones));

			listview.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {

					for (Iterator<Service> iterator = servicess.iterator(); iterator
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

			pDialog.dismiss();

		}

	}

}
