package bestGameEver.persos.heroes;

import java.util.ArrayList;
import java.util.Scanner;

import bestGameEver.fonctions.FightFunctions;
import bestGameEver.fonctions.Functions;
import bestGameEver.jeu.BestGameEver;
import bestGameEver.persos.monsters.Monster;
import bestGameEver.persos.monsters.MonstersFunctions;
import bestGameEver.persos.monsters.MonstersList;

public class HeroesFunctions {
	
	//Hero turn
	public static void heroTurn(Monster monster, Hero hero, int facesDice) {
		System.out.println("Tour de " + hero.getName());
		//Lancer de dés
		int dice = Functions.rollDice(facesDice);
		//Test si coup critique
		if(FightFunctions.isCritique(dice, facesDice)) {
			System.out.println("COUP CRITIQUE !");
			dice = dice + 2;
		}
		//Attack 
		int ptsAttack = heroAttack(dice, hero);
		MonstersFunctions.monsterRemoveLife(ptsAttack, monster);
	}
	
	//fonction hero attack
	public static int heroAttack(int resultDe, Hero hero) {
		int ptsAttack;
		ptsAttack = (resultDe + hero.getAtt());
		//print results
		System.out.println("Jet du hero : " + resultDe);
		System.out.println("Avec votre attaque de "+ hero.getAtt() + ", vous infligez " + ptsAttack + " points de dégâts au monstre");
		System.out.println();
		//return statement
		return ptsAttack;
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
		System.out.println();
		}
	}
	//Fonction select hero
	public static Hero selectHero(ArrayList<Hero> list) {
		System.out.println("Choisissez votre héros (numéro): ");
		int select = BestGameEver.scan.nextInt();
		Hero heroSelected = list.get(select -1);
	
		return heroSelected;
	}
	////affichage
	//fonction print a hero
	public static void printHero(Hero hero) {
		System.out.println("HEROS :");	
		hero.printHeroStats();
		hero.printHeroWeapons();
	}
	//fonction print every heroes
		public static void printHeroes() {
			System.out.println("HEROS :");
			for(Hero hero : HeroesList.getHeroesList()) {
				hero.printHeroStats();
				hero.printHeroWeapons();
			}
		}
	
}
