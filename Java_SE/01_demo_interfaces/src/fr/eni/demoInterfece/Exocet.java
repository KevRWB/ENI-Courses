package fr.eni.demoInterfece;

public class Exocet implements Volant, Nageant{

	private String nom;
	
	
	public void nager() {
	System.out.println("Plouf");
	}


	@Override
	public void voler() {
		
	}

	
}
