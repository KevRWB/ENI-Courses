package fr.eni.rallye.model;

public class Concurrent {

	private String nom;
	
	private String prenom;
	
	private String nationalite;

	public Concurrent(String nom, String prenom, String nationalite) {
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = nationalite;
	}

	public String infosConcurrent() {
		StringBuilder builder = new StringBuilder();
		builder.append("\t\tConcurrent [nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", nationalite=");
		builder.append(nationalite);
		builder.append("]");
		return builder.toString();
	}
	
	
}
