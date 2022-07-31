package k07exceptions;

public class Rational {
	private int numerator;
	private int denominator;
	
	public Rational() {
		this(0, 1);
	}
	

	public Rational(int numerator, int denominator) {
		this.setNumerator(numerator);
		this.setDenominator(denominator) ;
	}


	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		if(denominator == 0) {
			throw new RationalException("Denominator cannot be nul !!!!!!!!!!!!");
		}
		this.denominator = denominator;
	}
	
	
}
