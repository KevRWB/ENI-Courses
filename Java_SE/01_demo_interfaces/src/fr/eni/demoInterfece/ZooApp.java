package fr.eni.demoInterfece;

import java.util.ArrayList;
import java.util.List;

public class ZooApp {

	public static void main(String[] args) {
		
		Chat alfred = new Chat("Alfred");
		alfred.communiquer();
		
		ChauveSouris bruce = new ChauveSouris("Batman");
		bruce.communiquer();
		bruce.voler();
		
		Exocet e = new Exocet();
		e.voler();
		
		Nageant smith = e;
		smith.nager();
		
		List<Volant> animauxVolants = new ArrayList<>();
		animauxVolants.add(bruce);
		animauxVolants.add(e);	
		
	}

}
