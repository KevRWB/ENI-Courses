package fr.eni.calculette;

import java.util.Scanner;

public class Calculette {
	
	static Scanner input = new Scanner(System.in);	
	
	public static void main(String[] args) {
		
		int userSelection;
		
		int numUn;
		int numDeux;
		int result;
		boolean continuer = false;
			
		//---PROGRAM
		//saisie utilisateurs
		
		do {
			userSelection = selectionCalcul();	
			System.out.println("Veuiller saisir votre premier nombre :");
			numUn = input.nextInt();
			System.out.println("Veuiller saisir votre second nombre :");
			numDeux = input.nextInt();
			
			//--calculs
			switch (userSelection) {
				case 1: 
					result = addition(numUn, numDeux);
					System.out.println(numUn + " + " + numDeux + " = " + result);
				break;
				case 2: 
					result = soustraction(numUn, numDeux);
					System.out.println(numUn + " - " + numDeux + " = " + result);
				break;
				case 3: 
					result = multiplication(numUn, numDeux);
					System.out.println(numUn + " x " + numDeux + " = " + result);
				break;
				case 4: 
					result = division(numUn, numDeux);
					System.out.println(numUn + " / " + numDeux + " = " + result);
				break;
				case 5: 
					result = modulo(numUn, numDeux);
					System.out.println(numUn + " % " + numDeux + " = " + result);
				break;
			}
			
			//--choix de continuer ou non
			continuer = choixContinuer();
			
					
		}while(continuer == true);
		
		//--affichage quitter programme
		System.out.println();
		System.out.println("Merci d'avoir utiliser ce programme");
	}

	//--methods
	
	//---calculs
	public static int addition(int numUn, int numDeux) {
		return numUn + numDeux;
	}
	
	public static int soustraction(int numUn, int numDeux) {
		return numUn - numDeux;
	}
	
	public static int multiplication(int numUn, int numDeux) {
		return numUn * numDeux;
	}
	
	public static int division(int numUn, int numDeux) {
		return numUn / numDeux;
	}
	
	public static int modulo(int numUn, int numDeux) {
		return numUn % numDeux;
	}
	
	// ---- intro + selection calcul par utilisateur
	public static int selectionCalcul() {
		int result;
		System.out.println("Bienvenue dans ce programme de calcul");
		System.out.println("Quel type d'opération souhaitez-vous effectuer ?");
		System.out.println("1 - Addition");
		System.out.println("2 - Soustraction");
		System.out.println("3 - Multiplication");
		System.out.println("4 - Division");
		System.out.println("5 - Reste d'une division entière (modulo)");
		System.out.println("Votre choix :");
		
		result = input.nextInt();
		
		while(result < 1 || result > 5) {
			System.out.println("Veuillez faire faire choix entre 1 et 5:");
			result = input.nextInt();
		}
		
		switch (result) {
		case 1: System.out.println("1 - Addition");
		break;
		case 2: System.out.println("2 - Soustraction");
		break;
		case 3: System.out.println("3 - Multiplication");
		break;
		case 4: System.out.println("4 - Division");
		break;
		case 5: System.out.println("5 - Reste d'une division entière (modulo)");
		break;
		}
		
		return result;
	}
	
	//----choix de continuer ou non
	public static boolean choixContinuer() {
		int choixContinuer;
		
		System.out.println();
		System.out.println("Souhaitez-vous refaire un calcul ?");
		System.out.println("1- Oui");
		System.out.println("2- Non");
		System.out.println("Votre choix:");
		choixContinuer = input.nextInt();
		
		while(choixContinuer != 1 && choixContinuer != 2) {
			System.out.println("Veuillez saisir un choix valide");
			choixContinuer = input.nextInt();
		}
		
		if(choixContinuer == 1) {
			return true;
		}else {
			return false;
		}
	}
	//--------------------

}

