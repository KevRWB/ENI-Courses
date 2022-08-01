package fr.eni.demoInterfece;

public class Mammifere {
private String nom;
	//Constructor
	public Mammifere(String nom) {
		this.nom = nom;
	}

	public void communiquer() {
		System.out.println("Mammifere " + getNom() + "Communiquer");
	}
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
