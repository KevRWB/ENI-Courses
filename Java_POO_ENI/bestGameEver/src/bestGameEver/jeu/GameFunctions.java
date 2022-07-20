package bestGameEver.jeu;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import bestGameEver.heros.Hero;
import bestGameEver.monsters.Monster;

public class GameFunctions {

	//--METHODS
		//Monster turn
		public static void monsterTurn(Monster monster, Hero hero, int facesDice) {
			System.out.println("Tour du " + monster.getName());
			int ptsAttack = monsterAttack(rollDice(facesDice), monster);
			heroRemoveLife(ptsAttack, hero);
		}
	//Hero turn
			public static void heroTurn(Monster monster, Hero hero, int facesDice) {
				System.out.println("Tour de " + hero.getName());
				int ptsAttack = heroAttack(rollDice(facesDice), hero);
				monsterRemoveLife(ptsAttack, monster);
			}
	
		//Fonction roll dice and print dice result
		public static int rollDice(int faces) {
			Random rnd = new Random();
			int randNb = rnd.nextInt(faces)+1;
			return randNb;
		}
		
		//fonction hero attack
		public static int heroAttack(int resultDe, Hero hero) {
			int ptsAttack;
			ptsAttack = (resultDe + hero.getAtt());
			//print results
			System.out.println("Jet du hero : " + resultDe);
			System.out.println("Avec votre attaque de "+ hero.getAtt() + ", vous infligez " + ptsAttack + " points de dégâts au monstre");
			//return statement
			return ptsAttack;
		}
		//foncion monster attack
		public static int monsterAttack(int resultDe, Monster monster) {
			int ptsAttaque;
			ptsAttaque = (resultDe + monster.getAtt());
			//print results
			System.out.println("Jet du monstre : " + resultDe);
			System.out.println("Avec son attaque de "+ monster.getAtt() + ", il vous fait " + ptsAttaque + " points de dégâts");
			//return statement
			return ptsAttaque;
		}
		//fonction remove life to hero
		public static void heroRemoveLife(int ptsAttack, Hero hero) {		
			int pvLost = ptsAttack - hero.getDef();
			//test if pv lost is less or equal to zero -> If true -> pv lost = 0 
			if(pvLost <= 0) { pvLost = 0;}
			//substract pv lost to hero's life
			hero.setLife(hero.getLife() - pvLost);
			//print results
			System.out.println("Votre défense : " + hero.getDef() + ", vous perdez " + pvLost + " PV");
			if(hero.getLife() > 0) {//check if hero's life is > 0
			System.out.println("Il vous reste " + hero.getLife() + " PV");
			}
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
			}
		}
		//fonction print available heroes
		public static void printHeroesList(ArrayList<Hero> list) {
			System.out.println("Voici les héros disponibles :");
			System.out.println("------------------------");
			for(Hero hero : list) {
				printHero(hero);
			}
		}
		//Fonction select hero
		public static Hero selectHero(ArrayList<Hero> list) {
			System.out.println("Choisissez votre héro (numéro): ");
			Scanner input = new Scanner(System.in);
			int select = input.nextInt();
			Hero heroSelected = list.get(select -1);
			return heroSelected;
		}
		//fonction print hero
		public static void printHero(Hero hero) {
			System.out.println("--------------------");
			System.out.printf("%d : %s%n", hero.getIndex(), hero.getName());
			System.out.println("Attaque : " + hero.getAtt());
			System.out.println("Défense : " + hero.getDef());
			System.out.println("Points de vie : " + hero.getLife());
			System.out.println("-------------------");
		}
		
}
