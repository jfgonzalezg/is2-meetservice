package meetservice;

import java.util.ArrayList;
import java.util.Iterator;

import session.UserGlobal;
import business.Service;

import com.example.meetservice2.R;
import com.example.meetservice2.R.layout;
import com.example.meetservice2.R.menu;

import dao.ServiceDAO;
import dao.UserServiceDAO;

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

public class CurrentServicesActivity extends Activity {
	
	
	private ListView listview;
	private String[] opciones/* ={"hola","fuuuu"} */;
	private UserServiceDAO servdao;
	private ArrayList<Service> servicess;
	private ProgressDialog pDialog;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_current_services);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.last_list, menu);
		return true;
	}
	
	class AsyncLoadOptions extends AsyncTask<String, String, String> {

		Context mcontext;

		public AsyncLoadOptions(Context context) {

			mcontext = context;

		}

		protected void onPreExecute() {

			servdao = new UserServiceDAO();
			servicess = new ArrayList<Service>();
			listview = (ListView) findViewById(R.id.listCurrentServiceslist);
			

			pDialog = new ProgressDialog(CurrentServicesActivity.this);
			pDialog.setMessage("loading...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();

		}

		@Override
		protected String doInBackground(String... params) {
			servicess = servdao.queryServicesGotByUser(UserGlobal.usersession.getUser());

			return "ok";
		}

		protected void onPostExecute(String result) {
			if (servicess != null) {

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
								Intent intent = new Intent(CurrentServicesActivity.this,
										ServiceOption.class);
								startActivity(intent);

							}

						}

					}

				});

				

			}
			
			pDialog.dismiss();

		}

	}

}
