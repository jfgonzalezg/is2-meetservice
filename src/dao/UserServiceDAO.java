package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import session.UserGlobal;
import util.HttpPostAux;
import business.Service;
import business.UserService;
import conexion.RemoteConexion;

public class UserServiceDAO {
	private HttpPostAux post;

	private ArrayList<UserService> uservices;

	private ArrayList<Service> services;

	public UserServiceDAO() {
	}

	public int insertUserService(int servicecode) {

		int respond = 0;
		String type = "INSERT";

		Date dactual = new Date();
		java.text.DateFormat dformat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		String datenow = dformat.format(dactual);

		ArrayList<NameValuePair> poststring = new ArrayList<NameValuePair>();
		post = new HttpPostAux();

		poststring.add(new BasicNameValuePair("servicecode", servicecode + ""));
		poststring.add(new BasicNameValuePair("date", datenow));
		poststring.add(new BasicNameValuePair("user", UserGlobal.usersession
				.getUser()));
		poststring.add(new BasicNameValuePair("type", type));
		poststring.add(new BasicNameValuePair("password",
				UserGlobal.usersession.getPassword()));

		JSONArray jdata = post.getServerData(poststring,
				RemoteConexion.CONNECT_REMOTE_URL + "adduserservice.php");

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

	public int updateUserService(UserService uservicee) {

		int respond = 0;
		String type = "UPDATE";

		String username = UserGlobal.usersession.getUser(); // assigning
															// proprietary of
															// service

		Date date = new Date();
		java.text.DateFormat dformat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		String dateend = dformat.format(date);

		ArrayList<NameValuePair> poststring = new ArrayList<NameValuePair>();
		post = new HttpPostAux();

		poststring.add(new BasicNameValuePair("cod", uservicee.getCod() + ""));
		poststring.add(new BasicNameValuePair("acepted", uservicee.getAcepted()
				+ ""));
		poststring.add(new BasicNameValuePair("servicecode", uservicee
				.getServicecode() + ""));
		poststring.add(new BasicNameValuePair("date", dateend));
		poststring.add(new BasicNameValuePair("closed", uservicee.getClosed()
				+ ""));
		poststring.add(new BasicNameValuePair("qualified", uservicee
				.getQualified() + ""));
		poststring.add(new BasicNameValuePair("user", username));
		poststring.add(new BasicNameValuePair("type", type));
		poststring.add(new BasicNameValuePair("password",
				UserGlobal.usersession.getPassword()));

		JSONArray jdata = post.getServerData(poststring,
				RemoteConexion.CONNECT_REMOTE_URL + "adduserservice.php"); //

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

	public ArrayList<UserService> queryUserServicesByUser(String username) {

		uservices = new ArrayList<UserService>();

		ArrayList<NameValuePair> poststring = new ArrayList<NameValuePair>();
		post = new HttpPostAux();

		poststring.add(new BasicNameValuePair("attrib", username));
		poststring.add(new BasicNameValuePair("query", "USBYUSER"));

		JSONArray jdata = post.getServerData(poststring,
				RemoteConexion.CONNECT_REMOTE_URL + "queryuserservice.php");

		if (jdata != null && jdata.length() > 0) {
			JSONObject json_data;

			try {
				for (int i = 0; i < jdata.length(); i++) {
					json_data = jdata.getJSONObject(i);
					UserService tmp = new UserService();

					tmp.setCod(json_data.getInt("cod"));
					tmp.setServicecode(json_data.getInt("servicecode"));
					tmp.setUsername(json_data.getString("user"));
					tmp.setClosed(json_data.getInt("closed"));
					tmp.setQualified(json_data.getInt("qualified"));
					tmp.setAcepted(json_data.getInt("acepted"));
					tmp.setDateini(json_data.getString("date_start"));
					tmp.setDatefin(json_data.getString("date_end"));

					uservices.add(tmp);
				}

			} catch (JSONException e) {
				e.printStackTrace();
			}

			return uservices;

		} else {
			return null;
		}

	}

	public ArrayList<Service> queryServicesGotByUser(String username) {

		services = new ArrayList<Service>();

		ArrayList<NameValuePair> poststring = new ArrayList<NameValuePair>();
		post = new HttpPostAux();

		poststring.add(new BasicNameValuePair("attrib", username));
		poststring.add(new BasicNameValuePair("query", "SBYUSER"));

		JSONArray jdata = post.getServerData(poststring,
				RemoteConexion.CONNECT_REMOTE_URL + "queryuserservice.php");

		if (jdata != null && jdata.length() > 0) {
			JSONObject json_data;

			try {
				for (int i = 0; i < jdata.length(); i++) {
					json_data = jdata.getJSONObject(i);
					Service tmp = new Service();

					tmp.setName(json_data.getString("name"));
					tmp.setCod(json_data.getInt("cod"));
					tmp.setAddress(json_data.getString("address"));
					tmp.setDescription(json_data.getString("description"));
					tmp.setTelephone(json_data.getString("telephone"));
					tmp.setCategory(json_data.getString("category"));
					tmp.setCity(json_data.getString("city"));
					// tmp.setDate_start(json_data.getDate("date_start"));
					// tmp.setDate_end(date_end)
					tmp.setWebpage(json_data.getString("webpage"));
					tmp.setAvailability(json_data.getInt("availability"));
					tmp.setNum_rating(json_data.getInt("num_rating"));
					tmp.setRating_acum(json_data.getInt("rating_acum"));
					tmp.setAdmin_state(json_data.getString("admin_state"));
					tmp.setEmail(json_data.getString("email"));
					tmp.setUsername(json_data.getString("username"));

					tmp.setCalatencion(json_data.getInt("calatencion"));
					tmp.setCalcalidad(json_data.getInt("calcalidad"));
					tmp.setCalcosto(json_data.getInt("calcosto"));
					tmp.setCalculminacion(json_data.getInt("calculminacion"));
					tmp.setCalpuntualidad(json_data.getInt("calpuntualidad"));
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

	public ArrayList<UserService> queryUserServicesByCodSer(int servicecode) {

		uservices = new ArrayList<UserService>();

		ArrayList<NameValuePair> poststring = new ArrayList<NameValuePair>();
		post = new HttpPostAux();

		poststring.add(new BasicNameValuePair("attrib", servicecode + ""));
		poststring.add(new BasicNameValuePair("query", "USBYCODSER"));

		JSONArray jdata = post.getServerData(poststring,
				RemoteConexion.CONNECT_REMOTE_URL + "queryuserservice.php");

		if (jdata != null && jdata.length() > 0) {
			JSONObject json_data;

			try {
				for (int i = 0; i < jdata.length(); i++) {
					json_data = jdata.getJSONObject(i);
					UserService tmp = new UserService();

					tmp.setCod(json_data.getInt("cod"));
					tmp.setServicecode(json_data.getInt("servicecode"));
					tmp.setUsername(json_data.getString("user"));
					tmp.setClosed(json_data.getInt("closed"));
					tmp.setQualified(json_data.getInt("qualified"));
					tmp.setAcepted(json_data.getInt("acepted"));
					tmp.setDateini(json_data.getString("date_start"));
					tmp.setDatefin(json_data.getString("date_end"));

					uservices.add(tmp);
				}

			} catch (JSONException e) {
				e.printStackTrace();
			}

			return uservices;

		} else {
			return null;
		}

	}

	public ArrayList<Service> queryServicesGotByCodSer(int servicecode) {

		services = new ArrayList<Service>();

		ArrayList<NameValuePair> poststring = new ArrayList<NameValuePair>();
		post = new HttpPostAux();

		poststring.add(new BasicNameValuePair("attrib", servicecode + ""));
		poststring.add(new BasicNameValuePair("query", "SBYCODSER"));

		JSONArray jdata = post.getServerData(poststring,
				RemoteConexion.CONNECT_REMOTE_URL + "queryuserservice.php");

		if (jdata != null && jdata.length() > 0) {
			JSONObject json_data;

			try {
				for (int i = 0; i < jdata.length(); i++) {
					json_data = jdata.getJSONObject(i);
					Service tmp = new Service();

					tmp.setName(json_data.getString("name"));
					tmp.setCod(json_data.getInt("cod"));
					tmp.setAddress(json_data.getString("address"));
					tmp.setDescription(json_data.getString("description"));
					tmp.setTelephone(json_data.getString("telephone"));
					tmp.setCategory(json_data.getString("category"));
					tmp.setCity(json_data.getString("city"));
					// tmp.setDate_start(json_data.getDate("date_start"));
					// tmp.setDate_end(date_end)
					tmp.setWebpage(json_data.getString("webpage"));
					tmp.setAvailability(json_data.getInt("availability"));
					tmp.setNum_rating(json_data.getInt("num_rating"));
					tmp.setRating_acum(json_data.getInt("rating_acum"));
					tmp.setAdmin_state(json_data.getString("admin_state"));
					tmp.setEmail(json_data.getString("email"));
					tmp.setUsername(json_data.getString("username"));

					tmp.setCalatencion(json_data.getInt("calatencion"));
					tmp.setCalcalidad(json_data.getInt("calcalidad"));
					tmp.setCalcosto(json_data.getInt("calcosto"));
					tmp.setCalculminacion(json_data.getInt("calculminacion"));
					tmp.setCalpuntualidad(json_data.getInt("calpuntualidad"));

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
