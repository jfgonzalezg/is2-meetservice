package meetservice;

import session.UserGlobal;

import com.example.meetservice2.R;

import business.User;

import dao.UserDAO;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewRegActivity extends Activity {
	private Button send;

	private int respond;
	private UserDAO userdao;
	private User user;
	private ProgressDialog pDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_reg);

		send = (Button) findViewById(R.id.buttonRegUserReg);

		send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				registerNew(v);

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_reg, menu);
		return true;
	}

	public void registerNew(View view) {
		// Do something in response to button
		userdao = new UserDAO();
		user = new User();
		// guardar datos de editfield en user.
		EditText editText = (EditText) findViewById(R.id.editTextRegUserName);
		String txt = editText.getText().toString();
		user.setName(txt);

		editText = (EditText) findViewById(R.id.editTextRegUserLast);
		txt = editText.getText().toString();
		user.setLastname(txt);

		editText = (EditText) findViewById(R.id.editRegUserEmail);
		txt = editText.getText().toString();
		user.setEmail(txt);

		editText = (EditText) findViewById(R.id.editRegUserProfession);
		txt = editText.getText().toString();
		user.setProfession(txt);
		editText = (EditText) findViewById(R.id.editRegUserTel);
		txt = editText.getText().toString();
		user.setTel(txt);
		editText = (EditText) findViewById(R.id.editRegUserAddress);
		txt = editText.getText().toString();
		user.setAddress(txt);
		editText = (EditText) findViewById(R.id.editRegUserUser);
		txt = editText.getText().toString();
		user.setUser(txt);
		editText = (EditText) findViewById(R.id.editRegUserPass);
		txt = editText.getText().toString();
		user.setPassword(txt);

		editText = (EditText) findViewById(R.id.editTextRegUserId);
		txt = editText.getText().toString();
		user.setId(txt);

		user.setRatingacumulado(0);
		user.setNumrating(0);

		// guardar usuario en base de datos
		userdao.setUser(user);
		// respond = userdao.insertUser();

		new AsyncRegister().execute("?");

		
	}

	public void errorReg() {

		Toast toast = Toast.makeText(getApplicationContext(),
				"Register Error...Try Again", Toast.LENGTH_SHORT);
		toast.show();

	}

	public void correctReg() {

		Toast toast = Toast.makeText(getApplicationContext(),
				"User Registered correctly", Toast.LENGTH_SHORT);
		toast.show();
		
		SystemClock.sleep(2000);
		finish();

	}

	class AsyncRegister extends AsyncTask<String, String, String> {

		protected void onPreExecute() {

			pDialog = new ProgressDialog(NewRegActivity.this);
			pDialog.setMessage("Registering...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();

		}

		@Override
		protected String doInBackground(String... params) {

			if (userdao.insertUser() == 1) {

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
