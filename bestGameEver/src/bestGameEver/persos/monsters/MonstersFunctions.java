package bestGameEver.persos.monsters;

import java.util.ArrayList;
import java.util.Random;

import bestGameEver.fonctions.FightFunctions;
import bestGameEver.fonctions.Functions;
import bestGameEver.persos.heroes.Hero;
import bestGameEver.persos.heroes.HeroesFunctions;

public class MonstersFunctions {
	//select random monster
	public static Monster selectRdMonster(ArrayList<Monster> list) {
		Random rnd = new Random();
		int nbMonsters = list.size();
		int numMonster = rnd.nextInt(nbMonsters);
		return list.get(numMonster);
	}
	//fonction print a monster
	public static void printMonster(Monster monster) {
		System.out.println("MONSTRES :");	
		monster.printMonsterStats();
		monster.printMonsterWeapons();
	}
	//fonction print every monsters
	public static void printMonsters() {
		System.out.println("MONSTRES :");
		for(Monster monster : MonstersList.getMonstersList()) {
			monster.printMonsterStats();
			monster.printMonsterWeapons();
		}
	}	
}
