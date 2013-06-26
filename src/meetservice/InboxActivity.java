package meetservice;

import java.util.ArrayList;
import java.util.Iterator;

import session.UserGlobal;

import business.Inbox;
import business.Service;

import com.example.meetservice2.R;
import com.example.meetservice2.R.layout;
import com.example.meetservice2.R.menu;

import dao.InboxDAO;
import dao.UserServiceDAO;

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
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class InboxActivity extends Activity {

	private TextView sender1, sender2, sender3, sender4, sender5, sender6,
			sender7, sender8;

	private TextView message1, message2, message3, message4, message5,
			message6, message7, message8;
	
	private TextView date1, date2, date3, date4, date5, date6, date7, date8;
	
	private TextView servicetitle;
	
	private InboxDAO inboxdao;
	private ArrayList<Inbox> messages;
	private String servicecode;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inbox);
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inbox, menu);
		return true;
	}
	
	class AsyncLoadInbox extends AsyncTask<String, String, String> {

		Context mcontext;
		private ProgressDialog pDialog;

		public AsyncLoadInbox(Context context) {

			mcontext = context;

		}

		protected void onPreExecute() {

			inboxdao = new InboxDAO();
			messages = new ArrayList<Inbox>();
			
			Bundle bundle = getIntent().getExtras();
			servicecode = bundle.getString("servicecode");
			
			
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
			
			servicetitle.setText(UserGlobal.serviceactual.getName() + "   cod: "+UserGlobal.serviceactual.getCod() );
			
			
			

			pDialog = new ProgressDialog(InboxActivity.this);
			pDialog.setMessage("loading...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();

		}

		@Override
		protected String doInBackground(String... params) {
			messages = inboxdao.queryUserServicesByUser(Integer.parseInt(servicecode));

			return "ok";
		}

		protected void onPostExecute(String result) {
			
			
			pDialog.dismiss();

		}

	}
	

}
