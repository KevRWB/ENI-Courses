package bestGameEver.items.potions;

import java.util.ArrayList;

public class PotionsList {
	//List of potions in Array list
	private static ArrayList<Potion> potionsList = new ArrayList<Potion>();
	
	public static  ArrayList<Potion> getPotionsList () {
		Potion lifePotion = new Potion("Potion de vie", "Cette potion vous rends 5 points de vie", null,20,300, 5, 0, 0);
		Potion AttPotion = new Potion("Potion d'attaque", "Cette potion vous ajoute un bonus de 5 points d'attaque", null, 20, 300, 0, 5, 0);
		Potion DefPotion = new Potion("Potion de défense",  "Cette potion vous ajoute un bonus de  5 points de défense",null, 20, 300, 0, 0, 5);
		//add potions in ArrayList
		potionsList.add(lifePotion);
		potionsList.add(AttPotion);
		potionsList.add(DefPotion);
		
		return potionsList;
	}

}
