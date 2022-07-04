package fr.eni.cuissonFunctions;

import java.util.Scanner;

public class CuissonFunction {
		static Scanner input = new Scanner(System.in);
	
	//Finals
		static final double COEF_BOEUF_BLEU = 1.2;
		static final double COEF_BOEUF_A_POINT = 2.04;
		static final double COEF_BOEUF_BIEN_CUIT = 3;
		
		static final double COEF_AGNEAU_BLEU = 2.25;
		static final double COEF_AGNEAU_A_POINT = 3.75;
		static final double COEF_AGNEAU_BIEN_CUIT = 6;
		
	public static void main(String[] args) {
					
		//--Variables	
		String meatType, cookType;
		int meatWeight = 0;
		int cookingTimeSec = 0;
		int cookingTimeMin = 0;
		
		
		//--Program
		//call function saisie type de viande
		meatType = typeDeViande();
		//call function saisir mode de cuisson
		cookType = typeCuisson();
		//call function saisir poids de la viande
		meatWeight = poidsViande();
		
		cookingTimeSec = cookingTime(meatType, cookType, meatWeight);
		
		cookingTimeMin = secToMin(cookingTimeSec);
		
		affichageResultat(meatType, cookType, cookingTimeSec, cookingTimeMin);
			
	}
	
	//----METHODS----
	
	//saisie type de viande
	public static String typeDeViande() {
		String meatType;
		boolean meatTypeInput = false;
		do {
			System.out.println("Quel type de viande souhaitez vous cuire ? boeuf ou agneau ?");
			meatType = input.nextLine();
			if(meatType.equals("boeuf") || meatType.equals("agneau") ) {
				meatTypeInput = true;
			}
		}
		while(!meatTypeInput);		
		return meatType;
	}
	
	//saisie mode de cuisson
	public static String typeCuisson() {
		String cookType;
		boolean cookTypeInput = false;
		do {
			System.out.println("Comment souhaitez-vous cuire votre viande ? bleu / a point / bien cuit");
			cookType = input.nextLine();
			if(cookType.equals("bleu") || cookType.equals("a point") || cookType.equals("bien cuit")) {
				cookTypeInput = true;
			}
		}
		while(!cookTypeInput);
		
		return cookType;
	}
	
	//saisie poids
	public static int poidsViande() {
		System.out.println("Quel est le poids en grammes de votre viande");
		int poids = input.nextInt(); 

		return poids;
	}
	
	//--traitement données
	public static int cookingTime(String meatType, String cookType, int meatWeight) {
		int cookingTimeSec = 0;
		
		switch (meatType) {
			//---case boeuf
			case "boeuf":
				switch (cookType) {
				case "bleu":
					cookingTimeSec = (int)COEF_BOEUF_BLEU * meatWeight;
				break;
				case "a point":
					cookingTimeSec = (int)COEF_BOEUF_A_POINT * meatWeight;
				break;
				case "bien cuit":
					cookingTimeSec = (int)COEF_BOEUF_BIEN_CUIT * meatWeight;
				break;
				}
			break;
			//------case agneau	
			case "agneau":
				switch (cookType) {
				case "bleu":
					cookingTimeSec = (int)COEF_AGNEAU_BLEU * meatWeight;
					break;
				case "a point":
					cookingTimeSec = (int)COEF_AGNEAU_A_POINT * meatWeight;
					break;
				case "bien cuit":
					cookingTimeSec = (int)COEF_AGNEAU_BIEN_CUIT * meatWeight;
					break;
				}
			break;
		}
		return cookingTimeSec;
	}
	
	//-----seconde to minutes----
	public static int secToMin(int timeSec) {
		int minutes = timeSec / 60;	
		return minutes;
	}
	
	//-----affichage
	public static void affichageResultat(String meatType, String cookType, int cookingTimeSec, int cookingTimeMin) {
		System.out.println("Pour que votre " + meatType + " soit " + cookType + ", il faudra cuire pendant " + cookingTimeSec + " secondes, soit " + cookingTimeMin + " minutes." );
	}

}
