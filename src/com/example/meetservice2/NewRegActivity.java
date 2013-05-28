package com.example.meetservice2;

import com.example.DAO.UserDAO;

import com.example.negocio.User;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NewRegActivity extends Activity {
	
	int respond;

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
		EditText editText = (EditText) findViewById(R.id.editTextRegUserName);
		String txt = editText.getText().toString();
		user.setName(txt);
		
		editText = (EditText) findViewById(R.id.editTextRegUserLast);
		txt = editText.getText().toString();
		user.setLastname(txt);
		
		editText = (EditText) findViewById(R.id.editRegUserEmail);
		txt = editText.getText().toString();
		user.setEmail(txt);
		
		editText = (EditText) findViewById(R.id.editRegUserProfession);
		txt = editText.getText().toString();
		user.setProfession(txt);
		editText = (EditText) findViewById(R.id.editRegUserTel);
		txt = editText.getText().toString();
		user.setTel(txt);
		editText = (EditText) findViewById(R.id.editRegUserAddress);
		txt = editText.getText().toString();
		user.setAddress(txt);
		editText = (EditText) findViewById(R.id.editRegUserUser);
		txt = editText.getText().toString();
		user.setUser(txt);
		editText = (EditText) findViewById(R.id.editRegUserPass);
		txt = editText.getText().toString();
		user.setPassword(txt);

		// guardar usuario en base de datos
		userdao.setUser(user);
		//respond = userdao.insertUser();

		if ( userdao.insertUser()== 1) {
			correctReg();
			
		}else {
			errorReg();			
		}
		
		finish();
	}

	public void errorReg() {

		Toast toast = Toast.makeText(getApplicationContext(),
				"Error en Registro...Intente de Nuevo"+respond, Toast.LENGTH_SHORT);
		toast.show();

	}
	public void correctReg() {

		Toast toast = Toast.makeText(getApplicationContext(),
				"Usuario Registrado Correctamente"+respond, Toast.LENGTH_SHORT);
		toast.show();

	}
	
	public void backlogin(){
		
		
	}

}





