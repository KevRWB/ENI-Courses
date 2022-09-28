package fr.eni.demoJUnit;

public class Calculatrice {
	
	public long additionner(long a, long b) {
		return a+b;}
	
	public double diviser(double a, double b) throws DivisionParZero {
		if(b==0) {throw new DivisionParZero();}return a/b;}
}
