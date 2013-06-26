package meetservice;

import java.util.ArrayList;
import java.util.Iterator;

import session.UserGlobal;

import business.Service;

import com.example.meetservice2.R;

import dao.ServiceDAO;

import android.R.integer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;

public class SearchResultActivity extends Activity {

	private String search[];
	private String options1[];
	private String options2[];
	private Spinner sp1;
	private Spinner sp2;
	private ListView resultlist;
	private ServiceDAO servdao;
	private ArrayList<Service> servicess;
	private ProgressDialog pDialog;
	private String listitems[];
	private int searchtype; // 0. highqualify - 1. numgets

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_result);

		AsyncLoadList async = new AsyncLoadList(this);
		async.execute("?");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_result, menu);
		return true;
	}

	class AsyncLoadList extends AsyncTask<String, String, String> {

		Context mcontext;
		boolean available;

		public AsyncLoadList(Context context) {

			mcontext = context;

		}

		protected void onPreExecute() {

			servdao = new ServiceDAO();
			servicess = new ArrayList<Service>();

			options1 = new String[2];
			options2 = new String[2];

			options1[0] = "High Qualify";
			options1[1] = "Num Gets";
			options2[0] = "All";
			options2[1] = "Available";

			// receive arguments
			Bundle bundle = getIntent().getExtras();
			search = bundle.getStringArray("searcharg");

			searchtype = Integer.parseInt(search[4]);

			if (Integer.parseInt(search[3]) == 1) {
				available = true;
			} else {
				available = false;
			}

			// define components
			resultlist = (ListView) findViewById(R.id.listViewSearchResultlistservice);
			sp1 = (Spinner) findViewById(R.id.spinnerSearchResultqualify);
			sp2 = (Spinner) findViewById(R.id.spinnerSearchResultavailability);

			// Spinner City Define

			ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(
					mcontext, android.R.layout.simple_spinner_item, options1);
			dataAdapter
					.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

			sp1.setAdapter(dataAdapter);

			// Spinner Category Define

			ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(
					mcontext, android.R.layout.simple_spinner_item, options2);
			dataAdapter2
					.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

			sp2.setAdapter(dataAdapter2);

			// select options

			sp1.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> parentview,
						View view, int position, long id) {

					/*
					 * search[4]= position + ""; Intent intent=new
					 * Intent(SearchResultActivity
					 * .this,SearchResultActivity.class);
					 * intent.putExtra("searcharg", search);
					 * startActivity(intent);
					 */

				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) { //

				}

			});

			sp2.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> parentview,
						View view, int position, long id) {

					/*
					 * search[3]= position + ""; Intent intent=new
					 * Intent(SearchResultActivity
					 * .this,SearchResultActivity.class);
					 * intent.putExtra("searcharg", search);
					 * startActivity(intent);
					 */

				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) { //

				}

			});

			pDialog = new ProgressDialog(SearchResultActivity.this);
			pDialog.setMessage("loading...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();

		}

		@Override
		protected String doInBackground(String... params) {

			// query on DB
			switch (searchtype) {
			case 0: {
				servicess = servdao.queryServiceAllByQualify(search[2],
						search[0], search[1], available);
				break;
			}
			case 1: {
				servicess = servdao.queryServiceAllByGets(search[2], search[0],
						search[1], available);
				break;
			}
			default: {
				servicess = servdao.queryServiceAllByQualify(search[2],
						search[0], search[1], available);
				break;
			}

			}

			return "ok";
		}

		protected void onPostExecute(String result) {

			if (servicess!= null) {
				listitems = new String[servicess.size()];

				int i = 0;
				for (Iterator<Service> iterator = servicess.iterator(); iterator
						.hasNext();) {
					Service service = (Service) iterator.next();
					listitems[i] = service.getName();

					i++;
				}

				resultlist.setAdapter(new ArrayAdapter<String>(mcontext,
						android.R.layout.simple_list_item_1, listitems));

				resultlist.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {

							
								UserGlobal.serviceactual = servicess.get(position);
								Intent intent = new Intent(
										SearchResultActivity.this,
										ServicePickedActivity.class);
								startActivity(intent);

							

					}

				});
			}
			pDialog.dismiss();

		}

	}

}
