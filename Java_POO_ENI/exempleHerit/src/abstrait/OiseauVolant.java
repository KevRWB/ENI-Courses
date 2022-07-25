package abstrait;

public class OiseauVolant extends Oiseau implements Voler {

	public OiseauVolant(String nom) {
		super(nom);
	}
	
	public void voler() {
		System.out.println("Je vole comme un oiseau");
	}
	
	public void getAile() {
		System.out.println(AILE);
	}
	
}
