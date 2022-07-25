package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalTime;

public class MedecinGeneraliste extends Personne{
	
	protected static int TARIF = 25;
	protected Creneau[] creneaux = new Creneau[15];
	protected int nbCreneaux = 0;
	//CONSTRUCTOR
	public MedecinGeneraliste(String nom, String prenom, String numTel, Adresse adresse) {
		super(nom, prenom, numTel, adresse);
	
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
		return TARIF;
	}
	public static void setTarif(int tarif) {
		MedecinGeneraliste.TARIF = tarif;
	}
	public String getNom() {
		return nom;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("Tarif : " + TARIF + "€");
		
		return builder.toString();
	}

}
