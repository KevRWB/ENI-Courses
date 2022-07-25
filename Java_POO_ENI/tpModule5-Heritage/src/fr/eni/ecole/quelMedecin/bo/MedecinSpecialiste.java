package fr.eni.ecole.quelMedecin.bo;

public class MedecinSpecialiste extends Medecin {
	private String specialite;
	private int tarif;
	public MedecinSpecialiste(String nom, String prenom, String numTel, Adresse adresse, String specialite, int tarif) {
		super(nom, prenom, numTel, adresse);
		this.specialite = specialite;
		this.tarif = tarif;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public int getTarif() {
		return tarif;
	}
	public void setTarif(int tarif) {
		this.tarif = tarif;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("Spécialité : ");
		builder.append(specialite);
		builder.append(String.format("%n"));
		builder.append("Tarif : ");
		builder.append(tarif);
		builder.append(" €");
		builder.append(String.format("%n"));
		builder.append("Adresse :");
		builder.append(this.adresse);
		builder.append(this.afficheCreneaux());
		return builder.toString();
	}
	

}
