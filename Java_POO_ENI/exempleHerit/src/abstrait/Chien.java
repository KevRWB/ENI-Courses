package abstrait;

public class Chien extends AnimalDomestique {
		
	public Chien(String nom) {
		super(nom);
	}

	public void aboyer() {
		System.out.println("Whouaf");
	}

	@Override
	public void communiquer() {
		aboyer();	
	}
}
