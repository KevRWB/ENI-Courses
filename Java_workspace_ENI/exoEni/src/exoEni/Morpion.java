package exoEni;

import java.util.Scanner;

public class Morpion {
	
	//finals
		static final int TAILLE = 3;
		static final char CARAC_JOUEUR_UN = 'X';
		static final char CARAC_JOUEUR_DEUX = 'O';
		static final char VIDE = '-';
		
		static final char TEXTE_JOUEUR_UN = '1';
		static final char TEXTE_JOUEUR_DEUX = '2';

	public static void main(String[] args) {
		//scanner
		Scanner input = new Scanner(System.in);

		//variables
		char[][] plateau = new char[TAILLE][TAILLE];
		int i, j, coordColonne, coordLigne;
		
		int nbCoups = 0;
		int compteColonneJoueur = 0;
		int compteLigneJoueur = 0;
		
		int nbCoupsMax;
		
		boolean joueurUn = true;
		boolean verifDiagonale = true;
		boolean verifLigne = false;
		boolean joueurUnWin = false;
		boolean joueurDeuxWin = false;
		
		char texteJoueur, caracJoueur;
		
		//####---program---#######
		
		//---intro
		System.out.println("MORPION");
		System.out.println();
		
		//-----initialiser plateau avec valeurs "VIDE"
		for(i = 0; i < plateau.length; i++) {
			for(j = 0; j < plateau.length; j++) {
				plateau[i][j] = VIDE;
			}
		}
		
		//-----afficher grille
		for(i = 0; i < plateau.length; i++) {
			for(j = 0; j < plateau.length; j++) {
				System.out.print(plateau[i][j]);
			}
			System.out.println();
		}
		
		//--test si victoire
		nbCoupsMax = TAILLE * TAILLE; // init nombre de coups max possibles
		
		while(!joueurUnWin && !joueurDeuxWin && nbCoups < nbCoupsMax) {
			//---tour du joueur
			//---modifier caractère en fonction du joueur actif
			if(joueurUn) {
				texteJoueur = TEXTE_JOUEUR_UN;
				caracJoueur = CARAC_JOUEUR_UN;
			}else {
				texteJoueur = TEXTE_JOUEUR_DEUX;
				caracJoueur = CARAC_JOUEUR_DEUX;
			}
		
			//---message
			System.out.println("C'est au joueur " + texteJoueur + " de jouer");			
			//test colonnes
			System.out.println("Dans quelle colonne voulez-vous jouer ?");
			coordColonne = input.nextInt() - 1;		
			//test lignes		
			System.out.println("Sur quelle ligne voulez-vous jouer ?");
			coordLigne = input.nextInt() - 1;	
			
			//incrément nombre de coups
			nbCoups ++;
			
			//modifier tableau pour y insérer le caractère joué
			plateau[coordLigne][coordColonne] = caracJoueur;
			
			//afficher la grille
			for(i = 0; i < plateau.length; i++) {
				for(j = 0; j < plateau.length; j++) {
					System.out.print(plateau[i][j]);
				}
				System.out.println();
			}
			
			//#####---test victoire----
			
			//--initialise compteurs de lignes et colonnes
			compteLigneJoueur = 0;
			compteColonneJoueur = 0;
			
			//---test lignes
			for(i = 0; i < plateau.length; i++) {
				for(j = 0; j < plateau.length; j++) {
					if(plateau[i][j] == caracJoueur) {
						compteLigneJoueur ++;
						if(compteLigneJoueur == TAILLE) {
							verifLigne = true;
						}
					}
				}
				//reinitialise compteur
				compteLigneJoueur = 0;
			}
			
			
			//-----test colonnes si pas de lignes validées
			if(!verifLigne) {
				for(j = 0; j < plateau.length; j++) {
					for(i = 0; i < plateau.length; i++) {
						if(plateau[i][j] == caracJoueur) {
							compteColonneJoueur ++;
							if(compteColonneJoueur == TAILLE) {
								verifLigne = true;
							}
						}
					}
					//reinitialise compteur
					compteColonneJoueur = 0;
				}		
			}	
			//---test diagonles
			if(!verifLigne) {
				
				//---diagonale un
				for(i = 0; i < plateau.length; i++) {
					if(plateau[i][i] != caracJoueur) {
						System.out.println("c'est different");
						verifDiagonale = false;
					}
				}
			}
				
			/*	//----diagonale deux
				if(!joueurUnWin && !joueurDeuxWin) {
					for(i = 0; i < plateau.length; i++) {
						if(i == 0) {
							if(plateau[i][plateau.length - 1] != caracJoueur) {
								verifDiagonale = false;
							}
						}else if(plateau[i][plateau.length - (i+1)] != caracJoueur) {
							verifDiagonale = false;
						}
					}
				}
			*/	
			
			
			//---verif diagonales
			if(verifDiagonale) {
				System.out.println("UNE VICTOIRE");
				if(joueurUn) {
					joueurUnWin = true;
				}else {
					joueurDeuxWin = true;
				}
			}
			
			//-------------------
			//---changement de joueur si pas de victoire
			if(!joueurUnWin && !joueurDeuxWin) {
				if(joueurUn) {
					joueurUn = false;
				} else {
					joueurUn = true;
				}
			}		
		}//fin du tour
		
		//----affichage résultats
		if(joueurUnWin) {
			System.out.println("Bravo joueur un, vous avez gagné !");
		}else if(joueurDeuxWin) {
			System.out.println("Bravo joueur deux, vous avez gagné !");			
		}else {
			System.out.println("Egalité !");
		}
		
	}//END MAIN
	

}