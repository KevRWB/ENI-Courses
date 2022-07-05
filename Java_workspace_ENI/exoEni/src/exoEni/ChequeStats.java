package exoEni;

import java.util.Scanner;

public class ChequeStats {

	public static void main(String[] args) {
		//scanner
		Scanner input = new Scanner(System.in);

		//finals
		short STOP_INPUT = 0;
		
		//---variables
			//----tables
		String[] checkNumArray = new String[100];
		float[] checkAmountArray = new float[100];
		
			//---counts
		int  i ;
		float checkAmount;
		String  numCheck;
		
		int nbCheck = 0;
		float higherAmount = 0f;
		float lowerAmount = 9999999999f;
		float totalAmount = 0;
		float avgAmount = 0f;
		String higherNumCheck = "0";
		String  lowerNumCheck = "0";
		int nbCheckLess200 = 0;
		int nbCheckMore200 = 0;
		int checkMore200Amount = 0;
		int checkLess200Amount = 0;
		
		
		boolean continueInput = true;
		
		
		
		//#######------PROGRAM---------##########
		System.out.println("Bonjour, bienvenue dans ce programme de gestion de chèque.");
		System.out.println("Vous allez devoir saisir le numéro ainsi que le montant de vos chèques.");
		System.out.println("Lorsque vous n'avez plus de chèque en saisir, entrer " + STOP_INPUT + " à la demande du numéro.");
		
		//check numero input
		System.out.println("Veuillez saisir un numéro de chèque ? (8 chiffres maximum)");
		numCheck = input.nextLine();
		
		//test if more check to input
		if(numCheck.equals("0") ) {
			continueInput = false;
		}
		
		while(continueInput) {
			
			//---test the length of unser input (need tu be 8 characters)
			while(numCheck.length() != 8) {
				System.out.println("Veuillez saisir un numéro de chèque valide (8 chiffres) ?");
				numCheck = input.nextLine();		
			}
			//increment the number of checks
			nbCheck ++;
			//add check numero to array of numeros
			checkNumArray[nbCheck - 1] = numCheck;
			
			//check amount input
			
			System.out.println("Veuillez saisir le montant de votre chèque ?");
			checkAmount = input.nextFloat();
			if(checkAmount < 0) {
				while(checkAmount < 0) {
					System.out.println("Veuillez saisir un montant supérieur à 0");
					checkAmount = input.nextFloat();
				}
			}
			//add check amount to array of amounts
			checkAmountArray[nbCheck - 1] = checkAmount;
			
			//print num & amount of the check
			System.out.println("Vous venez de saisir le chèque n°" + numCheck + " , d'un montant de " + checkAmount + "€");
			//reinitialize checkAmount & check numero
			checkAmount = 0;
			
			//propose ending
			System.out.println("Si vous souhaitez terminer la saisie, écrivez " + STOP_INPUT);
			//propose to input new check
			System.out.println("Veuillez saisir un numéro de chèque valide (8 chiffres)");
			numCheck = input.nextLine();
			//test if ending
			if(numCheck.equals("0")) {
				continueInput = false;
			}
			input.close();
		}
		
		//----calculate stats
		//-- higher check amount
		for(i = 0; i < nbCheck; i++) {
			//add to total amount
			totalAmount += checkAmountArray[i];
			
			//----test for less or more than 200 amount
			if(checkAmountArray[i] < 200) {
				nbCheckLess200++;
				checkLess200Amount += checkAmountArray[i];
			}else {
				nbCheckMore200++;
				checkMore200Amount += checkAmountArray[i];
			}
			
			//---the higher check and it's number
			if(checkAmountArray[i] > higherAmount) {
				higherNumCheck = checkNumArray[i];			
				higherAmount = checkAmountArray[i];
			}
			
			//---the lower check and it's number
			if(checkAmountArray[i] < lowerAmount) {
				lowerNumCheck = checkNumArray[i];
				lowerAmount = checkAmountArray[i];
			}
		}
		
		//--average amount calcul
		avgAmount = totalAmount / nbCheck;
		
		
		//---printing results
		
		System.out.println("Nombre de chèque saisies: " + nbCheck);
		System.out.println("Montant total: " + totalAmount + "€");
		System.out.println("Moyenne des montants de chèques: " + avgAmount + "€");
		System.out.println("Nombre de chèque au montant inférieur à 200€ : " + nbCheckLess200);
		System.out.println("Montant des chéques au montant inférieur à 200€ : " + checkLess200Amount + "€");
		System.out.println("Nombre de chèque au montant supérieur ou égal à 200€ : " + nbCheckMore200);	
		System.out.println("Montant des chéques au montant supérieur ou égal à 200€ : " + checkMore200Amount + "€");
		System.out.println("Le chèque au montant le moins élevé est le n°" + lowerNumCheck + ", montant: " + lowerAmount + "€");
		System.out.println("Le chèque au montant le plus élevé est le n°" + higherNumCheck + ", montant: " + higherAmount + "€");
		
	}

	
}
