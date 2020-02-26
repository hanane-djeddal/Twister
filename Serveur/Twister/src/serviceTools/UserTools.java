package serviceTools;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modeles.*;

import bdConnexion.*;

public class UserTools {
	public final static int duree =30 ;

	public static boolean userExists(String login) throws SQLException{
		//appel BDD
		Connection connexion=null;
		Statement st=null;
		ResultSet logins=null;
		try {
			connexion = BDConnection.getMySQLConnection();
			String query = "SELECT login FROM Utilisateur WHERE login=\""+login+"\";";
			st= connexion.createStatement();
			st.executeQuery(query);
			logins= st.getResultSet();
			if(logins.next()) {
				return true;
			}
			return false;
		}finally {
			if(st != null)
				st.close();
			if(logins != null)
				logins.close();
			if(connexion != null)
				connexion.close();
		}
	}

	public static boolean passwordFormat(String password) {
		if(password.length()<8 || password.length()>255) {
			return false;
		}
		else {
			return true;
		}
		
	}

	public static boolean dataFormat(String data) {
		if(data.length()==0|| data.length()>255) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * Ajoute un utilisateur à la base de données
	 * @param login
	 * @param password
	 * @param nom
	 * @param prenom
	 * @param admin
	 * @return true si l'utilisateur est ajoute, false sinon
	 * @throws SQLException
	 */
	public static boolean ajouterUserBD(String login, String password,String nom, String prenom, int admin) throws SQLException{
		Connection connexion = BDConnection.getMySQLConnection();
		String query = "INSERT INTO Utilisateur (login, motDePasse, nom, prenom,admin) VALUES (\""+login+"\", \""+password+"\", \""+nom+"\", \""+prenom+"\",\""+admin+"\");";
		Statement st= connexion.createStatement();
		int n = st.executeUpdate(query);
		if(n > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ajoute id_user à la table session
	 * @param user
	 * @return la clef de connexion associe au user, -1 si elle ne peut l'ajouter
	 * @throws SQLException
	 */
	public static int ajouterLoginSession(User user) throws SQLException{
		Connection connexion = BDConnection.getMySQLConnection();
		String query = "INSERT INTO Session (admin, id_user, date_connexion) VALUES (\""+user.getAdmin()+"\", \""+user.getId()+"\", NOW());";
		Statement st= connexion.createStatement();
		int n = st.executeUpdate(query);
		if(n > 0) {
			query = "SELECT clef FROM Session WHERE id_user=\""+user.getId()+"\";";
			ResultSet s= st.executeQuery(query);
			if(s.next()) {
				return s.getInt("clef");
			}
		}
		return -1;
	}
	
	public static User getUserByLogin(String login) throws SQLException {
		Connection connexion=null;
		Statement st=null;
		ResultSet logins=null;
		try {
			connexion = BDConnection.getMySQLConnection();
			String query = "SELECT * FROM Utilisateur WHERE login=\""+login+"\";";
			st= connexion.createStatement();
			st.executeQuery(query);
			logins= st.getResultSet();
			if(!(logins.next())) {
				return null;
			}
			return (new User(logins.getInt("id_user"),logins.getString("nom"),logins.getString("prenom"),login,logins.getInt("admin")));
		}finally {
			if(st != null)
				st.close();
			if(logins != null)
				logins.close();
			if(connexion != null)
				connexion.close();
		}
	}
	
	public static boolean verifierPassword(String login,String password) throws SQLException{
		Connection connexion = BDConnection.getMySQLConnection();
		String query = "SELECT login, motDePasse FROM Utilisateur WHERE login=\""+login+"\";";
		Statement st= connexion.createStatement();
		st.executeQuery(query);
		ResultSet logins= st.getResultSet();
		if(!(logins.next())) {
			return false;
		}
		String pwd=logins.getString("motDePasse");
		if(pwd.equals(password)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Logout  : supprimer l'utilisateur de la table Session
	 * @param clef clef de connexion
	 * @return nombre de lignes supprimees
	 * @throws SQLException
	 */
	public static int supprimerLogin(int clef) throws SQLException {
		Connection connexion=null;
		Statement st=null;
		try{
			int id_user=getIdByClef(clef);
			connexion = BDConnection.getMySQLConnection();
			String query = "DELETE FROM Session WHERE id_user=\""+id_user+"\";";
			st= connexion.createStatement();
			int nbre_supp= st.executeUpdate(query);
			return nbre_supp;
		}finally {
			if(st != null)
				st.close();
			if(connexion != null)
				connexion.close();
		}
	}

	public static int getIdByClef(int clef) throws SQLException {
		Connection connexion=null;
		Statement st=null;
		ResultSet sessions=null;
		try {
			connexion = BDConnection.getMySQLConnection();
			String query = "SELECT * FROM Session WHERE clef=\""+clef+"\";";
			st= connexion.createStatement();
			st.executeQuery(query);
			sessions= st.getResultSet();
			if(sessions.next()) {
				return sessions.getInt("id_user");
			}
			return -1;
		}finally {
			if(st != null)
				st.close();
			if(sessions != null)
				sessions.close();
			if(connexion != null)
				connexion.close();
		}
	}
	
	public static User getUserById(int id) throws SQLException {
		Connection connexion=null;
		Statement st=null;
		ResultSet users=null;
		try {
			connexion = BDConnection.getMySQLConnection();
			String query = "SELECT * FROM Utilisateur WHERE id_user=\""+id+"\";";
			st= connexion.createStatement();
			st.executeQuery(query);
			users= st.getResultSet();
			if(users.next()) {
				return (new User(users.getInt("id_user"),users.getString("nom"),users.getString("prenom"),users.getString("login"),users.getInt("admin")));
			}
			return null;
		}finally {
			if(st != null)
				st.close();
			if(users != null)
				users.close();
			if(connexion != null)
				connexion.close();
		}
	}
	
	public static boolean isExpired (int clef) throws SQLException{
		Connection connexion=null;
		Statement st=null;
		ResultSet sessions=null;
		try {
			connexion = BDConnection.getMySQLConnection();
			String query = "SELECT * FROM Session WHERE clef=\""+clef+"\";";
			st= connexion.createStatement();
			st.executeQuery(query);
			sessions= st.getResultSet();
			if(sessions.next()) {
				//si c'est un compte administrateur : pas de duree de vie
				int admin = sessions.getInt("admin");
				if(admin == 1) {
					return false;
				}
				Timestamp debut = sessions.getTimestamp("date_connexion");
				Timestamp now =new Timestamp(System.currentTimeMillis());
				long ms = (now.getTime() - debut.getTime())/(1000*60);
				if (ms > UserTools.duree) {
					return true;
				}
				return false;
			}
			return true;
		}finally {
			if(st != null)
				st.close();
			if(sessions != null)
				sessions.close();
			if(connexion != null)
				connexion.close();
		}
	}

	public static User getUserLogin(int clef, String login)throws SQLException {
		Connection connexion =null;
		Statement st=null;
		ResultSet user=null;
		try {
		connexion = BDConnection.getMySQLConnection();
		String query = "SELECT * FROM Utilisateur WHERE login=\""+login+"\";";
		st = connexion.createStatement();
		st.executeQuery(query);
		user= st.getResultSet();
		while(user.next()) {
			return (new User(user.getInt("id_user"),user.getString("nom"),user.getString("prenom"),user.getString("login"),user.getInt("admin")));
		}
		return null;
	}finally {
		if(st != null)
			st.close();
		if(user != null)
			user.close();
		if(connexion != null)
			connexion.close();
	}
	}
	

}
