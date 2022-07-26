package tpExceptions;

public class Operation {
	
	public static int additionner(long nbUn, long nbDeux) throws DepassementCapaciteException{
		long resultat = nbUn + nbDeux;
		if(resultat < -2147483648 || resultat > 2147483647 ) throw new DepassementCapaciteException("Depassement");
		return (int)resultat;
	}
	public static int soustraire(long nbUn, long nbDeux) throws DepassementCapaciteException{
		long resultat = nbUn - nbDeux;
		if(resultat < -2147483648 || resultat > 2147483647 ) throw new DepassementCapaciteException("Depassement");
		return (int)resultat;
	}
	public static int multiplier(long nbUn, long nbDeux) throws DepassementCapaciteException{
		long resultat = nbUn * nbDeux;
		if(resultat < -2147483648 || resultat > 2147483647 ) throw new DepassementCapaciteException("Depassement");
		return (int)resultat;
	}
	public static int diviser(int nbUn, int nbDeux) throws Exception {
		if(nbDeux == 0) throw new Exception("La division par zéro n'est pas définie !");
		else return nbUn / nbDeux;	
	}
	public static int modulo(int nbUn, int nbDeux) {
		return nbUn / nbDeux;
	}
}
