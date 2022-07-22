package bestGameEver.monsters;

import java.util.ArrayList;

public class MonstersList {
	
	private static ArrayList<Monster> monstersList = new ArrayList<Monster>();
	
	// METHODS
		static public ArrayList<Monster> getMonstersList(){
			Monster zombie = new Monster(1,"Zombie", 2, 4, 10, 1);
			Monster wolf = new Monster(2,"Loup", 5, 2, 7, 6);
			Monster pirate = new Monster(3,"pirate", 4, 3, 8, 3);
			
			//add Monsters to list
			monstersList.add(zombie); 
			monstersList.add(wolf);
			monstersList.add(pirate);
			//return
			return monstersList;
		}
}
