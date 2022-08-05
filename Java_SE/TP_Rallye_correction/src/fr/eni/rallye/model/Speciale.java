package fr.eni.rallye.model;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Speciale {

	private Date jourHeure;
	
	private double distance;

	private TypeEpreuve typeEpreuve;
	
	private String nom;
	
	private Resultat[] resultats = new Resultat[50];
	
	private int resultatIndex = 0;

	public Speciale(String nom, Date aLieuLe, double distance, TypeEpreuve typeEpreuve) {
		this.nom = nom;
		this.jourHeure = aLieuLe;
		this.distance = distance;
		this.typeEpreuve = typeEpreuve;
	}

	public String getNom() {
		return nom;
	}
	
	public Resultat[] getClassement() {
		return ClassementUtil.classerParTemps(Arrays.copyOf(resultats, resultatIndex));
	}
	
	public void ajouterResultat(Resultat resultat) {
		resultats[resultatIndex] = resultat;
		resultatIndex++;
	}
	
	public String infosSpeciale() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		StringBuilder sb = new StringBuilder("Speciale [nom=");
		sb.append(nom)
			.append(", jour_heure=")
			.append(sdf.format(jourHeure))
			.append(", distance=")
			.append(distance)
			.append(", type epreuve=")
			.append(typeEpreuve)
			.append("]");
		return sb.toString();
	}
}




