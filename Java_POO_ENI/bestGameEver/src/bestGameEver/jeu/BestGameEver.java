package bestGameEver.jeu;
import java.util.ArrayList;
import java.util.Random;

import bestGameEver.heros.*;
import bestGameEver.monsters.*;

public class BestGameEver {

	public static void main(String[] args) {
		
		//create heroes
		Hero ragnar = new Hero("Roger", 10, 6, 20);
		Hero zogzog = new Hero("Marcel", 12, 4, 20);
		//creer ArrayList stockage heros
		ArrayList<Hero> heroesList = new ArrayList<Hero>();
		heroesList.add(ragnar); heroesList.add(zogzog);
		
		//create monsters
		Monster zombie = new Monster("Zombie", 4, 4, 10);
		Monster wolf = new Monster("Loup", 5, 2, 7);
		//creer array stockage monsters
		ArrayList<Monster> monstersList = new ArrayList<Monster>();
		monstersList.add(zombie); monstersList.add(wolf);
		
		
		roger.afficherHero();
		System.out.println("----------");
		marcel.afficherHero();
		System.out.println("-------");
		
		//selectionner premier joueur
		boolean rogerIsFirst = true;
		Hero joueur = null;
		Hero defenseur = null;
		//Boucle de jeu
		while(roger.getVie() > 0 || marcel.getVie() > 0) {
			if(rogerIsFirst) {
				joueur = roger;
				defenseur = marcel;
			}else {
				joueur = marcel;
				defenseur = roger;
			}
			
			int lanceDe = GameFunctions.lancerDe(6);
			int attaque = GameFunctions.attaque(lanceDe, joueur);
			GameFunctions.enleverVie(attaque, defenseur);
			
			if(rogerIsFirst) {
				rogerIsFirst = false;
			}else rogerIsFirst = true;
			
			System.out.println("-------------");
		}
		
	}
	
	
	
	
}
