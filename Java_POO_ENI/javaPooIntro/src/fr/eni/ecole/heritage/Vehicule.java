package fr.eni.ecole.heritage;

public class Vehicule {
	protected String nom;
	protected String couleur;
	//CONSTRUCTEUR
	public Vehicule(String nom, String couleur) {
		super();
		this.nom = nom;
		this.couleur = couleur;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the couleur
	 */
	public String getCouleur() {
		return couleur;
	}
	/**
	 * @param couleur the couleur to set
	 */
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
}
