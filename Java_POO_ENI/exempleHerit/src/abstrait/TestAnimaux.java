package abstrait;

public class TestAnimaux {

	public static void main(String[] args) {
		
		AnimalDomestique[] animauxDomestique = new AnimalDomestique[4];
		
		animauxDomestique[0] = new Chat("Sylvestre");
		animauxDomestique[1] = new ChauveSouris("Mimi");
		animauxDomestique[2] = new Chien("Hector");
		animauxDomestique[3] = new OiseauVolant("Titi");
		
		for (int i = 0; i < animauxDomestique.length; i++) {
			animauxDomestique[i].communiquer();
			
			if(animauxDomestique[i] instanceof Voler) {
				((Voler) animauxDomestique[i]).voler();
				((Voler) animauxDomestique[i]).getAile();
			}
		}
		
		
	}

}
