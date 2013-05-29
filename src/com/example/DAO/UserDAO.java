package com.example.DAO;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import com.example.conexion.RemoteConexion;
import com.example.negocio.User;
import com.example.util.HttpPostAux;

public class UserDAO {

	User user;
	HttpPostAux post;
	int respond;

	public UserDAO() {
		 user = new User();
	}

	public int insertUser() {
		respond = 0;
		
		String username = user.getName();
		String password = user.getPassword();
		String name = user.getName();
		String lastname = user.getLastname();
		String document = user.getId();
		String tel = user.getTel();
		String address = user.getAddress();
		String email = user.getEmail();
		String profession = user.getProfession();

		ArrayList<NameValuePair> poststring = new ArrayList<NameValuePair>();
		post = new HttpPostAux();

		poststring.add(new BasicNameValuePair("user", username));
		poststring.add(new BasicNameValuePair("password", password));
		poststring.add(new BasicNameValuePair("name", name));
		poststring.add(new BasicNameValuePair("lastname", lastname));
		poststring.add(new BasicNameValuePair("document", document));
		poststring.add(new BasicNameValuePair("telephone", tel));
		poststring.add(new BasicNameValuePair("address", address));
		poststring.add(new BasicNameValuePair("email", email));
		poststring.add(new BasicNameValuePair("profession", profession));
		
		JSONArray jdata = post.getServerData(poststring, RemoteConexion.CONNECT_REMOTE_URL + "adduser.php");
		
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

	public void deleteUser(String username) {

		ArrayList<NameValuePair> poststring = new ArrayList<NameValuePair>();
		post = new HttpPostAux();

		poststring.add(new BasicNameValuePair("user", username));

		JSONArray jdata = post.getServerData(poststring,
				RemoteConexion.CONNECT_REMOTE_URL + "deleteuser.php"); // no
																		// creado
																		// aun

	}
	
	public int login(String user, String password){
		
		
		
		return 0; 
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public User queryUser(String user, String pass){
		
		
		
		return null;
	}

}
