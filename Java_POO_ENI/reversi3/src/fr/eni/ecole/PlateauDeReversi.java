package fr.eni.ecole;

public class PlateauDeReversi {
	private static final int TAILLE = 8;
	private Pion[][] pions = new Pion[TAILLE][TAILLE];
	
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
		
	public void afficher() {

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
	public int tester(Pion pion, int x, int y) {
		int nbPions = 0;
		
		if(pions[x][y] == Pion.LIBRE) { // test si case libre
			//Teste toutes les cases juste autour de l'emplacement
			for(int dy = -1 ; dy <=1; dy++ ) {
				for(int dx = -1 ; dx <= 1; dx ++) {
					if(!(dx == 0 && dy == 0)) {  //  || -> (dx!=0 || dy!=0) Plusieurs manière de gérer l'exclusion de la case où je pense jouer
						//Fonction tester direction -> Incrémente du nombre de pions retournables
						nbPions += testerDirection(pion, x, y, dx, dy);		
					}
				}
			}
		}	
		return nbPions;
	}
	
	//Fonction tester direction
	private int testerDirection(Pion p, int x, int y, int dx, int dy) {	
		//J'indique la couleur opposée à mon pion
		Pion couleurOpp = p.autrePion();
		//--init coumpteur
		int nbAutre = 0;
		//-------defini direction
		int i = x + dx;
		int j = y + dy;
		//------
		while(this.pions[i][j] == couleurOpp && i >= 0 && i<TAILLE && j >= 0 && j < TAILLE)
		{
			nbAutre++;
			i+=dx;
			j+=dy;
		}
		//Si mon pion derrière est = à mon pion -> Retourn nbAutre. Sinon, on ne compte pas, on retourne 0.
		if(i < 0 || i > TAILLE || j < 0 || j > TAILLE || this.pions[i][j] != p) {
			return 0;
		}else return nbAutre;	
	}

	//Fonction test si coup possible
	private boolean peutJouer(Pion p) {
		for(int i = 0; i < TAILLE; i++) {
			for (int j = 0; j < TAILLE; j++) {
				if(this.tester(p, i, j) != 0) return true;			
			}
		}
		return false;
	}

	//Fonction poser
	public void poser(Pion p, int x, int y) {
		//Maj nombre de pions
		int nbPoints = this.tester(p, x, y);
		p.setNbPions(nbPoints + 1);
		p.autrePion().setNbPions(nbPoints);
		//Placer le pion aux coordonnées indiquées
		this.pions[x][y] = p;
		
		//Modifie le nombre de pions transformer
		int nbPions;
		for (int dy = -1; dy <= 1; dy++) {
			nbPions = 0;
			for (int dx = -1; dy <=1; dx++) {
				if(dx!=0 || dy != 0) {
					nbPions += testerDirection(p,x,y,dx,dy);
					for(int k=1; k <= nbPions; k++) {
						this.pions[x+dx*k][y+dy*k] = p;
					}
				}
			}			
		}
	}
}




