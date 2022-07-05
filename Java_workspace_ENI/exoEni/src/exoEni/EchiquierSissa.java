package exoEni;

public class EchiquierSissa {

	public static void main(String[] args) {

		//---finals
		final int BOARD_SIZE = 8;
		final double NB_START_RICE = 1.0d;
		final int COLUMN_SIZE = 22;
		
		//--variables
		double totalRice = NB_START_RICE;
		double nbRice = NB_START_RICE;
		
		//--program
		System.out.println("Echiquier de Sissa");
		System.out.println();
		
		for(int i = 0; i < BOARD_SIZE + 1; i++) {
			
			//première ligne -> affichage numéro colonne
			if(i == 0) {
				for(int j = 0; j < BOARD_SIZE; j++) {
					System.out.print("  |" + (j+1) + "                     ");
				}
				System.out.println();
			}else {
				//ligne suivantes
				System.out.print(i); // afficahge numéro ligne 
				
				for(int j = 0; j < BOARD_SIZE; j++) {
					System.out.print(" | " + nbRice);
					/*addSpaces(nbChar(doubleToString(nbRice)));*/
					spaces(nbChar(doubleToString(nbRice)), COLUMN_SIZE);
					nbRice = multiplyByTwo(nbRice);
					totalRice += nbRice;
				}
				System.out.println();
				
			}		
		}
		
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println("Nombre total de grains de riz : " + totalRice);	
		
	}
	
	///---methods
	
	//---multiply number by 2
	public static double multiplyByTwo(double num) {
		return num * 2;
	}
	
	//---add num2 to num1
	public static double add(double numUn, double  numDeux) {
		return numUn + numDeux;
	}
	
	//---convert nb to String
	public static String doubleToString(double num) {
		return String.valueOf(num);
	}
	
	//---count number of characters of a String
	public static int nbChar(String text) {
		return text.length();
	}
	
	//--add spaces better
	public static void spaces(int nbChar, int colomnSize) {
		int nbSpaces = colomnSize - nbChar;
		for(int i = 0; i < nbSpaces; i ++ ) {
			System.out.print(" ");
		}
	}
	
	//-------------------------
}
