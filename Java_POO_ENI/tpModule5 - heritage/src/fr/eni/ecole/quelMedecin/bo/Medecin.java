package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalTime;

public class Medecin extends Personne{
	protected static final int MAX_CRENEAUX=15;
	protected Creneau[] creneaux= new Creneau[MAX_CRENEAUX];
	protected int nbCreneaux;
	public Medecin(String nom, String prenom, String numTel, Adresse adresse) {
		super(nom,prenom,numTel,adresse);
		nbCreneaux=0;
	}
	
	public Creneau[] getCreneaux() {
		return creneaux;
	}
	public void ajouterCreneau(LocalTime heureDebut, int duree) {
		Creneau creneau = new Creneau(heureDebut,duree);
		this.creneaux[this.nbCreneaux]=creneau;
		this.nbCreneaux++;

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		return builder.toString();
	}
	protected String afficheCreneaux() {
		StringBuilder sb = new StringBuilder();
		if (this.nbCreneaux==0)
		{
			sb.append("[Pas de créneau]");
		}
		else
		{
		sb.append("Créneaux :");
		sb.append(String.format("%n"));
			for(int i=0;i<nbCreneaux;i++)
			{
				sb.append(this.creneaux[i]);
				sb.append(String.format("%n"));
			}
		}
		return sb.toString();
	}
	



}
