package tpLocationCycles;

import java.time.LocalDate;
import java.time.Period;

public abstract class Cycle {
	protected String marque;
	protected String modele;
	protected LocalDate dateAchat;
	
	//#### ---------CONSTRUCTOR
	public Cycle(String marque, String modele, LocalDate dateAchat) {
		this.marque = marque;
		this.modele = modele;
		this.dateAchat = dateAchat;

	}
	
	//#### ---------METHODS
	//AFFICHER
	public String afficher() {
		String affichage = toString();
		System.out.println(affichage);
		return affichage;
	}
	//toString METHOD
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(marque);
		builder.append(" " + modele);
		builder.append(" (" + yearsOld(dateAchat) + "an");
		if(yearsOld(dateAchat) > 1) {
			builder.append("s");
		}
		builder.append(")");
		return builder.toString();
	}
	//FONCTION REMPLISSAGE ESPACES
	public String fillSpaces(String str, double price) {
		int size = 65;
		int priceToFill = 0;
		if(price >=10) {
			priceToFill = 1;
		}else if(price >= 100) {
			priceToFill = 2;
		}
		
		int sizeToFill = size - str.length() - priceToFill;
		StringBuilder txt = new StringBuilder(); 
		for (int i = 0; i < sizeToFill; i++) {
			txt.append(" ");
		}
		return txt.toString();
	}
	
	//ANCIENETE DU VEHICULE
	public int yearsOld(LocalDate dateAchat) {
		   Period diff = Period.between(dateAchat, LocalDate.now());
		   int yearsOld = diff.getYears();
		   return yearsOld;
	}
	
	//GETTERS SETTERS
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public LocalDate getDateAchat() {
		return dateAchat;
	}
	public void setDateAchat(LocalDate dateAchat) {
		this.dateAchat = dateAchat;
	}
		
}
