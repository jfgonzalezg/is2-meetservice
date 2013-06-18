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
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);

		city = (Spinner) findViewById(R.id.spinner1Search1);
		category = (Spinner) findViewById(R.id.spinner2Search2);
		searchbox = (EditText) findViewById(R.id.editNEWSERVICEOFFERemail);
		searchbut = (Button) findViewById(R.id.buttonSearchStartSend);
		searchbut.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});

		
		//Spinner City Define
		citydao = new CityDAO();
		
		ArrayList<City> citys = citydao.queryCityAll();
		String list[] = new String[citys.size()];
		int i =0;
		for (Iterator iterator = citys.iterator(); iterator.hasNext();) {
			City city = (City) iterator.next();
			list[i] = city.getName();
			i++;
		}
		
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		city.setAdapter(dataAdapter);
		
		//Spinner Category Define
		categdao = new CategoryDAO();
		
		ArrayList<Category> categs = categdao.queryCategoryAll();
		String list2[] = new String[categs.size()];
		
		i =0;
		for (Iterator iterator = categs.iterator(); iterator.hasNext();) {
			Category cat = (Category) iterator.next();
			list2[i] = cat.getName();
			i++;
		}
		
		
		ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list2);
		dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		category.setAdapter(dataAdapter2);
		

		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}

}
