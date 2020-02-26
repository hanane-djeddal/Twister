package tests;

import org.json.JSONObject;

import services.UserServices;

public class TestLogin {

	public static void main(String[] args) {
		JSONObject resultat;
		
		System.out.println("__Test Service : Login __");
		System.out.println("Avec succès :");
		resultat = UserServices.login("login2", "motDePasse2");
		System.out.println(resultat);
		
		System.out.println("Avec echec (paramètre null) :");
		resultat = UserServices.login(null, "passwordd");
		System.out.println(resultat);
		
	}

}
