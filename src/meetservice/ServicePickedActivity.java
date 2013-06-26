package meetservice;

import session.UserGlobal;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import business.Service;

import com.example.meetservice2.R;

public class ServicePickedActivity extends Activity {
	private Service servicepicked;
	private Button bViewStatistics, bTakeService;
	private TextView tvServiceName, tvServiceDescription;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service_picked);
		// Show the Up button in the action bar.

		bViewStatistics = (Button) findViewById(R.id.buttonViewStatistics);
		bTakeService = (Button) findViewById(R.id.buttontakeservice);
		tvServiceName = (TextView) findViewById(R.id.textView1ServicePickednames);
		tvServiceDescription = (TextView) findViewById(R.id.textViewServicePickedDescription);
		

		tvServiceDescription.setText(UserGlobal.serviceactual.getDescription());
		tvServiceName.setText(UserGlobal.serviceactual.getName());

		

		bViewStatistics.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				Intent intent = new Intent(ServicePickedActivity.this,
						StatisticsServiceActivity.class);
				startActivity(intent);

			}
		});

		bTakeService.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(ServicePickedActivity.this,
						TakeServiceActivity.class);
				startActivity(intent);

			}
		});

	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.service_picked, menu);
		return true;
	}

}
