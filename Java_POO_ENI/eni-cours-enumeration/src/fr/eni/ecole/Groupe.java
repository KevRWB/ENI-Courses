package fr.eni.ecole;

public enum Groupe {
	GARE,
	SERVICE_PUBLIC,
	MAUVE, 
	BLEU, 
	VIOLET, 
	ORANGE,
	ROUGE,
	JAUNE,
	VERT,
	MARINE; // point virgule pour terminer les éléments de l'énumération
	
	//CONSTRUCTEUR PAR DEFAULT MODIFIER
	private String nom;
	private Groupe() {
		this.nom = this.name().toLowerCase();
	}
	
	//init tableau de propriétés
	private String[] prop = new String[4];
	//init compte du nombre de propriétés
	private int nbProp = 0;
	//Method qui permet d'ajouter une propriété à l'indice nbProp en cours 
	public void ajouter(String prop) {
		this.prop[nbProp] = prop; //this -> prop de Class(enum)
		nbProp++;
	}
	
	//GETTER - SETTER
	public String[] getProp() {
		return prop;
	}
	public int getNbProp() {
		return nbProp;
	}	
}
