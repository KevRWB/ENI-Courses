package bestGameEver.heros;

import java.util.ArrayList;

public class HeroesList {

	private static ArrayList<Hero> heroesList = new ArrayList<Hero>();
	// METHODS
	static public ArrayList<Hero> getHeroesList(){
		Hero ragnar = new Hero("Ragnar", 6, 4, 20, 5);
		Hero zogzog = new Hero("ZogZog", 7, 3, 20, 1);
		Hero clitorina = new Hero("Clitorina" , 8, 2, 20, 7);
		
		//add heroes to list
		heroesList.add(ragnar); 
		heroesList.add(zogzog);
		heroesList.add(clitorina);
		
		return heroesList;
	}
	//fonction print available heroes
			public static void printHeroesList(ArrayList<Hero> list) {
				System.out.println("Voici les héros disponibles :");
				System.out.println("------------------------");
				for(Hero hero : list) {
					Hero.printHero(hero);
				}
			}

}
