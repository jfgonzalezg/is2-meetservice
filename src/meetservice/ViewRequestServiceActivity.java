package meetservice;

import java.util.ArrayList;
import java.util.Iterator;

import session.UserGlobal;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import business.Service;
import business.UserService;

import com.example.meetservice2.R;

import dao.UserServiceDAO;

public class ViewRequestServiceActivity extends Activity {
	private ListView listview;
	private String[] opciones/* ={"hola","fuuuu"} */;
	private UserServiceDAO uservdao;
	private ArrayList<Service> servicess;
	private ProgressDialog pDialog;
	private ArrayList<UserService> userservicess;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_request_service);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_request, menu);
		return true;
	}

	class AsyncLoadOptions extends AsyncTask<String, String, String> {

		Context mcontext;

		public AsyncLoadOptions(Context context) {

			mcontext = context;

		}

		protected void onPreExecute() {

			uservdao = new UserServiceDAO();
			servicess = new ArrayList<Service>();
			userservicess = new ArrayList<UserService>();
			listview = (ListView) findViewById(R.id.listRequestService);

			pDialog = new ProgressDialog(ViewRequestServiceActivity.this);
			pDialog.setMessage("loading...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();

		}

		@Override
		protected String doInBackground(String... params) {
			servicess = uservdao
					.queryServicesGotByCodSer(UserGlobal.serviceactual.getCod());
			userservicess = uservdao
					.queryUserServicesByCodSer(UserGlobal.serviceactual
							.getCod());

			return "ok";
		}

		protected void onPostExecute(String result) {
			if (userservicess != null) {

				opciones = new String[userservicess.size()];

				int i = 0;
				for (Iterator<UserService> iterator = userservicess.iterator(); iterator
						.hasNext();) {
					UserService uservice = (UserService) iterator.next();
					opciones[i] = uservice.getUsername() + " : "
							+ uservice.getCod();

					i++;
				}

				listview.setAdapter(new ArrayAdapter<String>(mcontext,
						android.R.layout.simple_list_item_1, opciones));

				listview.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						
						UserGlobal.userviceactual=userservicess.get(position);
						
						Intent intent = new Intent(
								ViewRequestServiceActivity.this,
								RequestResponseActivity.class);
						intent.putExtra("servicecode",
								userservicess.get(position).getServicecode()
										+ "");
						intent.putExtra("userservicecod",
								userservicess.get(position).getCod() + "");
						startActivity(intent);

					}

				});

			}

			pDialog.dismiss();

		}

	}

}
