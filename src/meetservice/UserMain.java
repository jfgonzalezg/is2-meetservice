package meetservice;

import com.example.meetservice2.R;

import session.UserGlobal;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class UserMain extends Activity {
	
	Button offer;
	Button search;
	Button obtainedservice;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_main);
				
		offer = (Button) findViewById(R.id.buttonMainUserOffer);
		search = (Button) findViewById(R.id.buttonMainUserSearch);
		obtainedservice = (Button) findViewById(R.id.buttonMainUserObtained);
		
		/*Toast toast = Toast.makeText(getApplicationContext(),
				UserGlobal.usersession.getId()+"...Try Again", Toast.LENGTH_SHORT);
		toast.show();*/
		offer.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(UserMain.this, OfferService.class);
				startActivity(intent);
				
			}
		});
		
		search.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(UserMain.this, SearchActivity.class);
				startActivity(intent);
				
				
			}
		});
		
		obtainedservice.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_main, menu);
		return true;
	}

}
