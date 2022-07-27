package fr.eni.ecole;

public class ReversiTest {

	public static void main(String[] args) {
		PlateauDeReversi plateau = new PlateauDeReversi();
		
		plateau.afficher();
		
		int resultTest = plateau.tester(Pion.BLANC, 7, 0);
		
		System.out.println(resultTest);
	}
	
}
