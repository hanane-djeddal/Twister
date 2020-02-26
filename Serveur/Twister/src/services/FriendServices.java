package services;

import java.sql.SQLException;
import java.util.*;

import org.json.JSONObject;

public class FriendServices {

	public static JSONObject addFriend(String sclef, String login) {
		//tester si parametres manquant
		if(login==null || sclef == null) {
			return(serviceTools.ErrorJSON.serviceRefused("Parametres manquant",-1));
		}

		int clef=Integer.parseInt(sclef); //transformer la clef en entier
		try {
			//Tester si la connexion n'a pas expiree
			if(serviceTools.UserTools.isExpired(clef) ) {
				return(serviceTools.ErrorJSON.serviceRefused("Connexion expiree",-23));
			}
			int user_id = serviceTools.UserTools.getIdByClef(clef); //recuperer l'id du user qui a demande l'ajout
			//user n'est pas dans la table Session
			if(user_id == -1) {
				return(serviceTools.ErrorJSON.serviceRefused("Connexion expiree",-23));
			}
			//verifier l'ami : il existe et il n'est pas le meme que l'utilisateur 
			modeles.User ami = serviceTools.UserTools.getUserByLogin(login); // recuperer l'id du l'ami a ajouter
			if(ami == null) {
				return(serviceTools.ErrorJSON.serviceRefused("Probleme lors de la recuperation de l'utilisateur",1000));
			}
			if(ami.getId() == user_id) {
				return(serviceTools.ErrorJSON.serviceRefused("Impossible d'ajouter soi meme",-1));
			}
			boolean success=serviceTools.FriendsTools.ajouterAmiBD(user_id, ami.getId());// ajouter à la table Ami
			if(success) {
				return (serviceTools.ErrorJSON.serviceAccepted("message","ami ajoute"));
			}else {
				return(serviceTools.ErrorJSON.serviceRefused("Ami non ajoutee",-1));
			}
		}catch(SQLException e) {
			return(serviceTools.ErrorJSON.serviceRefused("Probleme lors d'ajout d'un ami",1000));
		}
	}

	public static JSONObject deleteFriend(String sclef, String login) {
		//tester si parametres manquant
		if(login==null || sclef == null) {
			return(serviceTools.ErrorJSON.serviceRefused("Parametres manquant",-1));
		}
		int clef=Integer.parseInt(sclef); //transformer la clef en entier
		try {
			//Tester si la connexion n'a pas expiree
			if(serviceTools.UserTools.isExpired(clef) ) {
				return(serviceTools.ErrorJSON.serviceRefused("Connexion expiree",-23));
			}
			int user_id = serviceTools.UserTools.getIdByClef(clef); //recuperer l'id du user qui a demande l'ajout
			if(user_id == -1) {
				return(serviceTools.ErrorJSON.serviceRefused("Connexion expiree",-23));
			}
			modeles.User ami = serviceTools.UserTools.getUserByLogin(login); // recuperer l'id du l'ami a ajouter
			if(ami == null) {
				return(serviceTools.ErrorJSON.serviceRefused("Probleme lors de la recuperation de l'utilisateur",1000));
			}
			boolean success=serviceTools.FriendsTools.supprimerAmiBD(user_id, ami.getId());
			if(success) {
				return (serviceTools.ErrorJSON.serviceAccepted("message","ami supprime"));
			}else {
				return(serviceTools.ErrorJSON.serviceRefused("Ami non supprime",-1));
			}
		}catch(SQLException e) {
			return(serviceTools.ErrorJSON.serviceRefused("Probleme lors de la suppression d'un ami",1000));
		}
	}

	public static JSONObject listFriend(String sclef) {
		if(sclef == null) {
			return(serviceTools.ErrorJSON.serviceRefused("Parametres manquant",-1));
		}
		int clef=Integer.parseInt(sclef); //transformer la clef en entier
		try {
			int user_id = serviceTools.UserTools.getIdByClef(clef); //recuperer l'id du user qui a demande l'ajout
			if(user_id == -1) {
				return(serviceTools.ErrorJSON.serviceRefused("Connexion expiree",-23));
			}
			List<modeles.User> amis=serviceTools.FriendsTools.listerAmiBD(user_id);
			if(amis != null) {
				return (serviceTools.ErrorJSON.serviceAccepted("amis",amis));
			}else {
				return(serviceTools.ErrorJSON.serviceRefused("Impossible de recuperer la liste des amis",-1));
			}
		}catch(SQLException e) {
			return(serviceTools.ErrorJSON.serviceRefused("Probleme lors de la recuperations des amis",1000));
		}
	}

}
