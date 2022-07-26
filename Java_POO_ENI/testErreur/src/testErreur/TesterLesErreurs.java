package testErreur;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TesterLesErreurs {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int resultat=0;
		boolean repOk = false;
		
		do {
			System.out.println("Indiquez le résultat de 3 x 3");
			try {
				resultat = sc.nextInt();
				repOk = true;
				
			}catch(InputMismatchException e) {
					System.out.println("erreur de saisie");
					sc.next();
			}
		}while(!repOk);
		System.out.println("Votre réponse est : " + resultat);
		

	}

}
