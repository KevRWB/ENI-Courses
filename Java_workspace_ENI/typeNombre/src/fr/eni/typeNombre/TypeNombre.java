package fr.eni.typeNombre;

import java.util.Scanner;

public class TypeNombre {
	
	// global variables
	static Scanner input = new Scanner(System.in);
	
	static final String TYPE_NULL = "Null";
	static final String TYPE_PETIT = "Petit";
	static final String TYPE_MOYEN = "Moyen";
	static final String TYPE_GRAND = "Grand";	
	
	
	
	public static void main(String[] args) {
		
		//--viariables
		int userInput;
		
		
		//####--PROGRAM---#####
		
		//--intro
		System.out.println("Programme catégorisant un nombre saisi par l'utilisateur.");
		System.out.println("Veuillez saisir un nombre entier positif:");
		
		//--user input
		userInput = input.nextInt();
		
		//test si userinput est bien positif
		if(userInput >= 0) {
			//print result
			printResult(userInput, numType(userInput));
		}
			
	}
	
	//--methods
	public static String numType(int num) {
		String numType;
		
		if(num == 0) {
			numType = TYPE_NULL;
		}else if (num > 0 && num <= 2){
			numType = TYPE_PETIT;
		}else if (num > 2 && num <= 5) {
			numType = TYPE_MOYEN;
		}else {
			numType = TYPE_GRAND;
		}
		
		return numType;
	}
	
	//affichage résultat
	public static void printResult(int num, String numType) {
		System.out.println("Le nombre " + num + " est " + numType);
	}
	

}
