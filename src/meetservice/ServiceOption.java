package meetservice;

import session.UserGlobal;

import com.example.meetservice2.R;
import com.example.meetservice2.R.layout;
import com.example.meetservice2.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ServiceOption extends Activity {

	private Button bmessages;
	private Button bqualify;
	private Button bstate;
	private TextView servicetitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service_option);

		bmessages = (Button) findViewById(R.id.buttonServiceOptionsMensajes);
		bqualify = (Button) findViewById(R.id.buttonServiceOptionsqualify);
		bstate = (Button) findViewById(R.id.buttonServiceOptionEstado);
		servicetitle = (TextView) findViewById(R.id.textView1ServiceOptionservice);

		servicetitle.setText(UserGlobal.serviceactual.getName());

		bmessages.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ServiceOption.this,
						InboxActivity.class);
				startActivity(intent);
			}
		});

		bqualify.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});

		bstate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.service_option, menu);
		return true;
	}

}
