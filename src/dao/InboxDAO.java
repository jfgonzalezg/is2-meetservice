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
import business.Inbox;
import conexion.RemoteConexion;

public class InboxDAO {
	private HttpPostAux post;

	private ArrayList<Inbox> messages;

	public InboxDAO() {
	}

	public int insertInbox(String message, int codeget) {

		int respond = 0;
		String type = "INSERT";

		Date dactual = new Date();
		java.text.DateFormat dformat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		String datenow = dformat.format(dactual);

		ArrayList<NameValuePair> poststring = new ArrayList<NameValuePair>();
		post = new HttpPostAux();

		poststring.add(new BasicNameValuePair("date", datenow));
		poststring.add(new BasicNameValuePair("sender", UserGlobal.usersession
				.getUser()));
		poststring.add(new BasicNameValuePair("type", type));
		poststring.add(new BasicNameValuePair("cod_get", codeget + ""));
		poststring.add(new BasicNameValuePair("message", message ));

		JSONArray jdata = post.getServerData(poststring,
				RemoteConexion.CONNECT_REMOTE_URL + "inbox.php");

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

	public ArrayList<Inbox> queryUserServicesByUser(int codeget) {

		messages = new ArrayList<Inbox>();
		String type = "QUERY";

		ArrayList<NameValuePair> poststring = new ArrayList<NameValuePair>();
		post = new HttpPostAux();

		poststring.add(new BasicNameValuePair("type", type));
		poststring.add(new BasicNameValuePair("cod_get", codeget + ""));

		JSONArray jdata = post.getServerData(poststring,
				RemoteConexion.CONNECT_REMOTE_URL + "inbox.php");

		if (jdata != null && jdata.length() > 0) {
			JSONObject json_data;

			try {
				for (int i = 0; i < jdata.length(); i++) {
					json_data = jdata.getJSONObject(i);
					Inbox tmp = new Inbox();

					tmp.setCodget(json_data.getInt("cod_get"));
					tmp.setDate(json_data.getString("date"));
					tmp.setSender(json_data.getString("sender"));
					tmp.setMessage(json_data.getString("message"));
					
					messages.add(tmp);
				}

			} catch (JSONException e) {
				e.printStackTrace();
			}

			return messages;

		} else {
			return null;
		}

	}

}
