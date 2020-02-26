package services;

import java.sql.SQLException;
import java.util.List;

import serviceTools.UserTools;

import org.bson.Document;
import org.json.JSONObject;

import modeles.User;

public class MessageServices {

	public static JSONObject createMessage(String sclef, String message) {
		int id,clef;
		if(message==null || sclef==null) {
			return(serviceTools.ErrorJSON.serviceRefused("Parametres manquants",-1));
		}
		clef=Integer.parseInt(sclef); //transformer la clef en entier
		try {
			//Tester si la connexion n'a pas expiree
			if(serviceTools.UserTools.isExpired(clef) ) {
				return(serviceTools.ErrorJSON.serviceRefused("Connexion expiree",-1));
			}
			id =serviceTools.UserTools.getIdByClef(clef);// on verifie si la clef de connexion existe dans la table Session
			if( id == -1 ) {
				return(serviceTools.ErrorJSON.serviceRefused("Connexion expire",-1));
			}

			User user = serviceTools.UserTools.getUserById(id);// on retrouve le user qui a ecrit le message 
			if(user == null) {
				return(serviceTools.ErrorJSON.serviceRefused("Probleme lors de la recuperation de l'utilisateur",1000));
			}
			Document succes = serviceTools.MessageTools.ajouterMessage(user,message);//rajout du message a la base mongoBD
			if(succes!=null)
				return(serviceTools.ErrorJSON.serviceAccepted("message","Message ajouté avec success"));
			else 
				return(serviceTools.ErrorJSON.serviceRefused("le message n'a pas pu etre ajouté a la base de données ",1000));
		} catch (SQLException e) {
			return(serviceTools.ErrorJSON.serviceRefused("Probleme lors de la creation du message",1000));
		}
	}
	public static JSONObject deleteMessage(String sclef,String idMessage) {
		int id,clef;
		if(idMessage==null || sclef==null) {
			return(serviceTools.ErrorJSON.serviceRefused("Parametres manquants",-1));
		}
		clef=Integer.parseInt(sclef); //transformer la clef en entier
		try {
			//Tester si la connexion n'a pas expiree
			if(serviceTools.UserTools.isExpired(clef) ) {
				return(serviceTools.ErrorJSON.serviceRefused("Connexion expiree",-1));
			}
			id = serviceTools.UserTools.getIdByClef(clef);// on verifie si la clef de connexion existe dans la table Session
			if( id == -1 ) {
				return(serviceTools.ErrorJSON.serviceRefused("Connexion expire",-1));
			}
			
			boolean succes =serviceTools.MessageTools.effacerMessage( idMessage);

			return(serviceTools.ErrorJSON.serviceAccepted("message","Message supprimé avec success"));
		} catch (SQLException e) {
			return(serviceTools.ErrorJSON.serviceRefused("Probleme lors de la supression du message",1000));
		}
	}
	public static JSONObject listeMessage(String sclef,String login) {
		int id,clef;
		if(login==null || sclef==null) {
			return(serviceTools.ErrorJSON.serviceRefused("Parametres manquants",-1));
		}
		clef=Integer.parseInt(sclef); //transformer la clef en entier
		try {
			//Tester si la connexion n'a pas expiree
			if(serviceTools.UserTools.isExpired(clef) ) {
				return(serviceTools.ErrorJSON.serviceRefused("Connexion expiree",-1));
			}
			id = serviceTools.UserTools.getIdByClef(clef);// on verifie si la clef de connexion existe dans la table Session
			if( id == -1 ) {
				return(serviceTools.ErrorJSON.serviceRefused("Connexion expire",-1));
			}
			User user = serviceTools.UserTools.getUserByLogin(login);// on retrouve le user
			if(user == null) {
				return(serviceTools.ErrorJSON.serviceRefused("Probleme lors de la recuperation de l'utilisateur",1000));
			}
			List <Document> succes = serviceTools.MessageTools.listerLesMessage(user);
			if(succes!=null) {
				return(serviceTools.ErrorJSON.serviceAccepted(succes));
			}
			else {
				return(serviceTools.ErrorJSON.serviceRefused("Pas de messages",-1));
			}
		} catch (SQLException e) {
			return(serviceTools.ErrorJSON.serviceRefused("Probleme lors de recupération des messages",1000));
		}
	}
	public static JSONObject listeMessageFiltre(String sclef, String motClef) {
		int id,clef;
		if(sclef==null) {
			return(serviceTools.ErrorJSON.serviceRefused("Parametres manquants",-1));
		}
		clef=Integer.parseInt(sclef); //transformer la clef en entier
		try {
			//Tester si la connexion n'a pas expiree
			if(serviceTools.UserTools.isExpired(clef) ) {
				return(serviceTools.ErrorJSON.serviceRefused("Connexion expiree",-1));
			}
			id = serviceTools.UserTools.getIdByClef(clef);// on verifie si la clef de connexion existe dans la table Session
			if( id == -1 ) {
				return(serviceTools.ErrorJSON.serviceRefused("Connexion expire",-1));
			}
			List<User> amis=serviceTools.FriendsTools.listerAmiBD(id);
			amis.add(serviceTools.UserTools.getUserById(id));
		
			List<Document> succes =serviceTools.MessageTools.listerLesMessageFiltre(amis,motClef);
			if(succes!=null) {
				return(serviceTools.ErrorJSON.serviceAccepted(succes));
			}
			else {
				return(serviceTools.ErrorJSON.serviceRefused("problemes d'accéss a la base de données",1000));
			}
		} catch (SQLException e) {
			return(serviceTools.ErrorJSON.serviceRefused("Probleme lors de recupération des messages",1000));
		}
	}

}
