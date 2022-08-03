package bonus_tp_Rally;

import java.util.Date;

public class Speciale {
	private String nom;
	private Date jour_heure;
	private double distance;
	private TypeEpreuve type;
	private int resultatIndex = 0;
	//cosntructor
	public Speciale(String nom, Date jour_heure, double distance, TypeEpreuve type) {
		super();
		this.nom = nom;
		this.jour_heure = jour_heure;
		this.distance = distance;
		this.type = type;
		
	}
	
	
	//---methods
	public String getNom() {
		return nom;
	}
	
	public Resultat[] getClassement() {
		return null;
	}


	//toString
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Speciale [nom=");
		builder.append(nom);
		builder.append(", jour_heure=");
		builder.append(jour_heure);
		builder.append(", distance=");
		builder.append(distance);
		builder.append(", type=");
		builder.append(type);
		builder.append(", resultatIndex=");
		builder.append(resultatIndex);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
