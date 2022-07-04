
public class DemoMethod {

	public static void main(String[] args) {
		
		int resultFunction;
		int resultAddition;
		
		int[] myArray = {12, 32, 16};
		int higherNum;
		
		procedureAffichage();

		resultFunction = fonctionDeuxFoisTrois();
		System.out.println(resultFunction);
		
		resultAddition = addition(2, 3);
		System.out.println(resultAddition);
		
		higherNum = nombrePlusGrand(myArray);
		System.out.println(higherNum);

	}

	
	public static void procedureAffichage() {
		System.out.println("coucou");
	}
	
	public static int addition(int numUn, int numDeux) {
		int result;		
		result = numUn + numDeux;
		return result;
	}
	
	public static int fonctionDeuxFoisTrois() {
		int result;
		result = 2 * 3;		
		return result;
	}
	
	public static int nombrePlusGrand(int[] array) {
		int higherNumber = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] > higherNumber) {
				higherNumber = array[i];
			}
		}	
		return higherNumber;
	}
}
