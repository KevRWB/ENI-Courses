package tpLocationCycles;

import java.time.LocalDate;

public class Gyropode extends Gyro implements TailleMini, Prix{
	
	private final static String TYPE = "Gyropode";
	private static double prixLoc = 29.90;
	private String tailleMini;
	
	//CONSTRUCTOR
	public Gyropode(String marque, String modele, LocalDate dateAchat, 
				int autonomie, String tailleMini) {
		super(marque, modele, dateAchat, autonomie);
		setTailleMini(tailleMini);
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
