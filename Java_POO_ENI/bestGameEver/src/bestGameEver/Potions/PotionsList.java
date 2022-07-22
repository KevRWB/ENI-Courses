package bestGameEver.Potions;

import java.util.ArrayList;

public class PotionsList {
	//List of potions in Array list
	private static ArrayList<Potion> potionsList = new ArrayList<Potion>();
	
	public static  ArrayList<Potion> getPotionsList () {
		Potion lifePotion = new Potion(1, "Potion de vie", 5, 0, 0, "Cette potion vous rends 5 points de vie");
		Potion AttPotion = new Potion(2, "Potion d'attaque", 0, 5, 0, "Cette potion vous ajoute un bonus de 5 poitns d'attaque");
		Potion DefPotion = new Potion(3, "Potion de défense", 0, 0, 5, "Cette potion vous ajoute un bonus de  5 points de défense");
		//add potions in ArrayList
		potionsList.add(lifePotion);
		potionsList.add(AttPotion);
		potionsList.add(DefPotion);
		
		return potionsList;
	}

}
