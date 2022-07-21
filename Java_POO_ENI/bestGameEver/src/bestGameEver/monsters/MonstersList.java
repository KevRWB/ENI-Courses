package bestGameEver.monsters;

import java.util.ArrayList;

import bestGameEver.heros.Hero;

public class MonstersList {
	
	private static ArrayList<Monster> monstersList = new ArrayList<Monster>();
	
	// METHODS
		static public ArrayList<Monster> getMonstersList(){
			Monster zombie = new Monster("Zombie", 2, 4, 10, 1);
			Monster wolf = new Monster("Loup", 5, 2, 7, 6);
			
			//add Monsters to list
			monstersList.add(zombie); 
			monstersList.add(wolf);
			//return
			return monstersList;
		}
}
