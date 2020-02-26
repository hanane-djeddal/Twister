package tests;

import java.sql.Date;
import java.util.GregorianCalendar;

import org.json.JSONObject;

import services.MessageServices;

public class TestAjoutMessage {

	public static void main(String[] args) {
		JSONObject resultat;
		String clef="1";
		String msg="voila le message 1";	
		System.out.println("__Test Service : Creation ajout message__");
		System.out.println("succes:");
		resultat = MessageServices.createMessage(clef, msg);
		System.out.println(resultat);
		
		System.out.println("Avec echec (paramètre null) :");
		resultat = MessageServices.createMessage(clef, null);//teste null
		System.out.println(resultat);

		

	}

}
