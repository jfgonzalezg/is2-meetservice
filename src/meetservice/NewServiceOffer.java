package meetservice;

import com.example.meetservice2.R;

import business.Service;
import business.User;

import dao.ServiceDAO;
import dao.UserDAO;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewServiceOffer extends Activity {
	
	private Button send;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_service_offer);
		
		send = (Button) findViewById(R.id.buttonNEWSERVICEOFFERsend);
		
		send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				registerNewService(v);
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_service_offer, menu);
		return true;
	}
	
	
	public void registerNewService(View view) {
		// Do something in response to button
		ServiceDAO servicedao = new ServiceDAO();
		Service service = new Service();
		// guardar datos de editfield en user.
		EditText editText = (EditText) findViewById(R.id.EditTextNEWSERVICEOFFERname);
		String txt = editText.getText().toString();
		service.setName(txt);
		
		editText = (EditText) findViewById(R.id.EditTextNEWSERVICEOFFERdecr);
		txt = editText.getText().toString();
		service.setDescription(txt);
		
		editText = (EditText) findViewById(R.id.EditTextNEWSERVICEOFFERcate);
		txt = editText.getText().toString();
		service.setCategory(txt);
		
		editText = (EditText) findViewById(R.id.EditTextNEWSERVICEOFFERcity);
		txt = editText.getText().toString();
		service.setCity(txt);
		
		editText = (EditText) findViewById(R.id.EditTextNEWSERVICEOFFERtel);
		txt = editText.getText().toString();
		service.setTelephone(txt);
		
		editText = (EditText) findViewById(R.id.EditTextNEWSERVICEOFFERaddress);
		txt = editText.getText().toString();
		service.setAddress(txt);
		
		editText = (EditText) findViewById(R.id.editNEWSERVICEOFFERemail);
		txt = editText.getText().toString();
		service.setEmail(txt);
		
		editText = (EditText) findViewById(R.id.EditTextNEWSERVICEOFFERwebpa);
		txt = editText.getText().toString();
		service.setWebpage(txt);
		
		

		// guardar usuario en base de datos
		servicedao.setService(service);
		

		if ( servicedao.insertService()== 1) {
			correctReg();
			
		}else {
			errorReg();			
		}
		
		finish();
	}
	
	
	public void errorReg() {

		Toast toast = Toast.makeText(getApplicationContext(),
				" Register Error...Try Again", Toast.LENGTH_LONG);
		toast.show();

	}
	public void correctReg() {

		Toast toast = Toast.makeText(getApplicationContext(),
				"Service Registered correctly", Toast.LENGTH_SHORT);
		toast.show();

	}

}
