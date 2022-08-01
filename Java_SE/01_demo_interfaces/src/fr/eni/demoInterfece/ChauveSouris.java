package fr.eni.demoInterfece;

public class ChauveSouris extends Mammifere implements Volant{

	public ChauveSouris(String nom) {
		super(nom);
	}
	
	public void communiquer() {
		System.out.println("Je suis Batman");
	}
	

	@Override
	public void voler() {
		System.out.println("FLAP FLAP");
	}
	
}
