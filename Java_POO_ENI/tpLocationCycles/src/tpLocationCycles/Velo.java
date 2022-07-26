package tpLocationCycles;

import java.time.LocalDate;

public class Velo extends Cycle implements  Prix {
	private final static String TYPE = "Velo";
	private static double prixLoc = 4.90;
	private int nbVitesses;

	//CONSTRUCTOR
	public Velo(String marque, String modele, LocalDate dateAchat, 
			int nbVitesses) {
		super(marque, modele, dateAchat);
		this.nbVitesses = nbVitesses;
	}
	
	//#### ---------METHODS
	//PRINT
	public String afficher() {
		String affichage = String.format("%-65s", toString()) + toStringPrice();
		System.out.println(affichage);
		return affichage;
	}
	//toString METHOD
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" - "+ TYPE + " ");
		builder.append(marque);
		builder.append(" " + modele);
		builder.append(" (" + yearsOld(dateAchat) + "an");
		if(yearsOld(dateAchat) > 1) {
			builder.append("s");
		}
		builder.append(")");
		builder.append(" " + nbVitesses + " vitesses");
		return builder.toString();
	}
	public String toStringPrice() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("%15s", String.format("%.2f €/heure", getPrixLoc())));
		return builder.toString();
	}
	
	//GETTERS SETTERS
	public int getNbVitesses() {
		return nbVitesses;
	}
	public void setNbVitesses(int nbVitesses) throws CycleException{
		if(nbVitesses < 2) {
			throw new CycleException("Le nombre de vitesse est superieur à 2", this);
		}else this.nbVitesses = nbVitesses;	
	
	}
	public static String getType() {
		return TYPE;
	}
	
	//STATIC METHOD
	public void setPrixLoc(int tarif) {
		prixLoc = tarif;
	}
	public double getPrixLoc() {
		return prixLoc;
	}


}

