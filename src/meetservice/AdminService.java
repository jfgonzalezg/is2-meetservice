package meetservice;

import com.example.meetservice2.R;
import com.example.meetservice2.R.layout;
import com.example.meetservice2.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AdminService extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin_service);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.admin, menu);
		return true;
	}

}
