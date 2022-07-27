package fr.eni.ecole;

public class PlateauDeReversi {
	private static final int TAILLE = 8;
	private static Pion[][] pions = new Pion[TAILLE][TAILLE];
	
	//CONSTRUCTEUR
	public PlateauDeReversi() {
		//Init plateau dans constructeur
		for (int i = 0; i < TAILLE; i++) {
			for (int j = 0; j < pions.length; j++) {
				pions[i][j] = Pion.LIBRE;
			}
		}
		//init placement des pions de départ
		pions[3][3] = Pion.BLANC;
		pions[4][4] = Pion.BLANC;
		pions[3][4] = Pion.NOIR;
		pions[4][3] = Pion.NOIR;
		
		//init nombres de pions
		Pion.BLANC.setNbPions(2);
		Pion.NOIR.setNbPions(2);
		Pion.LIBRE.setNbPions(TAILLE*TAILLE - 4);
		
	}
		
	public static void afficher() {

		//Afficher nombres pions
		System.out.println(Pion.BLANC.getnbPions() + " " + Pion.BLANC.getSymbole());
		System.out.println(Pion.NOIR.getnbPions() + " " + Pion.NOIR.getSymbole());
		System.out.println();
		
		//Afficher
		//Affichage chiffres absisse
		for (int i = 0; i < TAILLE + 1; i++) {
			if(i == 0) System.out.print(" ");
			else System.out.print(i   + " ");
							
		}
		System.out.println();
		//-----------------
		for (int i = 0; i < TAILLE; i++) {
			//affichage chiffres ordonnés
			System.out.print(i+1);
			for (int j = 0; j < TAILLE; j++) {
				System.out.print(pions[i][j] + " ");
			}
			System.out.println();
		}
	}
//
//	public static int tester(Pion pion, int x, int y) {
//		int nbPionsChange = 0;
//		
//		//SI autres pions autour
//			
//			//Si '.' sur ligne
//				
//				//Si '.' sur colonne
//		
//		  			//Si '.' sur diagonale
//		
//		//SINON nb pion reste 0
//		
//		
//		return nbPionsChange;
//	}
//	
//	public static boolean peutJouer(Pion pion) {
//		boolean peutJouer = false;
//		
//		return peutJouer;
//	}
}


