package tests;

import org.json.JSONObject;

import services.MessageServices;

public class TestSuppMessage {

	public static void main(String[] args) {
		JSONObject resultat;
		String clef="1";
		String idMsg="5c756032fb259b53d10ee408";
		System.out.println("__Test Service : suppression message__");
		System.out.println("succes:");
		resultat = MessageServices.deleteMessage(clef,idMsg);
		System.out.println(resultat);

	}
}
