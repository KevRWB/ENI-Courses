package fr.koor.exceptions;

public class RationalException extends IllegalArgumentException{
	private static final long serialVersionUID = 1L;

	public RationalException() {
		this("Denominator cannot be nul"); 
	}


	public RationalException(String message) {
		super(message);
	}
	
	

}
