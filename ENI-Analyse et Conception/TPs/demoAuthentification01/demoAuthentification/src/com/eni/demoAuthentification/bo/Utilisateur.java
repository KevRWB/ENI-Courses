package com.eni.demoAuthentification.bo;

public class Utilisateur {
	
	private String nom;
	
	private String prenom;

	public Utilisateur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	@Override
	public String toString() {
		return "Utilisateur [nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	

}
