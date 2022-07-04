package fr.eni.FindNumber;

import java.util.Random;
import java.util.Scanner;

public class FindNumber {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); //intit new scan for user input
		
		
		//--Variables
		int lowerBorne, higherBorne, userNumber;
		int countTurns = 1;
		String userInput;
		
		boolean keepPlaying = true;
		
		//###################### -- PROGRAMM ------------------------------------------------		
		System.out.println("Bonjour, bienvenue dans ce petit jeu");
		System.out.println("Le but est de trouver un nombre compris entre un nombre minimum et un nombre maximum");
		
		//---------user select min and max numbers
		System.out.println("Quel est votre nombre minimum (puis taper entrée) ?");
		lowerBorne = scan.nextInt();
		System.out.println("Quel est votre nombre maximum (puis taper entrée) ?");
		higherBorne = scan.nextInt();
		System.out.println("Super ! ");
		
		
		//-------tour de jeu
		while(keepPlaying) {
		
			int randomNumber = generateRandomInt(lowerBorne, higherBorne + 1); // generate random number between bornes
			
			System.out.println("Vous devez trouver un nombre entre " + lowerBorne + " et " + higherBorne);
			
			System.out.println("Écrivez un nombre et taper sur entrée");
			userNumber = scan.nextInt();
						
			
			while(userNumber != randomNumber) { //test id user number is different of the target number
					
				if(userNumber < randomNumber) {
					System.out.println("C'est plus de " + userNumber);
					userNumber = scan.nextInt();
				} else {
					System.out.println("C'est moins de " + userNumber);
					userNumber = scan.nextInt();
				}
				
				countTurns ++; // increment the number of turns
			} // end of condition
						
			//victory message
			System.out.println("Bravo, vous avez gagné ! Le nombre à trouver était bien le " + randomNumber);
			System.out.println("Vous avez trouvé en " + countTurns + " coups.");
			
			//---------------ask for playing again or not
			System.out.println("Voulez-vous continuer à jouer ? o/n");
			userInput = scan.next();
			
			if(userInput.equals("o") || userInput.equals("n")){
	
					switch (userInput) {
					case "o": keepPlaying = true;			
						break;
					case "n": keepPlaying = false;			
					break;
					}
					
			} else {
				while(!userInput.equals("o") & !userInput.equals("n")){
					System.out.println("Désolé, je n'ai pas compris votre saisie. Voulez-vous continuer à jouer ? o/n");
					userInput = scan.next();
				}
			}
			//--------end asking for playing again
			scan.close();
			
		}
	
		//----ending game message
	System.out.println("Merci d'avoir joué à ce jeu, à bientôt !"); 
	
	}
	

	
	//########---Functions----##############
	public static int generateRandomInt(int min, int max) {
		Random random = new Random();
		int nb;
		nb = min+random.nextInt((max) - min);
		return nb;
	}

}
