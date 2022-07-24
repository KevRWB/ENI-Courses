package bestGameEver.tests;

import bestGameEver.items.potions.Potion;
import bestGameEver.items.potions.PotionsFunctions;
import bestGameEver.items.potions.PotionsList;

public class Tests {

	public static void main(String[] args) {
		
		Potion potion = PotionsList.getPotionsList().get(0);
		System.out.println(potion.getShortDescription());

	}

}
