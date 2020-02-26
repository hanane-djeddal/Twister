package tests;

import services.*;
import org.json.JSONObject;

public class TestCreationUser {

	public static void main(String[] args) {
		JSONObject resultat;
		
		System.out.println("__Test Service : Creation d'un utilisateur __");
		System.out.println("Avec succès :");
		resultat = UserServices.createUser("login4", "motDePasse4", "nom4", "prenom4","0");
		System.out.println(resultat);
	
		System.out.println("Avec echec (login existe) :");
		resultat = UserServices.createUser("login3", "motDePasse3", "nom3", "prenom3","0");
		System.out.println(resultat);
		
		System.out.println("Avec echec (paramètre null) :");
		resultat = UserServices.createUser(null, "passwordd", "nom", "prenom",null);
		System.out.println(resultat);
		
		System.out.println("Avec echec (Format password) :");
		resultat = UserServices.createUser("", "pass", "nom", "prenom","0");
		System.out.println(resultat);
	}

}
