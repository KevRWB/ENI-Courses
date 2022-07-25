package abstrait;

public class Chat extends AnimalDomestique {
	
	public Chat(String nom) {
		super(nom);
	}

	public void miauler() {
		System.out.println("Miaou");
	}

	@Override
	public void communiquer() {
		miauler();
		
	}
}
