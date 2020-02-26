package tests;

import org.json.JSONObject;

import services.FriendServices;

public class TestSuppAmi {

	public static void main(String[] args) {
		JSONObject resultat;
		String clef ="1";
		
		System.out.println("__Test Service : Suppression d'un ami __");
		System.out.println("Avec succès :");
		resultat = FriendServices.deleteFriend(clef,"login3");
		System.out.println(resultat);
		
		System.out.println("Avec echec (paramètre null) :");
		resultat = FriendServices.deleteFriend(clef,null);
		System.out.println(resultat);
	}

}
