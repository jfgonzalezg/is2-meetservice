package com.example.meetservice2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.meetservice2.MESSAGE";
	
	TextView labelregister;
	TextView labelabout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		labelabout = (TextView)findViewById(R.id.textViewMainAbout);
		labelregister = (TextView)findViewById(R.id.textViewMainRegister);
		
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
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void sendLogin(View view) {
	    // Do something in response to button
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
