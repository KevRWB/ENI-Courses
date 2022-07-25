package tpLocationCycles;

import java.time.LocalDate;

public class Gyropode extends Gyro {
	
	private final static String TYPE = "Gyropode";
	private final static double PRIX_LOC = 29.90;
	private String tailleMini;
	
	//CONSTRUCTOR
	public Gyropode(String marque, String modele, LocalDate dateAchat, 
				int autonomie, String tailleMini) {
		super(marque, modele, dateAchat, autonomie);
		this.tailleMini = tailleMini;
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
		builder.append("[" + tailleMini + "m min" + "]");
		return builder.toString();
	}
	public String toStringPrice() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("%.2f €/heure", getPrixLoc()));
		return builder.toString();
	}
	//GETTERS SETTERS
	public String getTailleMini() {
		return tailleMini;
	}
	public void setTailleMini(String tailleMini) {
		this.tailleMini = tailleMini;
	}
	public static String getType() {
		return TYPE;
	}
	public static double getPrixLoc() {
		return PRIX_LOC;
	}
	

}
