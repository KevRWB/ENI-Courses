package tpLocationCycles;

import java.time.LocalDate;

public abstract class Cycle {
	protected String marque;
	protected String modele;
	protected LocalDate dateAchat;
	protected int prixLoc;
	
	//CONSTRUCTOR
	public Cycle(String marque, String modele, LocalDate dateAchat, int prixLoc) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.dateAchat = dateAchat;
		this.prixLoc = prixLoc;
	}
	//METHODS
	
	
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
