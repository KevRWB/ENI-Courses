package associationsClassesBidirectionnelle;

import java.util.Arrays;

public class Individu {
	private String prenom;
	private String nom;
	private Voiture voiture;
	private Voiture[]collection = new Voiture[20];
	private int nbCarCollection;
	//CONSTRUCTEUR
	public Individu(String prenom, String nom) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		nbCarCollection = 0;
	}
	//GETTERS / SETTERS	
	public String getPrenom() {
		return prenom;
	}
	public Voiture[] getCollection() {
		return collection;
	}

	public void addCarToCollection(Voiture voiture) {
		this.collection[nbCarCollection] = voiture;
		nbCarCollection ++;
	}

	public Voiture getVoiture() {
		return voiture;
	}
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	//ToString

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Individu [prenom=");
		builder.append(prenom);
		builder.append(", nom=");
		builder.append(nom);
		if(this.nbCarCollection > 0) {
			builder.append(String.format("%nSes voitures : %n"));
			for(int i = 0; i < nbCarCollection; i++) {
				builder.append("Voiture de couleur " + collection[i].getCouleur());
				builder.append(" - Numero de serie " + collection[i].getNumSerie());	
				builder.append(String.format("%n"));
			}
		}
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
