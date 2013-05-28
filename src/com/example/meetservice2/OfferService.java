package com.example.meetservice2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class OfferService extends Activity {
	Button newservice;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_offer_service);
		
		newservice = (Button) findViewById(R.id.buttonOfferNewService);
		
		newservice.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(OfferService.this, NewServiceOffer.class);
				startActivity(intent);
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.offer, menu);
		return true;
	}

}
