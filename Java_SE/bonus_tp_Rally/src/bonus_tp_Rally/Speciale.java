package bonus_tp_Rally;

import java.util.Arrays;
import java.util.Date;

public class Speciale {
	private Date jourHeure;
	private double distance;
	private String nom;
	private static int resultatIndex = 0;
	private TypeEpreuve typeEpreuve;
	private Resultat[] resultats = new Resultat[50];
	
	//Constructor
	public Speciale(String nom, Date aLieuLe, double distance, TypeEpreuve type) {
		this.nom = nom;
		this.jourHeure = aLieuLe;
		this.distance = distance;
		
	}
	
	//Ajouter resultat
	public void ajouterResultat(Resultat resultat) {
		resultats[resultatIndex] = resultat;
		resultatIndex++;
	}
	//get Classement
	public Resultat[] getClassement(Resultat[] resultats) {
		Arrays.sort(resultats);
		return resultats;
	}

	//infos Spéciale
	public String infosSpeciale() {
		StringBuilder builder = new StringBuilder();
		builder.append("Speciale [jourHeure=");
		builder.append(jourHeure);
		builder.append(", distance=");
		builder.append(distance);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", typeEpreuve=");
		builder.append(typeEpreuve);
		builder.append(", resultats=");
		builder.append(Arrays.toString(resultats));
		builder.append("]");
		return builder.toString();
	}
	
	//
	
}
