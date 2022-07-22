package exempleHerit;

import java.awt.Color;

public class Cercle extends Forme {
	private int rayon;
	//CONSTRUCTOR
	public Cercle(Color couleur, int rayon) {
		super(couleur);
		this.rayon = rayon;
	}
	//METHODS
	public double calculAire() {
		return Math.PI*rayon*rayon;
	}
	//GET / SET
	public int getRayon() {
		return rayon;
	}
	public void setRayon(int rayon) {
		this.rayon = rayon;
	}
	
	

}
