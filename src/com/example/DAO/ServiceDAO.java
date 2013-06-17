package com.example.DAO;

import java.util.ArrayList;
import java.util.Date;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import com.example.conexion.RemoteConexion;
import com.example.negocio.City;
import com.example.negocio.Service;
import com.example.negocio.User;
import com.example.session.UserGlobal;
import com.example.util.HttpPostAux;

public class ServiceDAO {

	private Service service;
	private ArrayList<Service> services;
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
		String admin_state = service.getAdmin_state();
		Date date_start = service.getDate_start();
		Date date_end = service.getDate_end();
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
	
	
	
	public ArrayList<Service> queryServiceAll(){
		respond = 0;
		
		services = new ArrayList<Service>();
		
		ArrayList<NameValuePair> poststring = new ArrayList<NameValuePair>();
		post = new HttpPostAux();

		poststring.add(new BasicNameValuePair("attrib", null));
		poststring.add(new BasicNameValuePair("querty", "ALL"));
		
		
		
		
		JSONArray jdata = post.getServerData(poststring, RemoteConexion.CONNECT_REMOTE_URL + "queryservice.php");
		
		if (jdata != null && jdata.length() > 0) {
			JSONObject json_data;
			
			try {
				for(int i=0;i<jdata.length();i++){
				json_data = jdata.getJSONObject(i);
				Service tmp= new Service();
				
				 tmp.setName(json_data.getString("name"));
				 tmp.setCod(json_data.getString("cod"));
				 tmp.setAddress(json_data.getString("address"));
				 tmp.setDescription(json_data.getString("description"));
				 tmp.setTelephone(json_data.getString("telephone"));
				 tmp.setCategory(json_data.getString("category"));
				 tmp.setCity(json_data.getString("city"));
				 //tmp.setDate_start(json_data.getDate("date_start"));
				 //tmp.setDate_end(date_end)
				 tmp.setWebpage(json_data.getString("webpage"));
				 tmp.setAvailability(json_data.getInt("availability"));
				 tmp.setNum_rating(json_data.getInt("num_rating"));
				 tmp.setRating_acum(json_data.getInt("rating_acum"));
				 tmp.setAdmin_state(json_data.getString("admin_state"));
				 tmp.setEmail(json_data.getString("email"));
				 
				 services.add(tmp);
				}

			} catch (JSONException e) {
				e.printStackTrace();
			}

			return services;

		} else {
			return null;
		}
		
	}
	
	
	
	public ArrayList<Service> queryServiceThis(){
		respond = 0;
		
		services = new ArrayList<Service>();
		
		ArrayList<NameValuePair> poststring = new ArrayList<NameValuePair>();
		post = new HttpPostAux();

		poststring.add(new BasicNameValuePair("attrib", UserGlobal.usersession.getId()));
		poststring.add(new BasicNameValuePair("query", "BYUSER"));
		
		
		
		
		JSONArray jdata = post.getServerData(poststring, RemoteConexion.CONNECT_REMOTE_URL + "queryservice.php");
		
		if (jdata != null && jdata.length() > 0) {
			JSONObject json_data;
			
			try {
				for(int i=0;i<jdata.length();i++){
				json_data = jdata.getJSONObject(i);
				Service tmp= new Service();
				
				 tmp.setName(json_data.getString("name"));
				 tmp.setCod(json_data.getString("cod"));
				 tmp.setAddress(json_data.getString("address"));
				 tmp.setDescription(json_data.getString("description"));
				 tmp.setTelephone(json_data.getString("telephone"));
				 tmp.setCategory(json_data.getString("category"));
				 tmp.setCity(json_data.getString("city"));
				 //tmp.setDate_start(json_data.getDate("date_start"));
				 //tmp.setDate_end(date_end)
				 tmp.setWebpage(json_data.getString("webpage"));
				 tmp.setAvailability(json_data.getInt("availability"));
				 tmp.setNum_rating(json_data.getInt("num_rating"));
				 tmp.setRating_acum(json_data.getInt("rating_acum"));
				 tmp.setAdmin_state(json_data.getString("admin_state"));
				 tmp.setEmail(json_data.getString("email"));
				 
				 services.add(tmp);
				}

			} catch (JSONException e) {
				e.printStackTrace();
			}

			return services;

		} else {
			return null;
		}
		
	}

}
