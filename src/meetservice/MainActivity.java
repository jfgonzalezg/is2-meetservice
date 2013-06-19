package meetservice;

import java.util.ArrayList;
import java.util.Iterator;

import business.Category;
import business.City;

import com.example.meetservice2.R;

import session.UserGlobal;

import dao.CategoryDAO;
import dao.CityDAO;
import dao.UserDAO;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.meetservice2.MESSAGE";

	private TextView labelregister;
	private TextView labelabout;
	private Button loginbut;
	private UserDAO userdao;
	private CategoryDAO categdao;
	private CityDAO citydao;
	private EditText edituser;
	private EditText edipass;
	private ProgressDialog pDialog;
	private ArrayList<Category> categs;
	private ArrayList<City> citys;
	private String[] list;
	private String[] list2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		labelabout = (TextView) findViewById(R.id.textViewMainAbout);
		labelregister = (TextView) findViewById(R.id.textViewMainRegister);
		loginbut = (Button) findViewById(R.id.ButtonMainLogin);
		edituser = (EditText) findViewById(R.id.editTextMainUser);
		edipass = (EditText) findViewById(R.id.editTextMainPassword);

		labelabout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				aboutView(view);
			}
		});

		labelregister.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				newReg(view);
			}
		});

		loginbut.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				// sendLogin(arg0);
				new AsyncLogin().execute("?");

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/*
	 * public void sendLogin(View view) {
	 * 
	 * 
	 * userdao = new UserDAO();
	 * 
	 * // int log = userdao.login(edituser.getText().toString(), //
	 * edipass.getText().toString()); if
	 * (userdao.login(edituser.getText().toString(), edipass.getText()
	 * .toString()) == 1) { Intent intent = new Intent(MainActivity.this,
	 * UserMain.class); startActivity(intent); UserGlobal.usersession =
	 * userdao.queryUser(edituser.getText() .toString(),
	 * edipass.getText().toString());
	 * 
	 * } else { Toast toast = Toast.makeText(getApplicationContext(),
	 * "User or Password incorrect...Try Again", Toast.LENGTH_SHORT);
	 * toast.show();
	 * 
	 * } }
	 */

	public void newReg(View view) {
		// Do something in response to button
		Intent intent = new Intent(this, NewRegActivity.class);
		startActivity(intent);

	}

	public void aboutView(View view) {
		// Do something in response to button
		Intent intent = new Intent(this, AboutActivity.class);
		startActivity(intent);
	}

	class AsyncLogin extends AsyncTask<String, String, String> {

		protected void onPreExecute() {
			categdao = new CategoryDAO();
			citydao = new CityDAO();
			userdao = new UserDAO();
			pDialog = new ProgressDialog(MainActivity.this);
			pDialog.setMessage("logining...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();

		}

		@Override
		protected String doInBackground(String... params) {

			// int log = userdao.login(edituser.getText().toString(),
			// edipass.getText().toString());
			if (userdao.login(edituser.getText().toString(), edipass.getText()
					.toString()) == 1) {

				UserGlobal.usersession = userdao.queryUser(edituser.getText()
						.toString(), edipass.getText().toString());
				categs = categdao.queryCategoryAll();

				citys = citydao.queryCityAll();

				return "ok";

			} else {

				return "err";

			}

		}

		protected void onPostExecute(String result) {

			pDialog.dismiss();

			if (result.equals("ok")) {
				list2 = new String[categs.size()];
				list = new String[citys.size()];

				int i = 0;
				for (Iterator<City> iterator = citys.iterator(); iterator
						.hasNext();) {
					City city = (City) iterator.next();
					list[i] = city.getName();
					i++;
				}

				i = 0;
				for (Iterator<Category> iterator = categs.iterator(); iterator
						.hasNext();) {
					Category cat = (Category) iterator.next();
					list2[i] = cat.getName();
					i++;
				}
				
				
				UserGlobal.citys=list;
				UserGlobal.categorys=list2;
				Intent intent = new Intent(MainActivity.this, UserMain.class);
				startActivity(intent);

			} else {

				Toast toast = Toast.makeText(getApplicationContext(),
						"User or Password incorrect...Try Again",
						Toast.LENGTH_SHORT);
				toast.show();

			}

		}

	}
}