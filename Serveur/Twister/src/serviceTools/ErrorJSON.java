package serviceTools;

import java.util.*;
import org.bson.Document;

import org.json.JSONArray;
import org.json.JSONException;
import modeles.*;
import org.json.JSONObject;

public class ErrorJSON {

	public static JSONObject serviceAccepted(String attribut,String message) {
		try {
			JSONObject resultat = new JSONObject ();
			resultat.put("code", "400");
			resultat.put(attribut, message);
			return resultat;
		} catch (JSONException e) {
			e.getMessage();
			return null;
		}
	}
	public static JSONObject serviceAccepted(User user) {
		try {
			JSONObject resultat = new JSONObject ();
			resultat.put("login", user.getLogin());
			resultat.put("nom", user.getNom());
			resultat.put("prenom", user.getPrenom());
			return resultat;
		} catch (JSONException e) {
			e.getMessage();
			return null;
		}
	}
	
	public static JSONObject serviceAccepted(Document message) {
		try {
			JSONObject resultat = new JSONObject ();
			resultat.put("id", message.get("_id"));
			resultat.put("login", message.getString("author_name"));
			resultat.put("date", message.getDate("date"));
			resultat.put("message", message.getString("message"));
			return resultat;
		} catch (JSONException e) {
			e.getMessage();
			return null;
		}
	}
	public static JSONObject serviceAccepted(String attribut,List<User> users) {
		try {
			JSONObject resultat = new JSONObject ();
			JSONArray jsonArray= new JSONArray();
			for(User u : users) {
				jsonArray.put(serviceAccepted(u));
			}
			resultat.put(attribut,jsonArray);
			resultat.put("code", "400");
			resultat.put("size", users.size());
			return resultat;
		} catch (JSONException e) {
			e.getMessage();
			return null;
		}
	}
	public static JSONObject serviceAccepted(User user,int clef) {
		try {
			JSONObject resultat = new JSONObject ();
			resultat.put("user",serviceAccepted(user));
			resultat.put("clef",clef);
			resultat.put("code", "400");
			return resultat;
		} catch (JSONException e) {
			e.getMessage();
			return null;
		}
	}
	public static JSONObject serviceRefused(String message, int codeErr) {
		try {
			JSONObject resultat = new JSONObject ();
			resultat.put("code", codeErr);
			resultat.put("message", message);
			return resultat;
		} catch (JSONException e) {
			e.getMessage();
			return null;
		}
	}
	public static JSONObject serviceAccepted(List<Document> messages) {
		try {
			JSONObject resultat = new JSONObject ();
			JSONArray jsonArray= new JSONArray();
			for(Document d : messages) {
				jsonArray.put(serviceAccepted(d));
			}
			resultat.put("code", "400");
			resultat.put("messages",jsonArray);
			return resultat;
		} catch (JSONException e) {
			e.getMessage();
			return null;
		}
	}

}
