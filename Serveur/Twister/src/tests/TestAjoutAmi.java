package tests;

import org.json.JSONObject;

import services.*;

public class TestAjoutAmi {

	public static void main(String[] args) {
		JSONObject resultat;
		String clef ="1";
		
		System.out.println("__Test Service : Ajout d'un ami __");
		System.out.println("Avec succès :");
		resultat = FriendServices.addFriend(clef,"login3");
		System.out.println(resultat);
		
		System.out.println("Avec echec (paramètre null) :");
		resultat = FriendServices.addFriend(null,null);
		System.out.println(resultat);
		
		System.out.println("Avec echec (meme utilisateur) :");
		resultat = FriendServices.addFriend(String.valueOf(clef),"login1");
		System.out.println(resultat);
	}

}
