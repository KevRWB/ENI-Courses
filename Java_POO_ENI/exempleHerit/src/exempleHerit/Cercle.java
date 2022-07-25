package exempleHerit;

import java.awt.Color;

public class Cercle extends Forme {
	private int rayon;
	//CONSTRUCTOR
	public Cercle(Color couleur, int rayon) {
		//fait appel au constructeur du parent -> Toujours en première position
		super(couleur);
		this.rayon = rayon;
	}
	//METHODS
	@Override
	public String calculAire() {
		return "Aire = " + Math.PI*rayon*rayon ;
	}
	//GET / SET
	public int getRayon() {
		return rayon;
	}
	public void setRayon(int rayon) {
		this.rayon = rayon;
	}
	//toString METHOD
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		//fait appel ) la methode toString du parent
		builder.append(super.toString());
		builder.append("Cercle [rayon=");
		builder.append(rayon);
		builder.append("]");
		return builder.toString();
	}
	
	

}
