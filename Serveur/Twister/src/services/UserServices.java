package services;

import modeles.*;
import org.json.JSONObject;


import java.sql.SQLException;

public class UserServices {

	public static JSONObject createUser(String login, String password,String nom, String prenom,String sadmin) {
		/**
		 * admin prend 1 pour administrateur/ utilisateur normal pour toute autre valeur
		 */
		int admin;
		if(sadmin == null) {
			admin = 0;
		}else {
			admin=Integer.parseInt(sadmin);
			if(admin != 1) {
				admin =0;
			}
		}
		//Parametres manquants
		if(nom==null || password==null || prenom==null || login==null ) {
			return(serviceTools.ErrorJSON.serviceRefused("Parametres manquant",-1));
		}
		//Erreur1: user deja existant
		try {
			boolean is_registered=serviceTools.UserTools.userExists(login);
			if(is_registered) {
				return(serviceTools.ErrorJSON.serviceRefused("Login deja utilise",-1));
			}
		}catch(SQLException e) {
			return(serviceTools.ErrorJSON.serviceRefused("Probleme lors de la verification de l'existance du login",1000));
		}
			
			
		//Erreur2: mauvais format de password
		boolean is_correctFormat=serviceTools.UserTools.passwordFormat(password);
		if(!is_correctFormat) {
			return(serviceTools.ErrorJSON.serviceRefused("Format du mot de passe incorrect",-1));
		}
			
			
		//Erreur3: erreur nom/prenom
		is_correctFormat=serviceTools.UserTools.dataFormat(nom) || serviceTools.UserTools.dataFormat(prenom);
		if(!is_correctFormat) {
			return(serviceTools.ErrorJSON.serviceRefused("Format des donnees incorrect",-1));
		}
		
		
		//insererUser 
		try {
			boolean success=serviceTools.UserTools.ajouterUserBD(login,password,nom,prenom,admin);
			if(success) {
				User user = new User(-1,nom,prenom,login,admin);
				//return login(login,password);
				return (serviceTools.ErrorJSON.serviceAccepted(user,-1));
			}else {
				return(serviceTools.ErrorJSON.serviceRefused("Utilisateur non cree",-1));
			}
		}catch (SQLException e) {
			return(serviceTools.ErrorJSON.serviceRefused("Probleme lors de l'ajout a la base de donnees",1000));
		}
	
	}
	
	
	public static JSONObject login(String login, String password) {
		if(password==null || login==null ) {
			return(serviceTools.ErrorJSON.serviceRefused("Veuillez introduire vos informations",-1));
		}
		try {
			User user=serviceTools.UserTools.getUserByLogin(login);
			boolean pwd_correct = serviceTools.UserTools.verifierPassword(login, password);
			if(user != null && pwd_correct) {
				//Ajouter à la table Login
				int clef = serviceTools.UserTools.ajouterLoginSession(user);
				return(serviceTools.ErrorJSON.serviceAccepted(user,clef));
			}else {
				return(serviceTools.ErrorJSON.serviceRefused("Mot de passe ou Login incorrect",-1));
			}
		}catch(SQLException e) {
			return(serviceTools.ErrorJSON.serviceRefused("Probleme lors de la verification du login",1000));
		}
	}


	public static JSONObject logout(String sclef) {
		//parametre manquant
		if(sclef==null ) {
			return(serviceTools.ErrorJSON.serviceRefused("Parametres manquant",-1));
		}
		int clef=Integer.parseInt(sclef); //transformer en entier
		try {
			int nbre_supp=serviceTools.UserTools.supprimerLogin(clef); //supprimer de la base de donnee
			if(nbre_supp > 0) {
				return(serviceTools.ErrorJSON.serviceAccepted("message","Utilisateur deconnecte"));
			}
			else {
				return(serviceTools.ErrorJSON.serviceRefused("Utilisateur deja deconnecte ou n'existe pas",-1));
			}
		} catch (SQLException e) {
			return(serviceTools.ErrorJSON.serviceRefused("Probleme lors du logout",1000));
		}
	}


	public static JSONObject getuserbylogin(String sclef, String login) {
		//parametre manquant
				if(sclef==null ) {
					return(serviceTools.ErrorJSON.serviceRefused("Parametres manquant",-1));
				}
				int clef=Integer.parseInt(sclef); //transformer en entier
				try {
					User user=serviceTools.UserTools.getUserLogin(clef,login); //supprimer de la base de donnee
					if(user==null) {
						return(serviceTools.ErrorJSON.serviceRefused("Ce login n'existe pas ",-78));
					}
					else {
						return (serviceTools.ErrorJSON.serviceAccepted(user,-1));
					}
				} catch (SQLException e) {
					return(serviceTools.ErrorJSON.serviceRefused("Probleme lors du la recuperation du login",1000));
				}
	}

}
