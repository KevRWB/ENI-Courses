package exoEni;

import java.util.Scanner;

public class Cheque {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		final int STOP = 0;
		
		int numInput = 0;
		float amountInput;
		
		float totalAmount = 0f;
		int nbCheck = 0;
		float avgAmount;
		int nbCheckLess200 = 0;
		int nbCheckMore200 = 0;
		float checkMore200Amount =0f ;
		float checkLess200Amount = 0f;
		float higherAmount = 0f;
		float lowerAmount = 999999999f;
		int numHigherCheck = 0;
		int numLowerCheck = 0;

		
		do {
			System.out.println("Veuillez saisir votre numero de chèque ?");
			numInput = input.nextInt();
			
			if(numInput != STOP) {
				System.out.println("Veuillez saisir le montant de votre chèque ?");
				amountInput = (float)input.nextFloat();
			
			
				totalAmount += amountInput;
				nbCheck ++;
				
				if(amountInput < 200) {
					nbCheckLess200 ++;
					checkLess200Amount += amountInput;
				}else {
					nbCheckMore200 ++;
					checkMore200Amount += amountInput;
				}
				
				if(amountInput > higherAmount) {
					higherAmount = amountInput;
					numHigherCheck = numInput;
				}
				
				if(amountInput < lowerAmount) {
					lowerAmount = amountInput;
					numLowerCheck = numInput;
				}
			}
					
		}while(numInput != STOP);
		
		//close scanner
		input.close();
		
		//calculate average
		if(totalAmount == 0) {
			avgAmount = 0;
			lowerAmount = 0;
		}else {
			avgAmount = totalAmount / nbCheck;
		}
		
		
		//affichage
		System.out.println("Nombre de chèques introduits :" + nbCheck);
		System.out.println("Montant total des chèques : " + totalAmount);
		System.out.println("Valeur moyenne des chèques : " + avgAmount);
		System.out.println("Nombre de chèque inférieur à 200€ : " + nbCheckLess200);
		System.out.println("Montant de ces chèques: " + checkLess200Amount);
		System.out.println("Nombre de chèque supérieur à 200€ : " + nbCheckMore200);
		System.out.println("Montant de ces chèques: " + checkMore200Amount);
		System.out.println("Le chèque n° " + numHigherCheck + " est la montant le plus élevé. Montant : " + higherAmount);
		System.out.println("Le chèque n° " + numLowerCheck + " est la montant le moins élevé. Montant : " + lowerAmount);
		
		
	}

}
