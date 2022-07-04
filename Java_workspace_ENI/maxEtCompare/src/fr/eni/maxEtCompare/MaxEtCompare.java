package fr.eni.maxEtCompare;

public class MaxEtCompare {

	public static void main(String[] args) {

		double higherNumber = higherNumber(12.0, 21.0);
		System.out.println(higherNumber);
		
		int resultComparaison = compareNumbers(5, 12);
		System.out.println(resultComparaison);
		
		
	}
	//----------
	public static double higherNumber(double numUn, double numDeux) {
		double higherNumber;
		
		if(numUn > numDeux) {
			higherNumber = numUn;
		}else {
			higherNumber = numDeux;
		}
		return higherNumber;
	}
	
	//-----------
	public static int compareNumbers(double numUn, double numDeux) {
		int result;
		
		if(numUn < numDeux) {
			result = -1;
		}else if(numUn > numDeux) {
			result = 1;
		}else {
			result = 0;
		}
		
		return result;
	}

}
