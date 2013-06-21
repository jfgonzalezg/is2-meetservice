package meetservice;

import com.example.meetservice2.R;
import com.example.meetservice2.R.layout;
import com.example.meetservice2.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ServiceOption extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service_option);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.service_option, menu);
		return true;
	}

}
