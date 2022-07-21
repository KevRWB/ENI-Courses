package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalTime;

public class MedecinGeneraliste {
	private String nom;
	private String prenom;
	private String tel;
	private Adresse adresse;
	private Creneau[] creneaux = new Creneau[15];
	private int nbCreneaux;
	private static int prixConsult;
	
	// constructeur
	public MedecinGeneraliste(String nom, String prenom, String tel, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.adresse = adresse;
		nbCreneaux = 0;
	}
	
	//METHODS
	public void ajouterCreneau(LocalTime heureDebut, int duree) {
		Creneau C1 = new Creneau(heureDebut, duree);
		this.creneaux[nbCreneaux] = C1;
		this.nbCreneaux ++;
	}
	//Getter numero téléphone
	public String getNumeroDeTelephone() {
		return this.tel;
	}

	//Setter numéro téléphone
	public void setNumeroDeTelephone(String num) {
		this.tel = num;
	}
	//Getter nom
	public String getNom() {
		return this.nom;
	}
	//Setter static tarif
	public static void setTarif(int tarif) {
		MedecinGeneraliste.prixConsult = tarif;
	}
	
	//affichage
	public void afficher() {
		System.out.println(this.nom.toUpperCase() + " " + this.prenom);
		System.out.println("Téléphone : " + this.tel);
		System.out.println("Tarif : " + MedecinGeneraliste.prixConsult + "€");
		this.adresse.afficher();
	
		for(int i = 0; i < this.nbCreneaux; i++) {
			this.creneaux[i].afficher();
		}
	}
}
