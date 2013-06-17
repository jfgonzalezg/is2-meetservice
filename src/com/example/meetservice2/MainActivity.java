package com.example.meetservice2;

import com.example.DAO.UserDAO;
import com.example.session.UserGlobal;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.meetservice2.MESSAGE";
	
	private TextView labelregister;
	private TextView labelabout;
	private Button loginbut;
	private UserDAO userdao;
	private EditText edituser;
	private EditText edipass;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		labelabout = (TextView)findViewById(R.id.textViewMainAbout);
		labelregister = (TextView)findViewById(R.id.textViewMainRegister);
		loginbut = (Button) findViewById(R.id.ButtonMainLogin);
		edituser = (EditText)findViewById(R.id.editTextMainUser);
		edipass = (EditText) findViewById(R.id.editTextMainPassword);
		
		labelabout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				
				aboutView(view);
			}
		});
		
		labelregister.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {

				newReg(view);
			}
		});
		
		loginbut.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				sendLogin(arg0);
				
				
			}
		});
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void sendLogin(View view) {
		/*Intent inten=new Intent(MainActivity.this,UserMain.class);
		startActivity(inten);*/
		
		userdao=new UserDAO();
		
		//int log = userdao.login(edituser.getText().toString(), edipass.getText().toString());
		if(userdao.login(edituser.getText().toString(), edipass.getText().toString()) == 1){
			Intent intent=new Intent(MainActivity.this,UserMain.class);
			startActivity(intent);
			UserGlobal.usersession = userdao.queryUser(edituser.getText().toString(), edipass.getText().toString());
			
		}else {
			Toast toast = Toast.makeText(getApplicationContext(),
					"User or Password incorrect...Try Again", Toast.LENGTH_SHORT);
			toast.show();
			
		}
	}
	public void newReg(View view) {
	    // Do something in response to button
		Intent intent = new Intent(this, NewRegActivity.class);
		startActivity(intent);
		
	}
	public void aboutView(View view) {
	    // Do something in response to button
		Intent intent = new Intent(this, AboutActivity.class);
		startActivity(intent);
	}

}
