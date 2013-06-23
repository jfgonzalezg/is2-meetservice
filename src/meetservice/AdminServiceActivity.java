package meetservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.meetservice2.R;

public class AdminServiceActivity extends Activity {
	
	Button bHistorialServices, bCurrentServices;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin_service);
		
		bHistorialServices = (Button) findViewById(R.id.buttonADMINSERVICErecord);
		bCurrentServices = (Button) findViewById(R.id.buttonADMINSERVICEgetservices);
		
		bHistorialServices.setOnClickListener(new OnClickListener(){
			
			public void onClick(View v){
				Intent intent = new Intent(AdminServiceActivity.this,HistorialServiceActivity.class);
				startActivity(intent);
			}
		});
		
		bCurrentServices.setOnClickListener(new OnClickListener(){
			
			public void onClick(View v){
				Intent intent = new Intent(AdminServiceActivity.this,CurrentServicesActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.admin, menu);
		return true;
	}

}
