package bestGameEver.fonctions;

import java.util.Random;
import java.util.Scanner;

import bestGameEver.jeu.BestGameEver;
import bestGameEver.persos.Perso;
import bestGameEver.persos.heroes.Hero;
import bestGameEver.persos.heroes.HeroesFunctions;
import bestGameEver.persos.monsters.Monster;
import bestGameEver.persos.monsters.MonstersFunctions;

public class FightFunctions {

	//---METHODS
	//fonction number of attack points
	public int ptsAtt(Perso perso, int dice) {
		return perso.getAtt() + Functions.rollDice(dice);
	}
	
	//fonction remove life to perso
	public static void persoRemoveLife(int ptsAttack, Perso perso) {	
			int pvLost;
			//test if defense superior to attack points
			if(ptsAttack < perso.getDef()) pvLost = 0; 		
			pvLost = ptsAttack - perso.getDef();		
			//substract pv lost to hero's life
			perso.setLife(perso.getLife() - pvLost);
			//print results
			System.out.println("Défense : " + perso.getDef() + ", " + pvLost + " PV perdus");
			if(perso.getLife() > 0) {//check if hero's life is > 0
			System.out.println(perso.getLife() + " PV restants");
			System.out.println();
			}
		}

	//Test if normal touch touch
	public static boolean testNormalTouch(Perso attacker, int attackDice, Perso defender, int defendDice) {
		boolean touch = false;
		if (attacker instanceof Hero) {
			if((attacker.getAbility() + attackDice) >= (defender.getDodge() + defendDice)) touch = true;
		}
		if (attacker instanceof Monster) {
			if((attacker.getAbility() + attackDice) > (defender.getDodge() + defendDice)) touch = true;
		}
		return touch;
	}
	//Test if normal touch touch
		public static boolean testSpeedTouch(Perso attacker, int attackDice, Perso defender, int defendDice) {
			boolean touch = false;
			if (attacker instanceof Hero) {
				if((attacker.getSpeed() + attackDice) >= (defender.getSpeed() + defendDice)) touch = true;
			}
			if (attacker instanceof Monster) {
				if((attacker.getSpeed() + attackDice) > (defender.getSpeed() + defendDice)) touch = true;
			}
			return touch;
		}
	//###############################################
		//###############################################
		//fonction check initiative
		public static boolean heroHasInit(Hero hero, Monster monster) {
			if(hero.getInitiative() >= monster.getInitiative()) {
				return true;
			}else return false;
		}
		//fonction print init
		public static void printInit(boolean heroHasInit) {
			if(heroHasInit) {
				System.out.println("Vous avez l'initiative pour ce combat, vous aller donc lancer la première attaque !");
			}else System.out.println("L'ennemi a l'initiative pour ce combat. Il va donc lancer la première attaque !");
		}	
		//Fonction coup critique
		public static boolean isCritique(int dice, int faces) {
			Random rd = new Random();
			int rand = rd.nextInt(faces) +1;
			if(rand == dice) {
				return true;
			} else return false;
		}
				
}
