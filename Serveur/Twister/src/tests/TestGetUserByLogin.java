package tests;

import org.json.JSONObject;

import services.UserServices;

public class TestGetUserByLogin{

	public static void main(String[] args) {
		JSONObject resultat;
		
		System.out.println("__Test Service : getUserByLogin __");
		System.out.println("Avec succès :");
		resultat = UserServices.getuserbylogin("1", "login2");
		System.out.println(resultat);
		
		System.out.println("Avec echec (paramètre null) :");
		resultat = UserServices.getuserbylogin("1", null);
		System.out.println(resultat);
		
	}

}