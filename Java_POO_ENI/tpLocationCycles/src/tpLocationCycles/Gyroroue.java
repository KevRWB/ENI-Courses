package tpLocationCycles;

import java.time.LocalDate;

public class Gyroroue extends Gyro implements Prix{
	
	private final static String TYPE = "Gyroroue";
	private static double prixLoc = 18.90;

	//CONSTRUCTOR
	public Gyroroue(String marque, String modele, LocalDate dateAchat,int autonomie) {
		super(marque, modele, dateAchat, autonomie);	
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
		builder.append(" " + autonomie + " km d'autonomie ");
		return builder.toString();
	}
	public String toStringPrice() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("%15s", String.format("%.2f €/heure", getPrixLoc())));
		return builder.toString();
	}
	
	//GETTER / SETTERS
	public static String getType() {
		return TYPE;
	}	
	@Override
	public void setAutonomie() {
	}
	

	//STATIC METHOD
	public void setPrixLoc(int tarif) {
		prixLoc = tarif;
	}
	public double getPrixLoc() {
		return prixLoc;
	}
}
