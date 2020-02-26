package serviceTools;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.json.JSONObject;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import modeles.User;

public class MessageTools {

	public static Document ajouterMessage(User user, String message) {
		//Connexion
		MongoDatabase mDB= bdConnexion.BDConnection.getMyMongoConnection ();	
		MongoCollection<Document> collection=mDB.getCollection("Messages");
		
		//query
		Document query = new Document();
		query.append("author_id", user.getId());
		query.append("author_name", user.getLogin());
		GregorianCalendar cal=new GregorianCalendar();
		query.append("date",cal.getTime() );
		query.append("message", message);
		collection.insertOne(query);
		return query;
	}
	public static boolean effacerMessage(String idMessage) {
		//Connexion
		try {
		MongoDatabase mDB= bdConnexion.BDConnection.getMyMongoConnection ();	
		MongoCollection<Document> collection=mDB.getCollection("Messages");
		System.out.println("Trace 3");
		//query
		Document query = new Document();
		query.put("_id", new ObjectId(idMessage));
		
	    FindIterable doc = collection.find(query);
	    Iterator iterator = doc.iterator();	  
	    Document result = (Document) iterator.next();	
	    
		collection.deleteOne(query);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static List<Document> listerLesMessage(User user) {
		MongoDatabase mDB= bdConnexion.BDConnection.getMyMongoConnection ();	
		MongoCollection<Document> collection=mDB.getCollection("Messages");

		//query
		Document query = new Document();
		query.append("author_id", user.getId());
		query.append("author_name", user.getLogin());

		FindIterable doc = collection.find(query);
	    Iterator iterator = doc.iterator();
	    List<Document> list=new ArrayList<Document>();
	    while(iterator.hasNext()) {
	    	list.add((Document) iterator.next());
	    }
	  
	    //return new JSONObject(list);
	    return list;
	    

	}
	public static List<Document> listerLesMessageFiltre(List<User> amis, String motClef) {
		MongoDatabase mDB= bdConnexion.BDConnection.getMyMongoConnection ();	
		MongoCollection<Document> collection=mDB.getCollection("Messages");
		
		//List<String> list=new ArrayList<String>();
		//query
		List<Document> list=new ArrayList<Document>();
		for(User user: amis) {
			
			Document query = new Document();
			query.append("author_id", user.getId());
			query.append("author_name", user.getLogin());
	
			FindIterable doc = collection.find(query);
		    Iterator iterator = doc.iterator();		    
		    while(iterator.hasNext()) {
		    	
		    	Document d=(Document) iterator.next();
		    	String s=d.getString("message");
		    	if(motClef!=null) {
			    	if(s.contains(motClef)) {
			    		list.add(d);
			    		
			    	}
		    	}else {
		    		list.add(d);
		    	}
		    	
		    }
		}
		return list;
		
	}

}
