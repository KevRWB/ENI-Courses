package bestGameEver.persos.monsters;

import java.util.ArrayList;

import bestGameEver.items.weapons.WeaponsList;
import bestGameEver.persos.heroes.Hero;

public class MonstersList {
	
	private static ArrayList<Monster> monstersList = new ArrayList<Monster>();
	
	// METHODS
	static public ArrayList<Monster> getMonstersList(){
		Monster zombie = new Monster(1,"Zombie", 4, 6, 1, 1, 1, 20, 1, null);
		Monster wolf = new Monster(2,"Loup", 6, 2,4, 7, 4, 12, 6, null);
		Monster pirate = new Monster(3,"pirate", 4, 4, 5, 5, 5,  15, 5, null);
		
		//add weapons to monsters
		pirate.setWeaponOne(WeaponsList.getWeaponsList().get(1));
		
		//add Monsters to list
		monstersList.add(zombie); 
		monstersList.add(wolf);
		monstersList.add(pirate);
		//return
		return monstersList;
	}
	
	//PRINT EVERY MONSTER
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
