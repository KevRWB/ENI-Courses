package bestGameEver.jeu;
import java.util.ArrayList;
import java.util.Random;

import bestGameEver.heros.*;
import bestGameEver.monsters.*;

public class BestGameEver {
	
	private static final int D6 = 6;
	
	public static void main(String[] args) {
		
		//create heroes
		Hero ragnar = new Hero(1,"Ragnar", 6, 4, 20, 5);
		Hero zogzog = new Hero(2,"ZogZog", 7, 3, 20, 3);
		//creer ArrayList stockage heros
		ArrayList<Hero> heroesList = new ArrayList<Hero>();
		heroesList.add(ragnar); heroesList.add(zogzog);
		
		//create monsters
		Monster zombie = new Monster(1, "Zombie", 2, 4, 10, 1);
		Monster wolf = new Monster(2, "Loup", 5, 2, 7, 6);
		//creer array stockage monsters
		ArrayList<Monster> monstersList = new ArrayList<Monster>();
		monstersList.add(zombie); monstersList.add(wolf);
		
		//Afficher heros
		GameFunctions.printHeroesList(heroesList);
		//selection hero
		Hero hero = GameFunctions.selectHero(heroesList);
		//afficher hero selectionné
		System.out.println("Vous avez selectionné:");
		GameFunctions.printHero(hero);
		
		//test RemoveLife functions
		GameFunctions.heroTurn(wolf, hero, D6);
		
	}
	
	
	
	
}
