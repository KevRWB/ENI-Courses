package exoEni;

import java.util.Random;

public class RandomPPImpair {
	
	static final int MIN_NUMBER = 0;
	static final int MAX_NUMBER = 1000;
	static int nbUn, nbDeux, nbTrois;
	static int countTries = 0;
	
	//##### MAIN #####
	public static void main(String[] args) {
		
		testAndCountTries();

	}
	
	//###  METHODS ###
	
	//Main loop of test and count tentatives
	public static void testAndCountTries() {
		boolean testPatternEEOdd = false;
		
		while (testPatternEEOdd == false) {
			threeRandomInt(MIN_NUMBER, MAX_NUMBER);
			countTries ++;
			testPatternEEOdd = testPatternEEOdd(nbUn, nbDeux, nbTrois);
		}
		
		System.out.println("Il a fallu " + countTries + " essais pour trouver la bonne combinaison : " + nbUn + " - " + nbDeux + " - " + nbTrois);
		
	}
	
	//Test if pattern for numbers is Even - Even - Odd
	public static boolean testPatternEEOdd(int numUn, int numDeux, int numTrois) {
		if(numUn%2 == 0 && numDeux%2 == 0 && numTrois%2 != 0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	// Generate random int between min and max
	public static int randomInt(int min, int max) {
		Random random = new Random();
		 return random.nextInt(max - min + 1) + min ;
		 
	
		
	}
	// Use randomInt on the three numbers to test
	public static void threeRandomInt(int min, int max) {
		nbUn = randomInt(min, max);
		nbDeux = randomInt(min, max);
		nbTrois = randomInt(min, max);
	}
	
	
	
	

}
