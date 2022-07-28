package fr.eni.ecole;

public class ReversiTest {

	public static void main(String[] args) {
		PlateauDeReversi plateau = new PlateauDeReversi();
		
		plateau.afficher();
		
		plateau.tester(Pion.BLANC, 2, 3);
		
	}
	
}
