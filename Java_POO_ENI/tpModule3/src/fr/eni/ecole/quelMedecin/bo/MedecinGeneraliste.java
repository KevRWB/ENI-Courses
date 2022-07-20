package fr.eni.ecole.quelMedecin.bo;

public class MedecinGeneraliste {
	private String nom;
	private String prenom;
	private String numeroDeTelephone;
	private static int tarif=25;
	public MedecinGeneraliste(String nom, String prenom, String numTel) {
		this.nom = nom;
		this.prenom = prenom;
		this.numeroDeTelephone = numTel;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


public String getNumeroDeTelephone() {
		return numeroDeTelephone;
	}
	public void setNumeroDeTelephone(String numeroDeTelephone) {
		this.numeroDeTelephone = numeroDeTelephone;
	}
public static int getTarif() {
		return tarif;
	}
	public static void setTarif(int tarif) {
		MedecinGeneraliste.tarif = tarif;
	}
public void afficher() {
	StringBuilder sb = new StringBuilder();
	sb.append(this.nom);
	sb.append(" ");
	sb.append(this.prenom);
	sb.append(String.format("%n"));
	sb.append("Téléphone:");
	sb.append(this.numeroDeTelephone);
	sb.append(String.format("%n"));
	sb.append("Tarif:");
	sb.append(MedecinGeneraliste.tarif);
	sb.append("€");
	System.out.println(sb.toString());
}



}
