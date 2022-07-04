package fr.eni.distributeurBoisson;

import java.util.Scanner;

public class DistributeurBoisson {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Finales
		final int PRIX_CAFE = 60;
		final int PIECE_2 = 200;
		final int PIECE_1 = 100;
		final int PIECE_05 = 50;
		final int PIECE_02 = 20;
		final int PIECE_01 = 10;
		final int PIECE_005 = 5;
		
		
		//Variables
		float resteARendre = 0f;
		float valeurPiece = 0;
		int valeurPieceCentimes = 0;
		int credit = 0;

		//###--PROGRAM---###########
		
		//user inputs
		//---tant que le credit est insuffisant, demande d'ajouter une pièce
		while(credit < PRIX_CAFE) {
			//--test si valeur de la pièce insérée est valide
			while (valeurPieceCentimes != PIECE_005 && valeurPieceCentimes != PIECE_01 && valeurPieceCentimes != PIECE_02 && valeurPieceCentimes != PIECE_05 && valeurPieceCentimes != PIECE_1 && valeurPieceCentimes != PIECE_2) {
				System.out.println("Quelle est la valeur de votre pièce ?");
				valeurPiece = input.nextFloat();
				valeurPieceCentimes = (int)(valeurPiece * 100);
				
				if(valeurPieceCentimes != PIECE_005 && valeurPieceCentimes != PIECE_01 && valeurPieceCentimes != PIECE_02 && valeurPieceCentimes != PIECE_05 && valeurPieceCentimes != PIECE_1 && valeurPieceCentimes != PIECE_2) {
					System.out.println("Pièce non acceptée, entrez une autre pièce");
				}
			}
			//incrément du crédit
			credit += valeurPieceCentimes;
			if(credit < PRIX_CAFE) {
				System.out.println("Crédit insuffisant(" + credit + "€ / " + PRIX_CAFE + "€)");
				valeurPiece = 0;
			}
		}
		input.close();
		
		//----reste à rendre
		resteARendre = credit - PRIX_CAFE;
		
		//affichage
		System.out.println("Voici votre monnaie (" + (resteARendre/100) + "€)" );
		
		/*//----pièces à rendre
		while(creditCount >= PIECE_005) {
			if(creditCount >= PIECE_2) {
				nbPieces2 = creditCount / PIECE_2;
				creditCount += PIECE_2 / nbPieces2;
				System.out.println("Nombre de pièces de 2€: " + nbPieces2);
			}else if(creditCount >= PIECE_1) {
				nbPieces1 = creditCount / PIECE_1;
				creditCount -= PIECE_1 / nbPieces1;
				System.out.println("Nombre de pièces de 1€: " + nbPieces1);
			}else if(creditCount >= PIECE_05) {
				nbPieces05 = creditCount / PIECE_05;
				creditCount -= PIECE_05 / nbPieces05;
				System.out.println("Nombre de pièces de 0,5€: " + nbPieces05);
			}else if(creditCount >= PIECE_02) {
				nbPieces1 = creditCount / PIECE_02;
				creditCount -= PIECE_02 / nbPieces02;
				System.out.println("Nombre de pièces de 0,2€: " + nbPieces02);
			}else if(creditCount >= PIECE_01) {
				nbPieces1 = creditCount / PIECE_01;
				creditCount -= PIECE_01 / nbPieces01;
				System.out.println("Nombre de pièces de 0,1€: " + nbPieces01);
			}else if(creditCount >= PIECE_005) {
				nbPieces1 = creditCount / PIECE_005;
				creditCount -= PIECE_005 / nbPieces005;
				System.out.println("Nombre de pièces de 0,05€: " + nbPieces005);
			}
			
		}
		*/
		
		
		
		
	}

}
