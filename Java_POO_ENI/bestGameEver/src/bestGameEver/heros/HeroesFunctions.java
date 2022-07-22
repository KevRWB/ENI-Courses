package bestGameEver.heros;

import java.util.ArrayList;
import java.util.Scanner;

import bestGameEver.jeu.BestGameEver;
import bestGameEver.jeu.FightFunctions;
import bestGameEver.monsters.Monster;
import bestGameEver.monsters.MonstersFunctions;

public class HeroesFunctions {
	
	//Hero turn
	public static void heroTurn(Monster monster, Hero hero, int facesDice) {
		System.out.println("Tour de " + hero.getName());
		//Lancer de dés
		int dice = FightFunctions.rollDice(facesDice);
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
	//fonction print hero
	public static void printHero(Hero hero) {
		System.out.println("--------------------");
		System.out.printf("%d : %s%n", hero.getIndex(), hero.getName());
		System.out.println("Attaque : " + hero.getAtt());
		System.out.println("Défense : " + hero.getDef());
		System.out.println("Points de vie : " + hero.getLife());
		System.out.println("Initiative : " + hero.getInitiative());
		System.out.println("-------------------");
	}
	
	//toString

	public static String toString(Hero hero) {
		StringBuilder builder = new StringBuilder();
		builder.append("Hero [index=");
		builder.append(hero.getIndex());
		builder.append(", name=");
		builder.append(hero.getName());
		builder.append(", att=");
		builder.append(hero.getAtt());
		builder.append(", def=");
		builder.append(hero.getDef());
		builder.append(", life=");
		builder.append(hero.getLife());
		builder.append(", initiative=");
		builder.append(hero.getInitiative());
		builder.append("]");
		return builder.toString();
	}
}
