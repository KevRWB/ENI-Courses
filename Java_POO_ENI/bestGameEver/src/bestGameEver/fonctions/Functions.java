package bestGameEver.fonctions;

import java.util.Random;

//COMMONS FUNCTIONS FOR THE GAME
public class Functions {
	
	//FUNCTIONS ROLLE DICES
	public static int rollDice(int faces) {
		Random rnd = new Random();
		int randNb = rnd.nextInt(faces)+1;
		return randNb;
	}
	
}
