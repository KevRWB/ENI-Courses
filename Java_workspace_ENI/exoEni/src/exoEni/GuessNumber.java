package exoEni;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

	static final int MIN = 0;
	static final int MAX = 1000;
	static final String PLUS = "C'est plus";
	static final String MOINS = "C'est moins";
	
	static int countTurns = 0;
	static int numToFind;
	static int playerNb;
	static int max = MAX;
	static int min = MIN;
	

	public static void main(String[] args) {
		
		turnOfGame();

	}
	
	//## METHODS ###
	
	// turn of game
	public static void turnOfGame() {
		
		numToFind = randomInt(MIN, MAX);
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Veuillez saisir un nombre entre " + min + " et " + max + ": ");
		playerNb = input.nextInt();
		
		while(playerNb != numToFind) {
			if(playerNb < numToFind) {
				System.out.println(PLUS + " de " + playerNb);
				min = playerNb;
			}else {
				System.out.println(MOINS + " de " + playerNb);
				max = playerNb;
			}
			countTurns ++;
			
			System.out.println("Le nombre est donc compris entre " + min + " et " + max);
			System.out.println("Quel nombre proposez-vous ?");
			playerNb = input.nextInt();
		}
		
		System.out.println("Bravo, le nombre à trouvé était bien le " + numToFind);
		System.out.println("Vous avez trouvé en " + (countTurns + 1) + " coups !");
		
		input.close();
	}
		
	// RANDOM INT
	public static int randomInt(int min, int max) {
		Random random = new Random();
		int randomNum = random.nextInt(max - min + 1) + min;
		return randomNum;
	}

}
