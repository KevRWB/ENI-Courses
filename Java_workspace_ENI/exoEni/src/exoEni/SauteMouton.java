package exoEni;

import java.util.Scanner;

public class SauteMouton {

	static final char CARAC_DROITE = '>';
	static final char CARAC_GAUCHE = '<';
	static final char CARAC_VIDE = ' ';
	
	static Scanner input = new Scanner(System.in);
	
	static int[] tabIndex = {0,1,2,3,4,5,6};
	static char[] tabMoutons = {CARAC_DROITE,CARAC_DROITE,CARAC_DROITE, CARAC_VIDE, CARAC_GAUCHE, CARAC_GAUCHE,CARAC_GAUCHE} ;
	static int coupJoué;
	
	public static void main(String[] args) {
		
		//--PROGRAM
		turn(tabMoutons);		
		playerWin(tabIndex, tabMoutons);
	}
	
	//---methodes
	
	//--intro/consignes
	public static void intro() {
		System.out.println("Bonjour, bienvenue dans ce jeu de saute moutons");
	}
	
	//--afficher jeux
	public static void printGame(int[] tabIndex, char[] tabMoutons) {
		for(int i=0; i<tabIndex.length; i++) {
			System.out.print(" " + tabIndex[i] + " " );
		}
		System.out.println();
		for(int i=0; i<tabMoutons.length; i++) {
			System.out.print(" " + tabMoutons[i] + " " );
		}
		System.out.println();
	}
	
	//-- saisie joueur
	public static int saisieJoueur() {
		System.out.println("Quel moutons souhaitez-vous déplacer ?");
		return input.nextInt();
	}
	
	//--check saisie joueur
	public static boolean checkSaisieJoueur(char[]tabMoutons, int coupJoue) {	
		if(coupJoue < 0 || coupJoue >6 || tabMoutons[coupJoue] == CARAC_VIDE) {
			return false;
		}else {
			return true;
		}			
	}
	
	//----test si mouvement possible
	public static boolean testIfCanMove(char[] tabMoutons, int coupJoue) {
		Boolean canPlay = false;
		
		//condition moutons gauches
		if(tabMoutons[coupJoue] == CARAC_DROITE) {
			if((tabMoutons[coupJoue + 1] == CARAC_VIDE || tabMoutons[coupJoue + 2] == CARAC_VIDE) && tabMoutons[coupJoue+1] != CARAC_DROITE) {
				canPlay = true;
			}
		}
		if(tabMoutons[coupJoue] == CARAC_GAUCHE){
			if((tabMoutons[coupJoue -1] == CARAC_VIDE || tabMoutons[coupJoue - 2] == CARAC_VIDE) && tabMoutons[coupJoue-1] != CARAC_GAUCHE ) {
				canPlay = true;
			}
		}	
		return canPlay;	
	}
	//--test quel mouton joue
	public static char quelMouton(char[]tabMoutons, int coupJoué) {
		char charMouton;
		if(tabMoutons[coupJoué] == CARAC_DROITE) {
			charMouton = CARAC_DROITE;
		}else {
			charMouton = CARAC_GAUCHE;
		}	
		return charMouton;
	}
		
	//----déplacer mouton gauche
	public static void bougeMoutonGauche(char[] tabMoutons, int coupJoue) {
		if(tabMoutons[coupJoue + 1] == CARAC_VIDE) {
			tabMoutons[coupJoue] = CARAC_VIDE;
			tabMoutons[coupJoue + 1] = CARAC_DROITE;
		}else {
			tabMoutons[coupJoue] = CARAC_VIDE;
			tabMoutons[coupJoue + 2] = CARAC_DROITE;
		}
	}
	//---déplacer mouton droite
	public static void bougeMoutonDroite(char[] tabMoutons, int coupJoue) {
		if(tabMoutons[coupJoue -1] == CARAC_VIDE) {
			tabMoutons[coupJoue] = CARAC_VIDE;
			tabMoutons[coupJoue - 1] = CARAC_GAUCHE;
		}else {
			tabMoutons[coupJoue] = CARAC_VIDE;
			tabMoutons[coupJoue - 2] = CARAC_GAUCHE;
		}
	}
	
	//----bouger mouton
	public static void move(char[] tabMoutons, int coupJoue) {
		if(quelMouton(tabMoutons, coupJoue) == CARAC_DROITE) {
			bougeMoutonGauche(tabMoutons, coupJoue);
		}else {
			bougeMoutonDroite(tabMoutons, coupJoue);
		}
	}
	//-----boucle jeu
	public static void turn(char[] tabMoutons) {
		
		boolean canPlay;
		boolean continuer = true;
		
		while(continuer) {
			printGame(tabIndex, tabMoutons);
			int coupJoue = saisieJoueur();
			
			boolean checkSaisieJoueur = checkSaisieJoueur(tabMoutons, coupJoue);
			while(!checkSaisieJoueur) {
				System.out.println("Veuillez selectionner un numero de mouton valide");
				coupJoue = saisieJoueur();
				checkSaisieJoueur = checkSaisieJoueur(tabMoutons, coupJoue);
			}
			
			canPlay = testIfCanMove(tabMoutons, coupJoue);
			if(canPlay) {
				move(tabMoutons, coupJoue);
				if(testWin(tabMoutons)) {
					continuer = false;
				}			
			}else {
				System.out.println("Ce coup n'est pas valide");
			}
		}
		
	}
	
	//---test si victoire
	public static boolean testWin(char[] tabMoutons) {
		
		if(tabMoutons[0] == CARAC_GAUCHE && tabMoutons[1] == CARAC_GAUCHE && tabMoutons[2] == CARAC_GAUCHE && tabMoutons[3] == CARAC_VIDE &&  tabMoutons[4] == CARAC_DROITE && tabMoutons[5] == CARAC_DROITE && tabMoutons[6] == CARAC_DROITE) {
			return true;
		}else {
			return false;
		}

	}
	//-----affichage victoire
	public static void playerWin(int[]tabIndex,char[]tabMoutons) {
		printGame(tabIndex, tabMoutons);
		System.out.println("Super, vous avez gagné !");
	}
}
