package fr.eni.ecole.quelMedecin.bo;

public class MedecinGeneraliste {
	private String nom;
	private String prenom;
	private String numTel;
	private static int tarif = 25;
	//CONSTRUCTOR
	public MedecinGeneraliste(String nom, String prenom, String numTel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numTel = numTel;
	}
	//METHODS
	public void afficher() {
		System.out.println(toString());
	}
	
	// GET SET
	public String getNumeroDeTelephone() {
		return numTel;
	}
	public void setNumeroDeTelephone(String numTel) {
		this.numTel = numTel;
	}
	public static int getTarif() {
		return tarif;
	}
	public static void setTarif(int tarif) {
		MedecinGeneraliste.tarif = tarif;
	}
	public String getNom() {
		return nom;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(nom.toUpperCase());
		builder.append(" " + prenom);
		builder.append(String.format("%n"));
		builder.append("Téléphone : " + numTel);
		builder.append(String.format("%n"));
		builder.append("Tarif : " + tarif + "€");
		return builder.toString();
	}
	
	
	
}
