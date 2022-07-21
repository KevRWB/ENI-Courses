package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalTime;
public class Creneau {
	private LocalTime heureDebut;
	private int dureeCreneauMn;
	private MedecinGeneraliste medecin;
	
	public Creneau(LocalTime heureDebut, int dureeCreneauMn, MedecinGeneraliste medecin) {
		super();
		this.heureDebut = heureDebut;
		this.dureeCreneauMn = dureeCreneauMn;
		this.medecin = medecin;
		medecin.ajouterCreneau(heureDebut, dureeCreneauMn);
	}
	
	
	public Creneau(LocalTime heureDebut, int dureeCreneauMn) {
		super();
		this.heureDebut = heureDebut;
		this.dureeCreneauMn = dureeCreneauMn;
		
	}


	//AFFICHER
	public void afficher() {
		System.out.println(this.getHeureDebut() + " " + this.getHeureDebut().plusMinutes(15) + " (" + this.getDureeCreneauMn() + " mintutes)" );
	}
	
	//GETTER SETTER
	public LocalTime getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(LocalTime heureDebut) {
		this.heureDebut = heureDebut;
	}

	public int getDureeCreneauMn() {
		return dureeCreneauMn;
	}

	public void setDureeCreneauMn(int dureeCreneauMn) {
		this.dureeCreneauMn = dureeCreneauMn;
	}

	public MedecinGeneraliste getMedecin() {
		return medecin;
	}

	public void setMedecin(MedecinGeneraliste medecin) {
		this.medecin = medecin;
	}
	
	
	
	
	
}
