package fr.eni.ecole.calculatrice;

public class Operation {
	
	public static int additionner(int nbUn, int nbDeux) throws DepassementCapaciteException {
		long result = (long) nbUn + nbDeux;
		int resultat = nbUn + nbDeux;
		if(resultat != result) {
			throw new DepassementCapaciteException();
		}
		return resultat;
	}
	
	public static int soustraction(int nbUn, int nbDeux) throws DepassementCapaciteException {
		long result = (long) nbUn - nbDeux;
		int resultat = nbUn - nbDeux;
		if(resultat != result) {
			throw new DepassementCapaciteException();
		}
		return resultat;
		}
	
	public static int multiplier(int nbUn, int nbDeux) throws DepassementCapaciteException {
		long result = (long) nbUn * nbDeux;
		int resultat = nbUn * nbDeux;
		if(resultat != result) {
			throw new DepassementCapaciteException();
		}
		return resultat;
	}
	
	public static int division(int nbUn, int nbDeux) {
		int resultat = nbUn / nbDeux;
			return resultat;		
	}
	
	public static int modulo(int nbUn, int nbDeux) {
		int resultat = nbUn % nbDeux;
		return resultat;
	}
}
