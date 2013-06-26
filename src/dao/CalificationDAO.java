package dao;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import conexion.RemoteConexion;

import util.HttpPostAux;
import business.Calification;
import business.User;

public class CalificationDAO {
	
	ServiceDAO servicedao;
	Calification score;
	HttpPostAux post;
	int respond;
	
	
	public CalificationDAO(){
		score = new Calification();
	}
	
	public Calification getScore(){
		return score;
	}
	
	public void setScore(Calification score){
		this.score = score;
	}
	
	public int insertScore(){
		respond = 0;
		
		int punt = score.getPunctuality();
		int cal = score.getQuality();
		int aten = score.getAttention();
		int cump = score.getFulfillment();
		int cos = score.getCost();
		String comment = score.getComment();
		
		String pu = String.valueOf(punt);
		String ca = String.valueOf(cal);
		String at = String.valueOf(aten);
		String cu = String.valueOf(cump);
		String co = String.valueOf(cos);
		
		
		ArrayList<NameValuePair> poststring = new ArrayList<NameValuePair>();
		post = new HttpPostAux();
		
		poststring.add(new BasicNameValuePair("punctuality", pu));
		poststring.add(new BasicNameValuePair("qualify", ca));
		poststring.add(new BasicNameValuePair("attention", at));
		poststring.add(new BasicNameValuePair("fulfillment", cu));
		poststring.add(new BasicNameValuePair("cost", co));
		poststring.add(new BasicNameValuePair("comment", comment));
		
		JSONArray jdata = post.getServerData(poststring,
				RemoteConexion.CONNECT_REMOTE_URL + "addscore.php");
		
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
	
	public Calification queryScore(String code, String user){
		String servicecode = code;
		String username = user;
		
		ArrayList<NameValuePair> poststring = new ArrayList<NameValuePair>();
		post = new HttpPostAux();

		poststring.add(new BasicNameValuePair("query", "USER"));
		poststring.add(new BasicNameValuePair("user", username));
		poststring.add(new BasicNameValuePair("service code", servicecode));
		
		JSONArray jdata = post.getServerData(poststring,
				RemoteConexion.CONNECT_REMOTE_URL + "queryscore.php");
		
		if (jdata != null && jdata.length() > 0) {
			JSONObject json_data;

			try {
				for (int i = 0; i < jdata.length(); i++) {
					json_data = jdata.getJSONObject(i);
					Calification tmp = new Calification();
					
					tmp.setPunctuality(Integer.parseInt(json_data.getString("punctuality")));
					tmp.setAttention(Integer.parseInt(json_data.getString("attention")));
					tmp.setQuality(Integer.parseInt(json_data.getString("calidad")));
					tmp.setFulfillment(Integer.parseInt(json_data.getString("address")));
					tmp.setCost(Integer.parseInt(json_data.getString("email")));
					tmp.setComment(json_data.getString("comment"));
					return tmp;
				}
		

			} catch (JSONException e) {
				e.printStackTrace();
			}

		} 

		return null;
	}

}
