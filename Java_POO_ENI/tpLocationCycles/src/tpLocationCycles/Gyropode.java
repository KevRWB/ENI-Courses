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
		builder.append("[" + tailleMini + "m min" + "]");
		return builder.toString();
	}
	public String toStringPrice() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("%15s", String.format("%.2f €/heure", getPrixLoc())));
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
