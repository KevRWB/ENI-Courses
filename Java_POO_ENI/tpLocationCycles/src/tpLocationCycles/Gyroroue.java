package tpLocationCycles;

import java.time.LocalDate;

public class Gyroroue extends Gyro {
	
	private final static String TYPE = "Gyroroue";
	private final static double PRIX_LOC = 18.90;
	
	//CONSTRUCTOR
	public Gyroroue(String marque, String modele, LocalDate dateAchat,int autonomie) {
		super(marque, modele, dateAchat, autonomie);	
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
		builder.append(TYPE + " ");
		builder.append(super.toString());
		builder.append(" " + autonomie + " km d'autonomie ");
		return builder.toString();
	}
	public String toStringPrice() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("%.2f €/heure", getPrixLoc()));
		return builder.toString();
	}
	
	//GETTER
	public static String getType() {
		return TYPE;
	}

	public static double getPrixLoc() {
		return PRIX_LOC;
	}

}
