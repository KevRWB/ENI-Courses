package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalTime;

public class Creneau {
	private LocalTime heureDebut;
	private int duree;
	private MedecinGeneraliste medecin;
	
	//CONSTRUCTORS
	public Creneau(LocalTime heureDebut, int duree, MedecinGeneraliste medecin) {
		super();
		this.heureDebut = heureDebut;
		this.duree = duree;
		this.medecin = medecin;
		medecin.ajouterCreneau(heureDebut, duree);
	}
	public Creneau(LocalTime heureDebut, int duree) {
		super();
		this.heureDebut = heureDebut;
		this.duree = duree;
	}	
	//METHODS
	
	//Afficher creneau
	public void afficher() {
		System.out.print(heureDebut + " - ");
		System.out.print(heureDebut.plusMinutes(duree) + " ");
		System.out.print("(" + duree + " minutes)");
		System.out.println();
		
		
	}

	public MedecinGeneraliste getMedecin() {
		return medecin;
	}
	
	//GETTER SETTER
	
}
