package fr.eni.reprographie;

import java.util.Scanner;

public class Reprographie {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		final int VALUE_UN = 2;
		final float VALUE_DEUX = 1.5f;
		
		final int LIMIT_UN = 10;
		final int LIMIT_DEUX = 20;
		
		int nbCopy;
		float toPay = 0;
		
		//--program
		
		//use input
		System.out.println("Combien de photocopies souhaitez-vous faire ?");
		
		nbCopy = input.nextInt();
		input.close();
		
		//---conditions
		if(nbCopy <= LIMIT_UN) {
			toPay = nbCopy * VALUE_UN;
		}else if(nbCopy > LIMIT_UN && nbCopy <= LIMIT_DEUX) {
			toPay = (LIMIT_UN * VALUE_UN) + (VALUE_DEUX * (nbCopy - LIMIT_UN));
		}else {
			toPay = (LIMIT_UN * VALUE_UN) + (VALUE_DEUX * (LIMIT_DEUX - LIMIT_UN) + (nbCopy - LIMIT_DEUX));
		}
		
		
		//--affichage
		System.out.println("Vous devez " + toPay + "€");
	}

}
