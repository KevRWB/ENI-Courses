package fr.eni.ecole;

public class PlateauDeReversi {
	private static final int TAILLE = 8;
	private static Pion[][] pions = new Pion[TAILLE][TAILLE];
	
	//CONSTRUCTEUR
	public PlateauDeReversi() {
		//Init plateau dans constructeur avec Pions vides "Libres"
		for (int i = 0; i < TAILLE; i++) {
			for (int j = 0; j < pions.length; j++) {
				pions[i][j] = Pion.LIBRE;
			}
		}
		//Init placement des 4 pions de départ
		pions[TAILLE/2 - 1][TAILLE/2 - 1] = Pion.BLANC;
		pions[TAILLE/2][TAILLE/2] = Pion.BLANC;
		pions[TAILLE/2 -1][TAILLE / 2] = Pion.NOIR;
		pions[TAILLE/2][TAILLE / 2 - 1 ] = Pion.NOIR;
		
		//Init nombres de pions
		Pion.BLANC.setNbPions(2);
		Pion.NOIR.setNbPions(2);
		Pion.LIBRE.setNbPions(TAILLE*TAILLE - 4);
		
	}
		
	public static void afficher() {

		//Afficher nombres pions
		System.out.println();
		System.out.println("    ---- AWESOME REVERSI ----");
		System.out.println();
		System.out.println("        " + Pion.BLANC.getnbPions() + " pions " + Pion.BLANC.getSymbole());
		System.out.println("        " + Pion.NOIR.getnbPions() + " pions " + Pion.NOIR.getSymbole());
		System.out.println();
		
		//Affichage coordonnées ordonnés Y
		for (int i = 0; i < TAILLE + 1; i++) {
			if(i == 0) System.out.print("      ");
			else System.out.print(i   + " ");
							
		}
		System.out.println();
		//---Affichage plateau de jeu + abscisses X
		for (int i = 0; i < TAILLE; i++) {	
			System.out.print("    " + (i + 1) + " "); //affichage coordonnés abscisses X
			for (int j = 0; j < TAILLE; j++) {
				System.out.print(pions[i][j].getSymbole() + " ");
			}
			System.out.println();
		}
	}
	
	//Fonction TEST -> Nombre de pions qui changeraient de couleur si pion est joué aux coordonnées indiquées
	public static int tester(Pion pion, int x, int y) {
		int nbPionsChange = 0;
		Pion autrePion = pion.autrePion();
		//Test si pion sur la case
		if(pions[x][y] != Pion.LIBRE ) {
			return 0;
		}
		//Return
		return nbPionsChange;
	}
	
	//Fonction : TEST si au moins une possibilité de jouer
	public static boolean peutJouer(Pion pion) {
		boolean peutJouer = false;
		
		return peutJouer;
	}
	
	//---Fonction retourner so possible
	public int testNbPionRetournable(Pion pion, int x, int y) {
		x -= 1;
		y -=1; 
		int i = 0;
		int index = 0;
		boolean flipOk = false;
		int nbPionsRetournes = 0;
		//####### -----------------test ligne gauche
		while(i < x - 1) {
			if(pions[y][i] == Pion.LIBRE) flipOk = false;
			else if (pions[y][i] == pion) {
				index = i;
				flipOk = true;
			}
			i++;
		}
		/////test si pion même couleur juste à côté
		if(flipOk) {
			if(index == x - 1) flipOk = false;
			//compte nombre de pion à retourner
			else {
				nbPionsRetournes += x - index - 1; 
			}
		}
		System.out.println("FlipOK : " + flipOk + " nbPions" + nbPionsRetournes);
		//####### -----------------test ligne droite
		//init compteur à droite du plateau
		i = TAILLE - 1;
		index = TAILLE - 1;
		flipOk = false;
		while(i > x + 1) {
			if(pions[y][i] == Pion.LIBRE) flipOk = false;
			else if (pions[y][i] == pion) {
				index = i;
				flipOk = true;
			}
			i--;
		}
		/////test si pion même couleur juste à côté
		if(flipOk) {
			if(index == x + 1) flipOk = false;
			//compte nombre de pion à retourner
			else {
				nbPionsRetournes += index - x - 1; 
			}
		}
		System.out.println("FlipOK : " + flipOk + " nbPions" + nbPionsRetournes);
		
		//####### -----------------test colonne bas
		//init compteur à droite du plateau
		i = TAILLE - 1;
		index = TAILLE - 1;
		flipOk = false;
		while(i > y + 1) {
			if(pions[i][x] == Pion.LIBRE) flipOk = false;
			else if (pions[i][x] == pion) {
				index = i;
				flipOk = true;
			}
			i--;
		}
		/////test si pion même couleur juste à côté
		if(flipOk) {
			if(index == y + 1) flipOk = false;
			//compte nombre de pion à retourner
			else {
				nbPionsRetournes += index - y - 1; 
			}
		}
		System.out.println("FlipOK : " + flipOk + " nbPions" + nbPionsRetournes);
		
		//####### -----------------test ligne gauche
				while(i < y - 1) {
					if(pions[i][x] == Pion.LIBRE) flipOk = false;
					else if (pions[i][x] == pion) {
						index = i;
						flipOk = true;
					}
					i++;
				}
				/////test si pion même couleur juste à côté
				if(flipOk) {
					if(index == y - 1) flipOk = false;
					//compte nombre de pion à retourner
					else {
						nbPionsRetournes += y - index - 1; 
					}
				}
				System.out.println("FlipOK : " + flipOk + " nbPions" + nbPionsRetournes);
		
		
		//Retourne le nombre de pions retournables	
		return nbPionsRetournes;
	}

	
	
	//---Fonction retourne tableau plateau de jeu
	public static Pion[][] getPions() {
		return pions;
	}

	
	
}




