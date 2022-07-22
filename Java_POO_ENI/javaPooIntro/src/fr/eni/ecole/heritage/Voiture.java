package fr.eni.ecole.heritage;

public class Voiture extends Vehicule {
	
	protected final int NBROUES = 4;
	protected int immatriculation;
	//CONSTRUCTEUR
	public Voiture(String nom, String couleur, int immatriculation) {
		super(nom, couleur);
		this.immatriculation = immatriculation;
	}
	
	
	
	
}
