package com.eni.compteBancaire.bo;

public class Compte {
	
	private int noCompte;
	
	private float solde;

	public Compte(int noCompte) {
		super();
		this.noCompte = noCompte;
	}

	public int getNoCompte() {
		return noCompte;
	}

	public float getSolde() {
		return solde;
	}

	public void setNoCompte(int noCompte) {
		this.noCompte = noCompte;
	}

	public void setSolde(float montant) {
		this.solde = montant;
	}

	@Override
	public String toString() {
		return "Compte [noCompte=" + noCompte + ", montant=" + solde + "]";
	}
	
	

}
