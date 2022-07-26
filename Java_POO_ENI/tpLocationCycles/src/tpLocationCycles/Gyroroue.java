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
	@Override
	public String afficher() {
		String affichage = toString() + (fillSpaces(toString(), prixLoc)) + toStringPrice();
		System.out.println(affichage);
		return affichage;
	}
	//toString METHOD
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" - "+ TYPE + " ");
		builder.append(super.toString());
		builder.append(" " + autonomie + " km d'autonomie ");
		return builder.toString();
	}
	public String toStringPrice() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("%.2f €/heure", getPrixLoc()));
		return builder.toString();
	}
	
	//GETTER / SETTERS
	public static String getType() {
		return TYPE;
	}	
	@Override
	public void setAutonomie() {
		// TODO Auto-generated method stub
		
	}

	//STATIC METHOD
	public void setPrixLoc(int tarif) {
		prixLoc = tarif;
	}
	public double getPrixLoc() {
		return prixLoc;
	}
}
