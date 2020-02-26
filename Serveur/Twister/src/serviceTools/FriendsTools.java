package serviceTools;

import java.sql.Connection;
import java.sql.ResultSet;

import modeles.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import bdConnexion.BDConnection;

public class FriendsTools {
	public static boolean ajouterAmiBD(int id_user,int id_ami) throws SQLException{
		Connection connexion = BDConnection.getMySQLConnection();
		String query = "INSERT INTO Ami (id_user,id_ami) VALUES (\""+id_user+"\", \""+id_ami+"\");";
		Statement st= connexion.createStatement();
		int n = st.executeUpdate(query);
		if(n > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean supprimerAmiBD(int id_user, int id_ami) throws SQLException {
		Connection connexion = BDConnection.getMySQLConnection();
		String query = "DELETE FROM Ami WHERE id_user=\""+id_user+"\" and id_ami=\""+id_ami+"\";";
		Statement st= connexion.createStatement();
		int n = st.executeUpdate(query);
		if(n > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public static List<User> listerAmiBD(int id_user) throws SQLException{
		List<User> users= new ArrayList<>();
		Connection connexion = BDConnection.getMySQLConnection();
		String query = "SELECT * FROM Ami WHERE id_user=\""+id_user+"\";";
		Statement st= connexion.createStatement();
		st.executeQuery(query);
		ResultSet logins= st.getResultSet();
		while(logins.next()) {
			int id_ami = logins.getInt("id_ami");
			User u = serviceTools.UserTools.getUserById(id_ami);
			users.add(u);
		}
		return users;
	}
}
