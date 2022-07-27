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
		
		//------SI autres pions autour	
		
		//---------Si dans un coin
		if(x == 0 && y == 0) { // Coin haut / gauche
			if(pions[x+1][y] != autrePion && pions[x+1][y+1] != autrePion && pions[x][y+1] != autrePion ) return 0;
		}
		if(x == 0 && y == TAILLE - 1) { // Coin bas / gauche
			if(pions[x][y-1] != autrePion && pions[x+1][y-1] != autrePion && pions[x+1][y] != autrePion ) return 0;
		}
		if(y == 0 && x == TAILLE - 1) { // Coin haut / droit
			if(pions[x-1][y] != autrePion && pions[x-1][y+1] != autrePion && pions[x][y+1] != autrePion ) return 0;
		}
		if(y == TAILLE - 1 && x == TAILLE - 1) { // Coin bas / droit
			if(pions[x-1][y-1] != autrePion && pions[x][y-1] != autrePion && pions[x-1][y] != autrePion ) return 0;
		}
		//---------Si sur bord
		//Si sur ligne haute
		if(x == 0) { 
			if(pions[x-1][y] != autrePion && pions[x+1][y+1] != autrePion && pions[x][y+1] != autrePion && pions[x][y+1] != autrePion && pions[x][y+1] != autrePion) return 0;
		}
		//Si sur ligne basse
		if(x == TAILLE - 1) { 
			if(pions[x+1][y] != autrePion && pions[x+1][y+1] != autrePion && pions[x][y+1] != autrePion && pions[x][y+1] != autrePion && pions[x][y+1] != autrePion) return 0;
		}
		//Si sur colonne gauche
		if(y == 0) { 
			if(pions[x+1][y] != autrePion && pions[x+1][y+1] != autrePion && pions[x][y+1] != autrePion && pions[x][y+1] != autrePion && pions[x][y+1] != autrePion) return 0;
		}
		//Si sur colonne droite
		if(y == TAILLE - 1) { 
			if(pions[x+1][y] != autrePion && pions[x+1][y+1] != autrePion && pions[x][y+1] != autrePion && pions[x][y+1] != autrePion && pions[x][y+1] != autrePion ) return 0;
		}
	

		//Else
		if(pions[x-1][y-1] != autrePion && pions[x-1][y] != autrePion && pions[x-1][y+1] != autrePion && pions[x][y-1] != autrePion &&
				pions[x][y+1] != autrePion && pions[x+1][y-1] != autrePion && pions[x+1][y] != autrePion && pions[x+1][y+1] != autrePion)
			return  0;

			//Si '.' sur ligne
				
				//Si '.' sur colonne
		
		  			//Si '.' sur diagonale
		
		//SINON nb pion reste 0
		
		
		return nbPionsChange;
	}
	
	//Fonction : TEST si au moins une possibilité de jouer
	public static boolean peutJouer(Pion pion) {
		boolean peutJouer = false;
		
		return peutJouer;
	}
}


