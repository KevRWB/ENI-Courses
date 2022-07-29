package fr.eni.ecole;

public class ReversiTest {

	public static void main(String[] args) {
		PlateauDeReversi plateau = new PlateauDeReversi();
		
		plateau.afficher();
		
		Pion courant = Pion.NOIR;
		System.out.println("Au tour de " + courant.getSymbole() + "...");
		
	}
	
}
