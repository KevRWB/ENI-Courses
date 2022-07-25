package bestGameEver.fonctions;

import java.util.Random;
import java.util.Scanner;

import bestGameEver.jeu.BestGameEver;
import bestGameEver.persos.heroes.Hero;
import bestGameEver.persos.heroes.HeroesFunctions;
import bestGameEver.persos.monsters.Monster;
import bestGameEver.persos.monsters.MonstersFunctions;

public class FightFunctions {

	//--METHODS	
		//#########--- TOURS DE COMBAT ----- ################
		public static void fight(Hero hero, Monster monster, int dice) {
			//Print monster
			System.out.println("Vous allez vous battre contre un :");
			MonstersFunctions.printMonster(monster);
			//Boucle de jeu
			Scanner sc = new Scanner(System.in);
			System.out.println("Prêt(e) ? Entrez une touche pour lancer le combat !");
			BestGameEver.scan.nextLine();
			//Affichage Hero VERSUS Monster
			System.out.println(hero.getName() + " VS " + monster.getName());
			//test initiative
			boolean heroHasInit = FightFunctions.heroHasInit(hero, monster);
			FightFunctions.printInit(heroHasInit);
			
			//-----GAME LOOP
			int turnCount = 0; // test si premier tour pour affichage
			
			while(hero.getLife() > 0 && monster.getLife() > 0) { 
				if(turnCount == 0) {
					System.out.println("Entrez une touche pour lancer l'attaque !");
				}else System.out.println("Entrez une touche pour lancer l'attaque suivante !");
				
				BestGameEver.scan.nextLine();
				if(heroHasInit) {
					HeroesFunctions.heroTurn(monster, hero, dice);
					heroHasInit = false; // change initiative
				} else {
					MonstersFunctions.monsterTurn(monster, hero, dice);
					heroHasInit = true; // change initiative
				}	
				turnCount++; //increment turns count		
			}
			//test if win or lose
			if(hero.getLife() <= 0) {
				System.out.println("----XXXXXXX-----");
				System.out.println("Vous êtes mort...");
				System.out.println("----XXXXXXX-----");
			}else {
				System.out.println("----|-|-|-|-|-------");
				System.out.println("Bravo, vous avez vaincu le monstre !");
				System.out.println("----|-|-|-|-|-------");
			}
			//Close Scanner
			sc.close();
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
			}else System.out.println("Le monstre l'initiative pour ce combat. Il va donc lancer la première attaque !");
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
