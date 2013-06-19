package meetservice;


import session.UserGlobal;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import business.Service;

import com.example.meetservice2.R;

import dao.ServiceDAO;

public class NewServiceOffer extends Activity {

	private Button send;
	private ProgressDialog pDialog;
	private Spinner city;
	private Spinner category;
	private ServiceDAO servicedao;
	private Service service;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_service_offer);

		servicedao = new ServiceDAO();
		service = new Service();

		city = (Spinner) findViewById(R.id.spinnerNewServiceOffercity);
		category = (Spinner) findViewById(R.id.spinnerNewServiceOffercate);

		// load cities and categories
		// new AsyncCityandCateg().execute("?");

		// Spinner City Define

		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, UserGlobal.citys);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		city.setAdapter(dataAdapter);

		// Spinner Category Define

		ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, UserGlobal.categorys);
		dataAdapter2
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		category.setAdapter(dataAdapter2);

		// Spinner actions
		city.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parentview, View view,
					int position, long id) {

				service.setCity(UserGlobal.citys[position]);

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}

		});

		category.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parentview, View view,
					int position, long id) {

				service.setCategory(UserGlobal.categorys[position]);

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

		// Send Information
		send = (Button) findViewById(R.id.buttonNEWSERVICEOFFERsend);

		send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				registerNewService(v);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_service_offer, menu);
		return true;
	}

	public void registerNewService(View view) {
		// Do something in response to button

		// guardar datos de editfield en user.
		EditText editText = (EditText) findViewById(R.id.EditTextNEWSERVICEOFFERname);
		String txt = editText.getText().toString();
		service.setName(txt);

		editText = (EditText) findViewById(R.id.EditTextNEWSERVICEOFFERdecr);
		txt = editText.getText().toString();
		service.setDescription(txt);

		editText = (EditText) findViewById(R.id.EditTextNEWSERVICEOFFERtel);
		txt = editText.getText().toString();
		service.setTelephone(txt);

		editText = (EditText) findViewById(R.id.EditTextNEWSERVICEOFFERaddress);
		txt = editText.getText().toString();
		service.setAddress(txt);

		editText = (EditText) findViewById(R.id.editNEWSERVICEOFFERemail);
		txt = editText.getText().toString();
		service.setEmail(txt);

		editText = (EditText) findViewById(R.id.EditTextNEWSERVICEOFFERwebpa);
		txt = editText.getText().toString();
		service.setWebpage(txt);

		// guardar usuario en base de datos
		servicedao.setService(service);

		new AsyncRegister().execute("?");

		finish();
	}

	public void errorReg() {

		Toast toast = Toast.makeText(getApplicationContext(),
				" Register Error...Try Again", Toast.LENGTH_LONG);
		toast.show();

	}

	public void correctReg() {

		Toast toast = Toast.makeText(getApplicationContext(),
				"Service Registered correctly", Toast.LENGTH_LONG);
		toast.show();

	}

	class AsyncRegister extends AsyncTask<String, String, String> {

		protected void onPreExecute() {

			pDialog = new ProgressDialog(NewServiceOffer.this);
			pDialog.setMessage("Registering...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();

		}

		@Override
		protected String doInBackground(String... params) {

			if (servicedao.insertService() == 1) {

				return "ok";

			} else {

				return "err";
			}

		}

		protected void onPostExecute(String result) {
			pDialog.dismiss();

			if (result.equals("ok")) {
				correctReg();

			} else {

				errorReg();

			}

		}

	}

}
