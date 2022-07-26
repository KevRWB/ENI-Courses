package bestGameEver.persos.heroes;

import java.util.ArrayList;

import bestGameEver.items.weapons.WeaponsList;

public class HeroesList {

	private static ArrayList<Hero> heroesList = new ArrayList<Hero>();
	// METHODS
	static public ArrayList<Hero> getHeroesList(){
		Hero zogzog = new Hero("ZogZog", 8, 4, 3, 3, 3, 20, 1, null);
		Hero clitorina = new Hero("Clitorina" , 6, 2, 7, 7, 7, 16, 7, null);
		
		//add weapons to heroes
		zogzog.setWeaponOne(WeaponsList.getWeaponsList().get(0));
		clitorina.setWeaponOne(WeaponsList.getWeaponsList().get(1));
		clitorina.setWeaponTwo(WeaponsList.getWeaponsList().get(1));
		
		//add heroes to list 
		heroesList.add(zogzog);
		heroesList.add(clitorina);
		
		return heroesList;
	}
	//fonction print available heroes
	public static void printHeroesList(ArrayList<Hero> list) {
		//Compteur de heros
		int count = 1;
		//print intro
		System.out.println("Voici les héros disponibles :");
		System.out.println("------------------------");
		//print list
		for(Hero hero : list) {
			System.out.println(count + "/");
			hero.printHeroStats();;
			hero.printHeroWeapons();
			count++;
		}	
	}
}
