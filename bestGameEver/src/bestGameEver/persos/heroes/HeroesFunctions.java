package bestGameEver.persos.heroes;

import java.util.ArrayList;

import bestGameEver.fonctions.FightFunctions;
import bestGameEver.fonctions.Functions;
import bestGameEver.jeu.BestGameEver;
import bestGameEver.persos.monsters.Monster;
import bestGameEver.persos.monsters.MonstersFunctions;

public class HeroesFunctions {
	
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
