package bestGameEver.persos.monsters;

import java.util.ArrayList;
import java.util.Random;

import bestGameEver.fonctions.FightFunctions;
import bestGameEver.fonctions.Functions;
import bestGameEver.persos.heroes.Hero;
import bestGameEver.persos.heroes.HeroesFunctions;

public class MonstersFunctions {
	//Monster turn
	public static void monsterTurn(Monster monster, Hero hero, int facesDice) {
		System.out.println("Tour du " + monster.getName());
		//Lancer de dés
		int dice = Functions.rollDice(facesDice);
		//Test si coup critique
		if(FightFunctions.isCritique(dice, facesDice)) {
			System.out.println("COUP CRITIQUE !");
			dice = dice + 2;
		}
		//Attack 
		int ptsAttack = monsterAttack(Functions.rollDice(facesDice), monster);
		HeroesFunctions.heroRemoveLife(ptsAttack, hero);
	}
	
	//foncion monster attack
	public static int monsterAttack(int resultDe, Monster monster) {
		int ptsAttaque;
		ptsAttaque = (resultDe + monster.getAtt());
		//print results
		System.out.println("Jet du monstre : " + resultDe);
		System.out.println("Avec son attaque de "+ monster.getAtt() + ", il vous fait " + ptsAttaque + " points de dégâts");
		System.out.println();
		//return statement
		return ptsAttaque;
	}
	
	//fonction remove life to monster
	public static void monsterRemoveLife(int ptsAttack, Monster monster) {		
		int pvLost = ptsAttack - monster.getDef();
		//test if pv lost is less or equal to zero -> If true -> pv lost = 0 
		if(pvLost <= 0) { pvLost = 0;}
		//substract pv lost to hero's life
		monster.setLife(monster.getLife() - pvLost);
		//print results
		System.out.println("Défense du monstre : " + monster.getDef() + ", il perd " + pvLost + " PV");
		if(monster.getLife() > 0) {
			System.out.println("Il reste " + monster.getLife() + " PV au monstre");
			System.out.println();
		}
	}
	
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
