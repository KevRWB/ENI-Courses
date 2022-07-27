package fr.eni.ecole.calculatrice;

import java.util.Scanner;

public class Calculatrice {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args){
		//---Saisie nombre
		int nbUn = saisirEntier();
		int nbDeux = 0;
		int resultat = 0;
		//---Saisie opérateur
		String operateur = "";
		
		do {
			System.out.println("Opérateur ? (+ - * / % ou q pour quitter)");
			operateur = sc.next();
			
			try {
				switch(operateur) {
				case "+" :
					nbDeux = saisirEntier();
					resultat = Operation.additionner(nbUn, nbDeux);
					System.out.println(resultat);
					nbUn = resultat;
				break;
				case "-" :
					nbDeux = saisirEntier();
					resultat = Operation.additionner(nbUn, nbDeux);
					System.out.println(resultat);
					nbUn = resultat;
				break;
				case "*" :
					nbDeux = saisirEntier();
					resultat = Operation.additionner(nbUn, nbDeux);
					System.out.println(resultat);
					nbUn = resultat;
				break;
				case "/" :
					nbDeux = saisirEntier();
					resultat = Operation.additionner(nbUn, nbDeux);
					System.out.println(resultat);
					nbUn = resultat;
				break;
				}
			} catch (DepassementCapaciteException  | ArithmeticException e) {
				System.err.println(e.getMessage());
			}
		//Condition de sortie -> Saisie = "q" pour quitter	
		}while(!operateur.equalsIgnoreCase("q"));
			
		//Close Scanner
		sc.close();
	}
	
	public static int saisirEntier() {
		boolean saisieOk = false;
		int nbre = 0;
		while(!saisieOk) {
			System.out.println("Saisir un nombre entier :");
			String saisie = sc.next()	;	
			try {
				nbre = Integer.parseInt(saisie);
				saisieOk = true;
			} catch (NumberFormatException e) {
				try {
					Long nb = Long.parseLong(saisie);
					System.out.println("Valeur dépasse limites");
				}catch(NumberFormatException e2) {
					System.out.println("Saisie incorreste. Réessayez...");
				}
			}
		}
		return nbre;
		
		
		
	}

}
