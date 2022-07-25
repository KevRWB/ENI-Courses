package abstrait;

public class ChauveSouris extends AnimalDomestique implements Voler{
	//CONSTRUCTOR
	public ChauveSouris(String nom) {
		super(nom);
	}
	
	public void grincer() {
		System.out.println("Ultra-sons");
	}
	@Override
	public void communiquer() {
		grincer();
		
	}
	//Methode implémenter
	public void voler() {
		System.out.println("Je vole comme une chauve souris");
	}
	
	public void getAile() {
		System.out.println(AILE);
	}
}
