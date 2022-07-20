package bestGameEver.jeu;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import bestGameEver.heros.*;
import bestGameEver.monsters.*;

public class BestGameEver {
	
	private static final int D6 = 6;
	
	public static void main(String[] args) {
		
		//create heroes & heroes list
		Hero ragnar = new Hero(1,"Ragnar", 6, 4, 20, 5);
		Hero zogzog = new Hero(2,"ZogZog", 7, 3, 20, 1);
		ArrayList<Hero> heroesList = new ArrayList<Hero>();
		heroesList.add(ragnar); heroesList.add(zogzog);
		
		//create monsters & monsters list
		Monster zombie = new Monster(1, "Zombie", 2, 4, 10, 1);
		Monster wolf = new Monster(2, "Loup", 5, 2, 7, 6);
		//creer array stockage monsters
		ArrayList<Monster> monstersList = new ArrayList<Monster>();
		monstersList.add(zombie); monstersList.add(wolf);
		
		//Print heroes list
		GameFunctions.printHeroesList(heroesList);
		//select hero
		Hero hero = GameFunctions.selectHero(heroesList);
		//Print selected hero
		System.out.println("Vous avez selectionné:");
		GameFunctions.printHero(hero);
		
		//Print random monster selected
		System.out.println("Vous allez vous battre contre un :");
		Monster monster = (GameFunctions.selectRdMonster(monstersList));
		GameFunctions.printMonster(monster);
		
		//Boucle de jeu
		Scanner input = new Scanner(System.in);
		System.out.println("Prêt(e) ? Entrez une touche pour lancer le combat !");
		input.nextLine();
		
		System.out.println(hero.getName() + " VS " + monster.getName());
		//test initiative
		boolean heroHasInit = GameFunctions.heroHasInit(hero, monster);
		GameFunctions.printInit(heroHasInit);
		
		//-----GAME LOOP
		int turnCount = 0;
		
		while(hero.getLife() > 0 && monster.getLife() > 0) { 
			if(turnCount == 0) {
				System.out.println("Entrez une touche pour lancer l'attaque !");
			}else System.out.println("Entrez une touche pour lancer l'attaque suivante !");
			
			input.nextLine();
			if(heroHasInit) {
				GameFunctions.heroTurn(monster, hero, D6);
				heroHasInit = false; // change initiative
			} else {
				GameFunctions.monsterTurn(monster, hero, D6);
				heroHasInit = true; // change initiative
			}	
			turnCount++; //increment turns count		
		}
		//test if win or lose
		if(hero.getLife() <= 0) {
			System.out.println("----XXXXXXX-----");
			System.out.println("Vous êtes mort...");
		}else {
			System.out.println("----|-|-|-|-|-------");
			System.out.println("Bravo, vous avez vaincu le monstre !");
		}
	}
	
	
	
	
}
