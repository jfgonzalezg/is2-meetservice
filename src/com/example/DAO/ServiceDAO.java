package com.example.DAO;

import java.util.ArrayList;
import java.util.Date;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import com.example.conexion.RemoteConexion;
import com.example.negocio.Service;
import com.example.negocio.User;
import com.example.util.HttpPostAux;

public class ServiceDAO {

	private Service service;
	private HttpPostAux post;
	private int respond;

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public ServiceDAO() {
		 service = new Service();
	}

	public int insertService() {
		respond = 0;
		
		String name = service.getName();
		String address = service.getAddress();
		String cod = service.getCod();
		String description = service.getDescription();
		String telephone = service.getTelephone();
		String category = service.getCategory();
		String city = service.getCity();
		String email = service.getEmail();
		String webpage = service.getWebpage();
		char admin_state = service.getAdmin_state();
		int date_start = service.getDate_start();
		int date_end = service.getDate_end();
		int available = service.getAvailability();
		int numrating=service.getNum_rating();
		int ratingacum=service.getRating_acum();

		ArrayList<NameValuePair> poststring = new ArrayList<NameValuePair>();
		post = new HttpPostAux();

		poststring.add(new BasicNameValuePair("name", name));
		poststring.add(new BasicNameValuePair("description", description));
		poststring.add(new BasicNameValuePair("category", category));
		poststring.add(new BasicNameValuePair("city", city));
		poststring.add(new BasicNameValuePair("telephone", telephone));
		poststring.add(new BasicNameValuePair("address", address));
		poststring.add(new BasicNameValuePair("webpage", webpage));
		poststring.add(new BasicNameValuePair("email", email));
		
		
		JSONArray jdata = post.getServerData(poststring, RemoteConexion.CONNECT_REMOTE_URL + "addservice.php");
		
		if (jdata != null && jdata.length() > 0) {
			JSONObject json_data;
			try{
				json_data = jdata.getJSONObject(0);
				respond = json_data.getInt("respond");
				
			}catch(JSONException e){
				e.printStackTrace();
			}
					
			return respond ;
			
		} else {
			return 0;
		}
	}

	public void deleteUser(String name,String user, String password) {

		ArrayList<NameValuePair> poststring = new ArrayList<NameValuePair>();
		post = new HttpPostAux();

		poststring.add(new BasicNameValuePair("name", name));
		poststring.add(new BasicNameValuePair("user", user));
		poststring.add(new BasicNameValuePair("password", password));

		JSONArray jdata = post.getServerData(poststring,
				RemoteConexion.CONNECT_REMOTE_URL + "deleteservice.php"); // no
																		// creado
																		// aun

	}
	
	public int login(String user, String password){
		
		
		
		return 0; 
	}

	
	public Service queryService(String name){
		
		
		
		return null;
	}

}
