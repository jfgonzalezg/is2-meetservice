package com.example.DAO;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.conexion.RemoteConexion;
import com.example.negocio.Category;
import com.example.negocio.User;
import com.example.util.HttpPostAux;

public class CategoryDAO {
	
	Category category;
	HttpPostAux post;
	ArrayList<Category> cats;

	public CategoryDAO() {
		category = new Category();
	}

	public ArrayList<Category> queryCategoryAll() {
		cats = new ArrayList<Category>();

		String name = category.getName();
		int cod = category.getCod();
		String descript = category.getDescription();
		
		ArrayList<NameValuePair> poststring = new ArrayList<NameValuePair>();
		post = new HttpPostAux();

		
		
		JSONArray jdata = post.getServerData(null,
				RemoteConexion.CONNECT_REMOTE_URL + "quertycategory.php");

		if (jdata != null && jdata.length() > 0) {
			JSONObject json_data;
			
			try {
				for(int i=0;i<jdata.length();i++){
				json_data = jdata.getJSONObject(i);
				Category tmp= new Category();
				
				 tmp.setName(json_data.getString("name"));
				 tmp.setCod(json_data.getInt("cod"));
				 tmp.setDescription(json_data.getString("description"));
				 cats.add(tmp);
				}

			} catch (JSONException e) {
				e.printStackTrace();
			}

			return cats;

		} else {
			return null;
		}
	}


	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	

}
