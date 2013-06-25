package meetservice;

import java.util.ArrayList;
import java.util.Iterator;

import session.UserGlobal;
import business.Service;
import business.UserService;

import com.example.meetservice2.R;
import com.example.meetservice2.R.layout;
import com.example.meetservice2.R.menu;

import dao.ServiceDAO;
import dao.UserServiceDAO;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.app.Dialog;
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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;

public class TakeServiceActivity extends Activity {
	private TextView title;
	private TextView description;
	private Button bsi;
	private Button bno;
	private Service servicepicked;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_take_service);

		bsi = (Button) findViewById(R.id.button1TakeServiceConfirmSI);
		bno = (Button) findViewById(R.id.button1TakeServiceconfirmNO);

		title = (TextView) findViewById(R.id.textViewTakeServicetitle);
		description = (TextView) findViewById(R.id.textView2TakeServicedescript);

		servicepicked = UserGlobal.serviceactual;

		description.setText(servicepicked.getDescription());
		title.setText(servicepicked.getName());

		bsi.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				
				new AsyncSendYes(TakeServiceActivity.this).execute("?");
				
			}
		});
		
		bno.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				finish();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.take, menu);
		return true;
	}

	class AsyncSendYes extends AsyncTask<String, String, String> {

		Context mcontext;
		private ProgressDialog pDialog;
		private UserServiceDAO uservicedao;
		private int resp;

		public AsyncSendYes(Context context) {

			mcontext = context;

		}

		protected void onPreExecute() {

			uservicedao = new UserServiceDAO();

			pDialog = new ProgressDialog(TakeServiceActivity.this);
			pDialog.setMessage("loading...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();

		}

		@Override
		protected String doInBackground(String... params) {

			if (uservicedao
					.insertUserService(UserGlobal.serviceactual.getCod()) == 1) {

				resp = 1;

			} else {

				resp=0;
			}
			return "ok";
		}

		protected void onPostExecute(String result) {
			pDialog.dismiss();

			if (resp == 1) {
				correctReg();

			} else {

				errorReg();
				SystemClock.sleep(2000);
				finish();
			}

		}

		public void errorReg() {

			Toast toast = Toast.makeText(getApplicationContext(),
					"Peticion Erronea...Intente de nuevo", Toast.LENGTH_LONG);
			toast.show();

		}

		public void correctReg() {

			Toast toast = Toast.makeText(getApplicationContext(),
					"Peticion enviada correctamente", Toast.LENGTH_LONG);
			toast.show();

			SystemClock.sleep(2000);
			finish();

		}

	}

}
