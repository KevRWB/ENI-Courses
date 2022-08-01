package fr.eni.tpAnnuaire;

public class Contact {
	private String nom;
	private String numeroTel;
	public Contact(String nom, String numeroTel) {
		super();
		this.nom = nom;
		this.numeroTel = numeroTel;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNumeroTel() {
		return numeroTel;
	}
	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}
	@Override
	public String toString() {
		return "Contact [nom=" + nom + ", numeroTel=" + numeroTel + "]";
	}
	
	
}
