package meetservice;

import session.UserGlobal;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.meetservice2.R;

public class SearchActivity extends Activity {

	private Spinner city;
	private Spinner category;
	private EditText searchbox;
	private Button searchbut;
	private String[] search;


	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		search = new String[5];

		city = (Spinner) findViewById(R.id.spinner1Search1);
		category = (Spinner) findViewById(R.id.spinner2Search2);
		searchbox = (EditText) findViewById(R.id.editTextSEARCHAsearchbox);
		searchbut = (Button) findViewById(R.id.buttonSearchStartSend);
			
		// Spinner City Define
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, UserGlobal.citys);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		city.setAdapter(dataAdapter);

		// Spinner Category Define
		

		ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, UserGlobal.categorys);
		dataAdapter2
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		category.setAdapter(dataAdapter2);

		// select options

		search[0] = UserGlobal.citys[0];
		search[1] = UserGlobal.categorys[0];
		search[2] = "";

		city.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parentview, View view,
					int position, long id) {

				search[0] = UserGlobal.citys[position];

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});
		
		category.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parentview, View view,
					int position, long id) {

				search[1] = UserGlobal.categorys[position];

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});
		
		//button and action
		searchbut.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				search[2] = searchbox.getText().toString()+"";
				search[3] = "0";
				search[4] = "0";
				
				Intent intent=new Intent(SearchActivity.this,SearchResultActivity.class);
				intent.putExtra("searcharg", search);
				startActivity(intent);
				
			}
		});
		
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}
	
	
	
}
