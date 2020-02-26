package tests;

import org.json.JSONObject;

import services.MessageServices;

public class TestListMessage {

	public static void main(String[] args) {
		JSONObject resultat;
		String clef="1";
		String l="login2";	
		System.out.println("__Test Service : lister les messages__");
		System.out.println("succes:");
		resultat = MessageServices.listeMessage(clef, l);
		System.out.println(resultat);
	}

}
