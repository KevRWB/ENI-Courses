package bestGameEver.tests;

import bestGameEver.Potions.Potion;
import bestGameEver.Potions.PotionsFunctions;
import bestGameEver.Potions.PotionsList;

public class Tests {

	public static void main(String[] args) {
		
		Potion potion = PotionsList.getPotionsList().get(0);
		System.out.println(PotionsFunctions.toString(potion));

	}

}
