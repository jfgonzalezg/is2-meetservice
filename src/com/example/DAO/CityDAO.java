package com.example.DAO;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.conexion.RemoteConexion;
import com.example.negocio.Category;
import com.example.negocio.City;
import com.example.util.HttpPostAux;

public class CityDAO {
	City city;
	HttpPostAux post;
	ArrayList<City> citys;

	public CityDAO() {
		city = new City();
	}

	public ArrayList<City> queryCityAll() {
		citys = new ArrayList<City>();

		String name = city.getName();
		
		
		ArrayList<NameValuePair> poststring = new ArrayList<NameValuePair>();
		post = new HttpPostAux();
		
		poststring.add(new BasicNameValuePair("?", "?"));
		
		
		JSONArray jdata = post.getServerData(poststring,
				RemoteConexion.CONNECT_REMOTE_URL + "querycity.php");

		if (jdata != null && jdata.length() > 0) {
			JSONObject json_data;
			
			try {
				for(int i=0;i<jdata.length();i++){
				json_data = jdata.getJSONObject(i);
				City tmp= new City();
				
				 tmp.setName(json_data.getString("name"));
				 
				 citys.add(tmp);
				}

			} catch (JSONException e) {
				e.printStackTrace();
			}

			return citys;

		} else {
			return null;
		}
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}


	

}
