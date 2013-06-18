package meetservice;

import com.example.meetservice2.R;

import session.UserGlobal;

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
	private EditText edituser;
	private EditText edipass;
	private ProgressDialog pDialog;

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

				//sendLogin(arg0);
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

	public void sendLogin(View view) {
		/*
		 * Intent inten=new Intent(MainActivity.this,UserMain.class);
		 * startActivity(inten);
		 */

		userdao = new UserDAO();

		// int log = userdao.login(edituser.getText().toString(),
		// edipass.getText().toString());
		if (userdao.login(edituser.getText().toString(), edipass.getText()
				.toString()) == 1) {
			Intent intent = new Intent(MainActivity.this, UserMain.class);
			startActivity(intent);
			UserGlobal.usersession = userdao.queryUser(edituser.getText()
					.toString(), edipass.getText().toString());

		} else {
			Toast toast = Toast.makeText(getApplicationContext(),
					"User or Password incorrect...Try Again",
					Toast.LENGTH_SHORT);
			toast.show();

		}
	}

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
				return "ok";

			} else {

				return "err";

			}

		}

		protected void onPostExecute(String result) {
			pDialog.dismiss();

			if (result.equals("ok")) {
				
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