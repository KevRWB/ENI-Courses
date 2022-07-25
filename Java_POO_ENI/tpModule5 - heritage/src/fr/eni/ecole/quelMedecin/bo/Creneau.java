package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalTime;

public class Creneau {
	private LocalTime heureDebut;
	private int duree;
	private Medecin medecin;
	public Creneau(LocalTime heureDebut, int duree, Medecin medecin) {
		this.heureDebut = heureDebut;
		this.duree=duree;
		if (medecin!=null) {
			this.medecin = medecin;
			medecin.ajouterCreneau(heureDebut, duree);
		}
		}
	public Creneau(LocalTime heureDebut, int duree) {
		// TODO Auto-generated constructor stub
		this(heureDebut,duree,null);
	}
	public LocalTime getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(LocalTime heureDebut) {
		this.heureDebut = heureDebut;
	}

	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public Medecin getMedecin() {
		return medecin;
	}
	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	public void afficher() {
		//System.out.println(this.toString());
		LocalTime heureFin;
		heureFin=this.heureDebut.plusMinutes(duree);
		StringBuilder sb =new StringBuilder();
		sb.append(this.heureDebut);
		sb.append(" - ");
		sb.append(heureFin);
		sb.append(" (");
		sb.append(this.duree);
		sb.append(")");
		System.out.println(sb.toString());
	}
	@Override
	public String toString() {
		LocalTime heureFin;
		heureFin=this.heureDebut.plusMinutes(duree);
//		StringBuilder sb =new StringBuilder();
//		sb.append(this.heureDebut);
//		sb.append(" - ");
//		sb.append(heureFin);
//		return sb.toString();
		//equivalent
		return new StringBuilder()
				.append(this.heureDebut)
				.append(" - ")
				.append(heureFin)
				.append(" (")
				.append(duree)
				.append(" minutes)")
				.toString();
	}
	
	
}
