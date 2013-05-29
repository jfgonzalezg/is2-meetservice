package com.example.meetservice2;

import java.util.ArrayList;
import java.util.List;

import com.example.DAO.CityDAO;
import com.example.negocio.City;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SearchActivity extends Activity {
	
	Spinner city;
	Spinner category;
	EditText searchbox;
	Button searchbut;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
		city = (Spinner) findViewById(R.id.spinner1Search);
		category = (Spinner) findViewById(R.id.spinner2Search);
		searchbox = (EditText) findViewById(R.id.editNEWSERVICEOFFERemail);
		searchbut = (Button) findViewById(R.id.buttonSearchStartSend);
		searchbut.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			}
		});
		
		
		/*CityDAO citydao = new CityDAO();
		List<String> list = new ArrayList<String>();
		ArrayList<City> citys = citydao.queryCategoryAll();
		
		for(int i = 0 ; i<citys.size();i++){
		list.add(citys.get(i).getName());
		}
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
			android.R.layout.simple_spinner_item, list);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		city.setAdapter(dataAdapter);
		*/
		
		
		//city.setAdapter(adapter)
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}

}
