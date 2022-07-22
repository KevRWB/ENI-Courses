package bestGameEver.monsters;

import java.util.ArrayList;
import java.util.Random;

import bestGameEver.heros.Hero;
import bestGameEver.heros.HeroesFunctions;
import bestGameEver.jeu.FightFunctions;

public class MonstersFunctions {
	//Monster turn
	public static void monsterTurn(Monster monster, Hero hero, int facesDice) {
		System.out.println("Tour du " + monster.getName());
		//Lancer de dés
		int dice = FightFunctions.rollDice(facesDice);
		//Test si coup critique
		if(FightFunctions.isCritique(dice, facesDice)) {
			System.out.println("COUP CRITIQUE !");
			dice = dice + 2;
		}
		//Attack 
		int ptsAttack = monsterAttack(FightFunctions.rollDice(facesDice), monster);
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
	//fonction print monster
		public static void printMonster(Monster monster) {
			System.out.println("--------------------");
			System.out.println(monster.getName());
			System.out.println("Attaque : " + monster.getAtt());
			System.out.println("Défense : " + monster.getDef());
			System.out.println("Points de vie : " + monster.getLife());
			System.out.println("Initiative : " + monster.getInitiative());
			System.out.println("-------------------");
		}
	//Print ToString
		public static String toString(Monster monster) {
			StringBuilder builder = new StringBuilder();
			builder.append("Monster [index=");
			builder.append(monster.getIndex());
			builder.append(", name=");
			builder.append(monster.getName());
			builder.append(", att=");
			builder.append(monster.getAtt());
			builder.append(", def=");
			builder.append(monster.getDef());
			builder.append(", life=");
			builder.append(monster.getLife());
			builder.append(", initiative=");
			builder.append(monster.getInitiative());
			builder.append("]");
			return builder.toString();
		}
}
