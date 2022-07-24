package fr.eni.ecole;

public class Vehicule {
	protected String nom;
	protected int length;
	protected int width;
	protected int height;
	protected int weight;
	protected String color;
	
	//Constructor
	public Vehicule(String nom, int length, int width, int height, int weight, String color) {
		super();
		this.nom = nom;
		this.length = length;
		this.width = width;
		this.height = height;
		this.weight = weight;
		this.color = color;
	}
	
	//METHODS
	public void goTravel() {
		System.out.println("C'est parti, je pars en voyage avec mon véhicule");
	}
	
	
}
