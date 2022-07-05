package exoEni;

import java.util.Scanner;

public class Cuisson {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//Finals
		final double COEF_BOEUF_BLEU = 1.2;
		final double COEF_BOEUF_A_POINT = 2.04;
		final double COEF_BOEUF_BIEN_CUIT = 3;
		
		final double COEF_AGNEAU_BLEU = 2.25;
		final double COEF_AGNEAU_A_POINT = 3.75;
		final double COEF_AGNEAU_BIEN_CUIT = 6;
		
		//--Variables
		
		String meatType, cookType;
		int meatWeight = 0;
		int cookingTimeSec = 0;
		int cookingTimeMin = 0;
		
		//verif variables
		boolean meatTypeInput = false;
		boolean cookTypeInput = false;
		
		//--Program
		do {
			System.out.println("Quel type de viande souhaitez vous cuire ? boeuf ou agneau ?");
			meatType = input.nextLine();
			if(meatType.equals("boeuf") || meatType.equals("agneau") ) {
				meatTypeInput = true;
			}
		}
		while(!meatTypeInput);
		
		do {
			System.out.println("Comment souhaitez-vous cuire votre viande ? bleu / a point / bien cuit");
			cookType = input.nextLine();
			if(cookType.equals("bleu") || cookType.equals("a point") || cookType.equals("bien cuit")) {
				cookTypeInput = true;
			}
		}
		while(!cookTypeInput);
		
		System.out.println("Combien pèse votre viande(en grammes) ?");
		meatWeight = input.nextInt();
	
		
		//
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
		} // end switch
		
		cookingTimeMin = cookingTimeSec / 60;
		
		System.out.println("Pour que votre " + meatType + " soit " + cookType + ", il faudra cuire pendant " + cookingTimeSec + " secondes, soit " + cookingTimeMin + " minutes." );
		
		
		input.close();
	}

}
