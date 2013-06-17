package com.example.DAO;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import com.example.conexion.RemoteConexion;
import com.example.negocio.Service;
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

		String username = user.getUser();
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

		JSONArray jdata = post.getServerData(poststring,
				RemoteConexion.CONNECT_REMOTE_URL + "adduser.php");

		if (jdata != null && jdata.length() > 0) {
			JSONObject json_data;
			try {
				json_data = jdata.getJSONObject(0);
				respond = json_data.getInt("respond");

			} catch (JSONException e) {
				e.printStackTrace();
			}

			return respond;

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

	public int login(String user, String passwo) {
		respond = 0;

		String username = user;
		String password = passwo;

		ArrayList<NameValuePair> poststring = new ArrayList<NameValuePair>();
		post = new HttpPostAux();

		poststring.add(new BasicNameValuePair("user", username));
		poststring.add(new BasicNameValuePair("password", password));

		JSONArray jdata = post.getServerData(poststring,
				RemoteConexion.CONNECT_REMOTE_URL + "acces.php");

		if (jdata != null && jdata.length() > 0) {
			JSONObject json_data;
			try {
				json_data = jdata.getJSONObject(0);
				respond = json_data.getInt("logstatus");

			} catch (JSONException e) {
				e.printStackTrace();
			}

			return respond;

		} else {
			return 0;
		}

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User queryUser(String user, String pass) {

		String username = user;
		String password = pass;

		ArrayList<NameValuePair> poststring = new ArrayList<NameValuePair>();
		post = new HttpPostAux();

		poststring.add(new BasicNameValuePair("query", "USER"));
		poststring.add(new BasicNameValuePair("user", username));
		poststring.add(new BasicNameValuePair("password", password));

		JSONArray jdata = post.getServerData(poststring,
				RemoteConexion.CONNECT_REMOTE_URL + "queryuser.php");

		if (jdata != null && jdata.length() > 0) {
			JSONObject json_data;

			try {
				for (int i = 0; i < jdata.length(); i++) {
					json_data = jdata.getJSONObject(i);
					User tmp = new User();
					
					tmp.setUser(json_data.getString("user"));
					tmp.setName(json_data.getString("name"));
					tmp.setLastname(json_data.getString("lastname"));
					tmp.setAddress(json_data.getString("address"));
					tmp.setEmail(json_data.getString("email"));
					tmp.setId(json_data.getString("document"));
					tmp.setPassword(json_data.getString("password"));
					tmp.setProfession(json_data.getString("profesion"));
					tmp.setTel(json_data.getString("telephone"));
					tmp.setRatingacumulado(json_data.getInt("rating_acum"));
					tmp.setNumrating(json_data.getInt("num_rating"));
					
					
					return tmp;
				}

			} catch (JSONException e) {
				e.printStackTrace();
			}

		} 

		return null;
	}

}
