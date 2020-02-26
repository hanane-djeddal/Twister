package modeles;

public class User {
	private String nom;
	private String prenom;
	private String login;
	private int id;
	private int admin; 
	
	public User(int id,String nom, String prenom, String login, int admin) {
		this.nom=nom;
		this.prenom=prenom;
		this.login=login;
		this.id=id;
		this.admin=admin;
	}
	
	public String getNom() { return nom; }
	
	public String getPrenom() { return prenom; }
	
	public String getLogin() { return login; }
	
	
	public int getId() { return id; }
	
	
	public int getAdmin() { return admin; }
	
	


}
