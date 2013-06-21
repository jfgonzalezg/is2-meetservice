package meetservice;

import com.example.meetservice2.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;



public class SearchResultActivity extends Activity {
	
	private String search[];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_result);
		// Show the Up button in the action bar.

		
		Bundle bundle = getIntent().getExtras();
		search = bundle.getStringArray("searcharg");
		
		
		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_result, menu);
		return true;
	}

	

}
