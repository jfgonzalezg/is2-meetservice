package meetservice;

import java.util.ArrayList;

import session.UserGlobal;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import business.Inbox;
import business.UserService;

import com.example.meetservice2.R;

import dao.InboxDAO;
import dao.UserServiceDAO;

public class RequestResponseActivity extends Activity {

	private TextView sender1, sender2, sender3, sender4, sender5, sender6,
			sender7, sender8;

	private TextView message1, message2, message3, message4, message5,
			message6, message7, message8;

	private TextView date1, date2, date3, date4, date5, date6, date7, date8;

	private TextView servicetitle;
	private EditText editmessage;
	private Button bsend;
	private Button baccept;
	private Button bnegative;

	private InboxDAO inboxdao;
	private ArrayList<Inbox> messages;
	private UserServiceDAO uservicedao;
	private String servicecode;
	private String userservicecod;
	private UserService uservice;

	private int response;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_request_response);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.request_response, menu);
		return true;
	}

	class AsyncLoadInbox extends AsyncTask<String, String, String> {

		private Context mcontext;
		private ProgressDialog pDialog;

		public AsyncLoadInbox(Context context) {

			mcontext = context;

		}

		protected void onPreExecute() {

			inboxdao = new InboxDAO();
			uservicedao = new UserServiceDAO();
			messages = new ArrayList<Inbox>();

			Bundle bundle = getIntent().getExtras();
			servicecode = bundle.getString("servicecode");
			userservicecod = bundle.getString("userservicecod");

			sender1 = (TextView) findViewById(R.id.textViewInboxSender1);
			sender2 = (TextView) findViewById(R.id.textViewInboxsender2);
			sender3 = (TextView) findViewById(R.id.textViewInboxsender3);
			sender4 = (TextView) findViewById(R.id.textViewInboxsender4);
			sender5 = (TextView) findViewById(R.id.textViewInboxsender5);
			sender6 = (TextView) findViewById(R.id.textViewInboxsender6);
			sender7 = (TextView) findViewById(R.id.textViewInboxsender7);
			sender8 = (TextView) findViewById(R.id.textViewInboxSender8);

			message1 = (TextView) findViewById(R.id.textViewInboxMessage1);
			message2 = (TextView) findViewById(R.id.textViewInboxMessage2);
			message3 = (TextView) findViewById(R.id.textViewInboxmessage3);
			message4 = (TextView) findViewById(R.id.textViewInboxmessage4);
			message5 = (TextView) findViewById(R.id.textViewInboxmessage5);
			message6 = (TextView) findViewById(R.id.textViewInboxmessage6);
			message7 = (TextView) findViewById(R.id.textViewInboxMessage7);
			message8 = (TextView) findViewById(R.id.textViewInboxMessage8);

			date1 = (TextView) findViewById(R.id.textViewInboxdate1);
			date2 = (TextView) findViewById(R.id.textViewInboxdate2);
			date3 = (TextView) findViewById(R.id.textViewInboxdate3);
			date4 = (TextView) findViewById(R.id.textViewInboxdate4);
			date5 = (TextView) findViewById(R.id.textViewInboxdate5);
			date6 = (TextView) findViewById(R.id.textViewInboxdate6);
			date7 = (TextView) findViewById(R.id.textViewInboxdate7);
			date8 = (TextView) findViewById(R.id.textViewInboxdate8);

			servicetitle = (TextView) findViewById(R.id.textViewInboxtitleservice);

			servicetitle.setText(UserGlobal.serviceactual.getName()
					+ "   cod: " + UserGlobal.serviceactual.getCod());

			bsend = (Button) findViewById(R.id.buttonInboxsend);
			editmessage = (EditText) findViewById(R.id.editTextInboxtxt);

			baccept = (Button) findViewById(R.id.buttonRequestResponseacept);
			bnegative = (Button) findViewById(R.id.ButtonRequestResponseNegative);

			bsend.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

					new AsyncSendInbox(mcontext).execute("?");

				}
			});

			baccept.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					response=1;
					new AsyncSendState(RequestResponseActivity.this).execute("?");
				}
			});

			bnegative.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					response=0;
					new AsyncSendState(RequestResponseActivity.this).execute("?");
				}
			});

			pDialog = new ProgressDialog(RequestResponseActivity.this);
			pDialog.setMessage("loading...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();

		}

		@Override
		protected String doInBackground(String... params) {
			messages = inboxdao.queryUserServicesByUser(Integer
					.parseInt(userservicecod));

			return "ok";
		}

		protected void onPostExecute(String result) {
			if (messages != null) {
				int size = messages.size();
				printMessages(size);
			}
			pDialog.dismiss();

		}

		private void printMessages(int size) {

			if (size >= 8) {

				sender1.setText(messages.get(7).getSender() + " ");
				date1.setText(messages.get(7).getDate() + " ");
				message1.setText(messages.get(7).getMessage() + " ");

				sender2.setText(messages.get(6).getSender() + " ");
				date2.setText(messages.get(6).getDate() + " ");
				message2.setText(messages.get(6).getMessage() + " ");

				sender3.setText(messages.get(5).getSender() + " ");
				date3.setText(messages.get(5).getDate() + " ");
				message3.setText(messages.get(5).getMessage() + " ");

				sender4.setText(messages.get(4).getSender() + " ");
				date4.setText(messages.get(4).getDate() + " ");
				message4.setText(messages.get(4).getMessage() + " ");

				sender5.setText(messages.get(3).getSender() + " ");
				date5.setText(messages.get(3).getDate() + " ");
				message5.setText(messages.get(3).getMessage() + " ");

				sender6.setText(messages.get(2).getSender() + " ");
				date6.setText(messages.get(2).getDate() + " ");
				message6.setText(messages.get(2).getMessage() + " ");

				sender7.setText(messages.get(1).getSender() + " ");
				date7.setText(messages.get(1).getDate() + " ");
				message7.setText(messages.get(1).getMessage() + " ");

				sender8.setText(messages.get(0).getSender() + " ");
				date8.setText(messages.get(0).getDate() + " ");
				message8.setText(messages.get(0).getMessage() + " ");

			} else if (size > 0) {

				if (size - 1 >= 0) {
					sender1.setText(messages.get(size - 1).getSender() + " ");
					date1.setText(messages.get(size - 1).getDate() + " ");
					message1.setText(messages.get(size - 1).getMessage() + " ");
				}

				if (size - 2 >= 0) {
					sender2.setText(messages.get(size - 2).getSender() + " ");
					date2.setText(messages.get(size - 2).getDate() + " ");
					message2.setText(messages.get(size - 2).getMessage() + " ");
				}

				if (size - 3 >= 0) {
					sender3.setText(messages.get(size - 3).getSender() + " ");
					date3.setText(messages.get(size - 3).getDate() + " ");
					message3.setText(messages.get(size - 3).getMessage() + " ");
				}

				if (size - 4 >= 0) {
					sender4.setText(messages.get(size - 4).getSender() + " ");
					date4.setText(messages.get(size - 4).getDate() + " ");
					message4.setText(messages.get(size - 4).getMessage() + " ");
				}

				if (size - 5 >= 0) {
					sender5.setText(messages.get(size - 5).getSender() + " ");
					date5.setText(messages.get(size - 5).getDate() + " ");
					message5.setText(messages.get(size - 5).getMessage() + " ");
				}

				if (size - 6 >= 0) {
					sender6.setText(messages.get(size - 6).getSender() + " ");
					date6.setText(messages.get(size - 6).getDate() + " ");
					message6.setText(messages.get(size - 6).getMessage() + " ");
				}

				if (size - 7 >= 0) {
					sender7.setText(messages.get(size - 7).getSender() + " ");
					date7.setText(messages.get(size - 7).getDate() + " ");
					message7.setText(messages.get(size - 7).getMessage() + " ");
				}

			}

		}

	}

	class AsyncSendInbox extends AsyncTask<String, String, String> {

		private Context mcontext;
		private ProgressDialog pDialog;

		public AsyncSendInbox(Context context) {

			mcontext = context;

		}

		protected void onPreExecute() {

			pDialog = new ProgressDialog(RequestResponseActivity.this);
			pDialog.setMessage("loading...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();

		}

		@Override
		protected String doInBackground(String... params) {
			inboxdao.insertInbox(editmessage.getText().toString(),
					Integer.parseInt(userservicecod));

			return "ok";
		}

		protected void onPostExecute(String result) {
			pDialog.dismiss();

			Toast toast = Toast.makeText(getApplicationContext(),
					"Mensaje Enviado", Toast.LENGTH_SHORT);
			toast.show();

			Intent refresh = new Intent(RequestResponseActivity.this,
					InboxActivity.class);

			refresh.putExtra("servicecode", servicecode);
			refresh.putExtra("userservicecod", userservicecod);
			finish();
			startActivity(refresh);

		}

	}

	class AsyncSendState extends AsyncTask<String, String, String> {

		private Context mcontext;
		private ProgressDialog pDialog;

		public AsyncSendState(Context context) {

			mcontext = context;

		}

		protected void onPreExecute() {
			uservice = UserGlobal.userviceactual;
			if (response == 1) {
				uservice.setAcepted(1);
			} else {
				uservice.setAcepted(0);
			}

			pDialog = new ProgressDialog(RequestResponseActivity.this);
			pDialog.setMessage("loading...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();

		}

		@Override
		protected String doInBackground(String... params) {
			uservicedao.updateUserService(uservice);

			return "ok";
		}

		protected void onPostExecute(String result) {
			pDialog.dismiss();

			Toast toast = Toast.makeText(getApplicationContext(),
					"Mensaje Enviado", Toast.LENGTH_SHORT);
			toast.show();

			Intent refresh = new Intent(RequestResponseActivity.this,
					InboxActivity.class);

			refresh.putExtra("servicecode", servicecode);
			refresh.putExtra("userservicecod", userservicecod);
			finish();
			startActivity(refresh);

		}

	}

}
