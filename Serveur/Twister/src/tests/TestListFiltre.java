package tests;

import org.json.JSONObject;

import services.MessageServices;

public class TestListFiltre {

	public static void main(String[] args) {
		JSONObject resultat;
		String clef="4";
		String l="message";	
		System.out.println("__Test Service : lister les messages__");
		System.out.println("succes:");
		resultat = MessageServices.listeMessageFiltre(clef, l);
		System.out.println(resultat);

	}

}
