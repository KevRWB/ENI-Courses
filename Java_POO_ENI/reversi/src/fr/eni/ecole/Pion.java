package fr.eni.ecole;

public enum Pion {
	LIBRE,
	BLANC,
	NOIR;
	
	private int nbPions = 2;
	
	public int getnbPions() {
		return nbPions;
	}
	
	//fonction get symbole
	public char getSymbole() {
		switch(this) {
		case BLANC : 
			return '0';		
		case NOIR : 
			return '●';
		default : return '.';
		}
	}
	//Method AUTRE PION
	public Pion autrePion() {
		switch(this){
		case BLANC : return NOIR;
		case NOIR : return BLANC;
		default : return LIBRE;
		}
	}
	//Method GAGNE
	public void gagne(int nbPionsChange) {
		nbPions += nbPionsChange;
		this.autrePion().nbPions -= nbPionsChange;
	}

	public int getNbPions() {
		return nbPions;
	}

	public void setNbPions(int nbPions) {
		this.nbPions = nbPions;
	}
	
}
