package poo.exoUn;

import java.time.LocalDate;

public class Personne {
	private String name;
	private String prenom;
	private LocalDate dateNaissance;
	private Article[] articles;
	//Constructor
	public Personne(String name, String prenom, LocalDate dateNaissance) {
		super();
		this.name = name;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}
	
	//Getters / setters
	
	public Article[] getArticles() {
		return articles;
	}
	public void addArticle(Article article) {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	//ToString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Personne [name=");
		builder.append(name);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", dateNaissance=");
		builder.append(dateNaissance);
		builder.append("]");
		return builder.toString();
	}
	
	
}
