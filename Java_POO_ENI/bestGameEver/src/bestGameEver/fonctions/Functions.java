package bestGameEver.fonctions;

import java.util.ArrayList;
import java.util.Random;

import bestGameEver.jeu.BestGameEver;
import bestGameEver.persos.heroes.Hero;
import bestGameEver.persos.heroes.HeroesList;
//COMMONS FUNCTIONS FOR THE GAME
public class Functions {
	
	//FUNCTIONS ROLLE DICES
	public static int rollDice(int faces) {
		Random rnd = new Random();
		int randNb = rnd.nextInt(faces)+1;
		return randNb;
	}
	
	//#######-----------FUNCTIONS SELECT HERO
	//SELECT HERO
	public static Hero selectHero(ArrayList<Hero> list) {
		HeroesList.printHeroesList(list);
		
		System.out.println("Choisissez votre héros (numéro): ");
		int select = BestGameEver.scan.nextInt();
		Hero heroSelected = list.get(select -1);
	
		return heroSelected;
	}
	
	
}
