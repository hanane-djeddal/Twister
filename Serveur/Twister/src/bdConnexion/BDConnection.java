package bdConnexion;


import java.sql.SQLException;


import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.sql.*;

public class BDConnection {
	private static Database database=null;
	
	public static Connection getMySQLConnection () throws SQLException {
		if (DBStatic.mysql_pooling==false) {
			return (DriverManager.getConnection("jdbc:mysql://"+ DBStatic.mysql_host +"/"+DBStatic.mysql_db
					, DBStatic.mysql_username, DBStatic.mysql_password));
		}else{
			if (database==null) {
				database=new Database("jdbc/db");
			}
			return (database.getConnection());
		}
	}
	
	public static MongoDatabase getMyMongoConnection () {
		MongoClient mongo = MongoClients.create();
		return mongo.getDatabase(DBStatic.mongo_db);
	}
}