package fr.eni.ecole.voiture;

public class Voiture {
	//attributs d'instance
	private String couleur;
	private int immatriculation;
	//attributs de class - static
	private static int nbVoitures = 0;
	
	//Constructeur
	public Voiture(String couleur, int immatriculation) {
		this.couleur = couleur;
		this.immatriculation = immatriculation;
		//incrément du nombre de voiture à chaque creation d'instance
		Voiture.nbVoitures ++;
	}
	
	// -- METHODS
	
	//getter immat
	public int getNumImmat() {
		return this.immatriculation;
	}
	//getter couleur
	public String getColor() {
		return this.couleur;
	}
	//setter immat
	public void setNumImmat(int immat) {
		this.immatriculation = immat;
	}
	//setter couleur
	public void setColor(String color) {
		this.couleur = color;
	}
	//getter nombre de voitures crées
	public static int getNbVoitures() {
		return Voiture.nbVoitures;
	}
}
