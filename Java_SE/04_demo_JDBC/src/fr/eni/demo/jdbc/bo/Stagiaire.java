package fr.eni.demo.jdbc.bo;

public class Stagiaire {
	private int idStagiaire;
	private String nom, prenom, email, password;
	
	//constructors
	public Stagiaire() {
		super();
	}
	
	public Stagiaire(int idStagiaire, String nom, String prenom, String email, String password) {
		this.idStagiaire = idStagiaire;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
	}

	public Stagiaire(String nom, String prenom, String email, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
	}

	//get set
	public int getIdStagiaire() {
		return idStagiaire;
	}

	public void setIdStagiaire(int idStagiaire) {
		this.idStagiaire = idStagiaire;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	//to String


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Stagiaire [idStagiaire=");
		builder.append(idStagiaire);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}


	
	
	
	
	
	
}
