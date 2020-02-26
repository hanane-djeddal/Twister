package tests;

import org.json.JSONObject;

import services.FriendServices;

public class TestListAmi {

	public static void main(String[] args) {
		JSONObject resultat;
		String clef ="1";
		
		System.out.println("__Test Service : Liste des amis __");
		System.out.println("Avec succès :");
		resultat = FriendServices.listFriend(clef);
		System.out.println(resultat);
	

	}

}
