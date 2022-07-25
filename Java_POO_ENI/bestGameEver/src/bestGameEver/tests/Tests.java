package bestGameEver.tests;

import bestGameEver.fonctions.Functions;
import bestGameEver.persos.heroes.Hero;
import bestGameEver.persos.heroes.HeroesList;


public class Tests {

	public static void main(String[] args) {
		
		Hero hero = Functions.selectHero(HeroesList.getHeroesList());
		hero.printHeroStats();
		hero.printHeroWeapons();
	}
}
