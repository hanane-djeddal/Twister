package tests;

import org.json.JSONObject;

import services.UserServices;

public class TestLogout {

	public static void main(String[] args) {
		JSONObject resultat;
	
		System.out.println("__Test Service : Logout __");
		System.out.println("Avec succès :");
		resultat = UserServices.logout("1");
		System.out.println(resultat);
		
		System.out.println("Avec echec (deja deconnecte) :");
		resultat = UserServices.logout("1");
		System.out.println(resultat);
		
		System.out.println("Avec echec (parametre manquant) :");
		resultat = UserServices.logout(null);
		System.out.println(resultat);


	}

}
