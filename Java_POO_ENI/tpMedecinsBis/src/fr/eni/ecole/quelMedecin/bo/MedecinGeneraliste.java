package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalTime;

public class MedecinGeneraliste {
	private String nom;
	private String prenom;
	private String numTel;
	private static int tarif = 25;
	private Adresse adresse;
	private Creneau[] creneaux = new Creneau[15];
	private int nbCreneaux = 0;
	//CONSTRUCTOR
	public MedecinGeneraliste(String nom, String prenom, String numTel, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numTel = numTel;
		this.adresse = adresse;
	}
	//METHODS
	
	//ajouter creneau
	public void ajouterCreneau(LocalTime heureDebut, int duree) {
		Creneau creneau = new Creneau(heureDebut, duree);
		creneaux[nbCreneaux] = creneau;
		nbCreneaux++ ;
	}
	
	//afficher
	public void afficher() {
		System.out.println(toString());
		System.out.println("Adresse : ");
		this.adresse.afficher();
		System.out.println("Créneaux :");
		for(Creneau creneau : creneaux) {
			creneau.afficher();
		}
		
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
