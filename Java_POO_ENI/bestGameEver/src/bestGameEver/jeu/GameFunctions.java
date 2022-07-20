package bestGameEver.jeu;

import java.util.Random;

import bestGameEver.heros.Hero;

public class GameFunctions {

	//--METHODS
	
		//lancer et afficher dé
		public static int lancerDe(int faces) {
			Random rnd = new Random();
			int randNb = rnd.nextInt(faces)+1;
			System.out.println("Lancé de dé de " + faces + "  Résultat : " + randNb);
			return randNb;
		}
		
		//fonction attaque
		public static int attaque(int resultDe, Hero hero) {
			int ptsAttaque;
			ptsAttaque = (resultDe);
			return ptsAttaque;
		}
		//fonction enlever vie
		public static void enleverVie(int att, Hero hero) {
			
			hero.removeVie(att);
			System.out.println(hero.getName() + " a perdu " + att + " PV");
			System.out.println("Il lui reste " + hero.getVie() + " PV");
		}
		
		//fonction random nbJoueur
		public static int randNbJoueur(int nbJoueur) {
			Random rnd = new Random();
			return rnd.nextInt(nbJoueur)+1;
		}
}
