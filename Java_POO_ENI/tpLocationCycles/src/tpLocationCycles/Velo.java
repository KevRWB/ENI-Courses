package tpLocationCycles;

import java.time.LocalDate;

public class Velo extends Cycle implements ChangementVitesse {
	private final static String TYPE = "Velo";
	private final static double PRIX_LOC = 4.90;
	private int nbVitesses;
	
	//CONSTRUCTOR
	public Velo(String marque, String modele, LocalDate dateAchat, 
			int nbVitesses) {
		super(marque, modele, dateAchat);
		this.nbVitesses = nbVitesses;
	}
	
	//Fonction changement de vitesses
	@Override
	public void chgtVitesses() {
		
	}

	
	//PRINT
	@Override
	public String afficher() {
		String affichage = toString() + (fillSpaces(toString(), PRIX_LOC)) + toStringPrice();
		System.out.println(affichage);
		return affichage;
	}
	//toString METHOD
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" - "+ TYPE + " ");
		builder.append(super.toString());
		builder.append(" " + nbVitesses + " vitesses");
		return builder.toString();
	}
	public String toStringPrice() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("%.2f €/heure", getPrixLoc()));
		return builder.toString();
	}
	
	//GETTERS SETTERS
	public int getNbVitesses() {
		return nbVitesses;
	}

	

	public void setNbVitesses(int nbVitesses) {
		this.nbVitesses = nbVitesses;
	}

	public static String getType() {
		return TYPE;
	}

	public static double getPrixLoc() {
		return PRIX_LOC;
	}
	
}

