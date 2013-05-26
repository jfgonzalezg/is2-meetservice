package com.example.meetservice2;

import com.example.DAO.UserDAO;
import com.example.negocio.User;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class NewRegActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_reg);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_reg, menu);
		return true;
	}
	
	public void registerNew(View view) {
	    // Do something in response to button
		UserDAO userdao = new UserDAO();
		User user = new User();
		// guardar datos de editfield en user.
		EditText editText = (EditText) findViewById(R.id.editName);
	    String txt = editText.getText().toString();
		user.setName(txt);
		editText = (EditText) findViewById(R.id.editLast);
	    txt = editText.getText().toString();
		user.setLastname(txt);
		editText = (EditText) findViewById(R.id.editEmail);
	    txt = editText.getText().toString();
		user.setEmail(txt);
		editText = (EditText) findViewById(R.id.editProfession);
	    txt = editText.getText().toString();
		user.setProfession(txt);
		editText = (EditText) findViewById(R.id.editCity);
	    txt = editText.getText().toString();
		user.setCity(txt);
		editText = (EditText) findViewById(R.id.editAddress);
	    txt = editText.getText().toString();
		user.setAddress(txt);
		editText = (EditText) findViewById(R.id.editName);
	    txt = editText.getText().toString();
		user.setName(txt);
		editText = (EditText) findViewById(R.id.editPass);
	    txt = editText.getText().toString();
		user.setPassword(txt);
		
		//guardar usuario en base de datos
		userdao.setUser(user);
		userdao.insertUser();
	}

}
