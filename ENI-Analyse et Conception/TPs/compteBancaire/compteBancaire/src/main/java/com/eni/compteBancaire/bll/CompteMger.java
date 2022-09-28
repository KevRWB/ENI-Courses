package com.eni.compteBancaire.bll;


import com.eni.compteBancaire.bo.Compte;

public class CompteMger {

	private Calculatrice calculatrice;
	
	
	/**
	 * Description : crediter permet d'ajouter un montant au solde du compte
	 * @param compte
	 * @param montant
	 * @throws BLLException : Levee d'une exception si montant négatif
	 */
	public void crediter(Compte compte, float montant) throws BLLException {
		if(montant < 0 ) {
			throw new BLLException("On ne peut créditer un montant négatif.");
		}
		float solde = calculatrice.additionner(compte.getSolde(), montant);		
		compte.setSolde(solde);
			
	}

	/**
	 * Description : crediter permet d'ajouter un montant au solde du compte
	 * @param compte
	 * @param montant
	 * @throws BLLException : Levee d'une exception si montant négatif
	 */
	public void debiter(Compte compte, float montant) throws BLLException {
		if(montant < 0 ) {
			throw new BLLException("On ne peut débiter un montant négatif.");
		}

		float solde = calculatrice.soustraire(compte.getSolde(), montant);
		
		if(solde< 0) {
			throw new BLLException("Le solde n'est pas suffisant pour réaliser ce débit.");
		}
		compte.setSolde(solde);

	}

	

	public Calculatrice getCalculatrice() {
		return calculatrice;
	}

	public void setCalculatrice(Calculatrice calculatrice) {
		this.calculatrice = calculatrice;
	}
	
	
}
