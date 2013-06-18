package meetservice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.meetservice2.R;

import business.Category;
import business.City;

import dao.CategoryDAO;
import dao.CityDAO;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SearchActivity extends Activity {

	private Spinner city;
	private Spinner category;
	private EditText searchbox;
	private Button searchbut;
	private CityDAO citydao;
	private CategoryDAO categdao;
	private String[] search;
	private String list[];
	private String list2[];

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		search = new String[3];

		city = (Spinner) findViewById(R.id.spinner1Search1);
		category = (Spinner) findViewById(R.id.spinner2Search2);
		searchbox = (EditText) findViewById(R.id.editNEWSERVICEOFFERemail);
		searchbut = (Button) findViewById(R.id.buttonSearchStartSend);
		

		// Spinner City Define
		citydao = new CityDAO();

		ArrayList<City> citys = citydao.queryCityAll();
		list = new String[citys.size()];
		int i = 0;
		for (Iterator iterator = citys.iterator(); iterator.hasNext();) {
			City city = (City) iterator.next();
			list[i] = city.getName();
			i++;
		}

		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		city.setAdapter(dataAdapter);

		// Spinner Category Define
		categdao = new CategoryDAO();

		ArrayList<Category> categs = categdao.queryCategoryAll();
		list2 = new String[categs.size()];

		i = 0;
		for (Iterator iterator = categs.iterator(); iterator.hasNext();) {
			Category cat = (Category) iterator.next();
			list2[i] = cat.getName();
			i++;
		}

		ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list2);
		dataAdapter2
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		category.setAdapter(dataAdapter2);

		// select options

		search[0] = list[0];
		search[1] = list2[0];
		search[2] = "";

		city.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parentview, View view,
					int position, long id) {

				search[0] = list[position];

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

				search[1] = list2[position];

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
				search[3] = searchbox.getText().toString();
				
				Intent intent=new Intent(SearchActivity.this,SearchResultActivity.class);
				//intent.putExtra("searcharg", search);
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
