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
			
			try { // try de chacune des opérations
				switch(operateur) {
				case "+" :
					nbDeux = saisirEntier();
					resultat = Operation.additionner(nbUn, nbDeux);
					System.out.println(resultat);
					nbUn = resultat;
				break;
				case "-" :
					nbDeux = saisirEntier();
					resultat = Operation.soustraction(nbUn, nbDeux);
					System.out.println(resultat);
					nbUn = resultat;
				break;
				case "*" :
					nbDeux = saisirEntier();
					resultat = Operation.multiplier(nbUn, nbDeux);
					System.out.println(resultat);
					nbUn = resultat;
				break;
				case "/" :
					nbDeux = saisirEntier();
					resultat = Operation.division(nbUn, nbDeux);
					System.out.println(resultat);
					nbUn = resultat;
				break;
				case "%" :
					nbDeux = saisirEntier();
					resultat = Operation.modulo(nbUn, nbDeux);
					System.out.println(resultat);
					nbUn = resultat;
				break;
				}
				//catch Exceptions : Depassement de capacité ou Division par zero (ArithmeticException)
			} catch (DepassementCapaciteException  | ArithmeticException e) {
				if(e instanceof ArithmeticException && operateur.equals("/")) {
					System.err.println("Pas de division par zero bordel à cul !");
				}else if(e instanceof ArithmeticException && operateur.equals("%")) {
					System.err.println("Pas de modulo par zero bordel à cul kon t'a dit !");
				}else System.err.println(e.getMessage());
				
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
			//récupère un String
			String saisie = sc.next()	;	
			try {
				//Try de convertir en entier
				nbre = Integer.parseInt(saisie);
				//si conversion ok -> saisie ok
				saisieOk = true;
			} catch (NumberFormatException e) {
				try {
					//Tye de convertir en long 
					Long nb = Long.parseLong(saisie);
					// Si conversion impossible -> Saisie ok mais dépasse les limtites
					System.out.println("Valeur dépasse limites");
				}catch(NumberFormatException e2) {
					//Saisie pas un nombre entier
					System.out.println("Saisie incorreste. Réessayez...");
				}
			}
		}
		return nbre;
		
		
		
	}

}
