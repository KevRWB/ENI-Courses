package fr.eni.demoInterfece;

public class ZooApp {

	public static void main(String[] args) {
		
		Chat alfred = new Chat("Alfred");
		alfred.communiquer();
		
		ChauveSouris bruce = new ChauveSouris("Batamn");
		bruce.communiquer();
		bruce.voler();
		
		Exocet e = new Exocet();
		e.voler();
		
		Nageant smith = e;
		smith.nager();
		
		
	}

}
