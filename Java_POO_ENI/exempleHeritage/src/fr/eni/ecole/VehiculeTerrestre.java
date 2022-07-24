package fr.eni.ecole;

public class VehiculeTerrestre extends Vehicule {
	
	protected int numOfWheels;

	public VehiculeTerrestre(String nom, int length, int width, int height, int weight, String color, int numOfWheels) {
		super(nom, length, width, height, weight, color);
		this.numOfWheels = numOfWheels;
	}
	
	
	//METHODS
	@Override
	public void goTravel() {
		System.out.println("C'est parti, je pars en voyage avec mon véhicule terrestre !");
	}

}
