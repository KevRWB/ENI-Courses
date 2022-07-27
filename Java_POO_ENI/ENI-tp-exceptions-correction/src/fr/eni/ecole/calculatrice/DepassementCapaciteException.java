package fr.eni.ecole.calculatrice;

public class DepassementCapaciteException extends Exception {

	private static final long serialVersionUID = 1L;

	public DepassementCapaciteException() {
		super("Le resultat dépasse la capacité de la calculatrice");
	}
	
	

}
