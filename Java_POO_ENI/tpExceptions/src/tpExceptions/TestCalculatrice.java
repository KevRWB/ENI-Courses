package tpExceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestCalculatrice {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int nbUn = 0;
		int nbDeux = 0;
		int resultat = 0;
		boolean calculOk = false;
		boolean saisieOk = false;
		boolean quitter = false;
		boolean continuer = false;
		String goOn;
		
		//INTRO
		System.out.println("Bonjour, bienvenus dans ce programme Best Calculatrice Ever");
		
		do {
		
			do {
				//-----Saisie utilisateur
				do {
					try {
						System.out.println("Saisir un premier nombre entier :");
						nbUn = sc.nextInt();
						saisieOk = true;
					}catch(InputMismatchException e2) {
						System.out.println("Saisie incorrecte. Réessayez...");
						sc.next();
					}
				}while(!saisieOk);
				
				saisieOk = false;
				do {
					try {
						System.out.println("Saisir un second nombre entier :");
						nbDeux = sc.nextInt();
						saisieOk = true;
					}catch(InputMismatchException e2) {
						System.out.println("Saisie incorrecte. Réessayez...");
						sc.next();
					}
				}while(!saisieOk);
				
				System.out.println("opérateur ? (+ - * / % ou q pour quitter)");
				
				String input = sc.next();
				System.out.println("Saisie :" + input);
				//-------------------
				
				switch (input) {
				case "+" : try {
						resultat = Operation.additionner(nbUn, nbDeux);
						calculOk = true;
					} catch (DepassementCapaciteException e) {
						e.printStackTrace();
					}
				break;
				case "-" : try {
						resultat = Operation.soustraire(nbUn, nbDeux);
						calculOk = true;
					} catch (DepassementCapaciteException e) {
						e.printStackTrace();
					}
				break;
				case "*" :try {
						resultat = Operation.multiplier(nbUn, nbDeux);
						calculOk = true;
					} catch (DepassementCapaciteException e) {
						e.printStackTrace();
					}
				break;
				case "/" :try {
						resultat = Operation.diviser(nbUn, nbDeux);
						calculOk = true;
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				break;
				case "%" : resultat = Operation.modulo(nbUn, nbDeux);
							calculOk = true;
							
				break;
				case "q" :System.out.println("Merci d'avoir joué");
							calculOk = true;
							quitter = true;
				break;
				default : System.out.println("Mauvaise saisie. Veuillez ressaisir votre opérateur ?");
				}
			}while(!calculOk);
			
			if(quitter) System.out.println("Au revoir, merci de votre visite, coridialement, bien à vous, à qui de droit, s'il vous plaît");
			else System.out.println("Resultat : " + resultat);
		
			//Continuer ou non ?
			System.out.println("Voulez-vous faire un nouveau calcul ? (O/N)");
			goOn = sc.next().toUpperCase();
			if(goOn == "O") {
				continuer = true;
				System.out.println("C'est reparti");
			}
			
		}while(!continuer);
		System.out.println("Au revoir");
		
		
		//Close Scanner
		sc.close();
	}

}
