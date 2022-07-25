package abstrait;

public class Oiseau extends AnimalDomestique {
		
	public Oiseau(String nom) {
		super(nom);
	}

	public void piailler() {
		System.out.println("Piou piou");
	}

	@Override
	public void communiquer() {
		piailler();
		
	}
	

}

