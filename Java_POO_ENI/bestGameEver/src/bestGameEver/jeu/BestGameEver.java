package bestGameEver.jeu;
import java.util.Random;

import bestGameEver.heros.*;

public class BestGameEver {

	public static void main(String[] args) {
		
		//créer héros
		Hero roger = new Hero("Roger", 10, 6, 20);
		Hero marcel = new Hero("Marcel", 12, 4, 20);
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
			
			int lanceDe = lancerDé(6);
			int attaque = attaque(lanceDe, joueur);
			enleverVie(attaque, defenseur);
			
			if(rogerIsFirst) {
				rogerIsFirst = false;
			}else rogerIsFirst = true;
			
			System.out.println("-------------");
		}
		//victoire d'un joueur
		
		
	}
	
	//--METHODS
	
	//lancer et afficher dé
	private static int lancerDé(int faces) {
		Random rnd = new Random();
		int randNb = rnd.nextInt(faces)+1;
		System.out.println("Lancé de dé de " + faces + "  Résultat : " + randNb);
		return randNb;
	}
	
	//fonction attaque
	private static int attaque(int resultDe, Hero hero) {
		int ptsAttaque;
		ptsAttaque = (resultDe);
		return ptsAttaque;
	}
	//fonction enlever vie
	private static void enleverVie(int att, Hero hero) {
		
		hero.removeVie(att);
		System.out.println(hero.getName() + " a perdu " + att + " PV");
		System.out.println("Il lui reste " + hero.getVie() + " PV");
	}
	
	//fonction random nbJoueur
	private static int randNbJoueur(int nbJoueur) {
		Random rnd = new Random();
		return rnd.nextInt(nbJoueur)+1;
	}
	
	
}
