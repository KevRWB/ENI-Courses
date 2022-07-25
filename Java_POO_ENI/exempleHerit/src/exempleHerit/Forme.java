package exempleHerit;

import java.awt.Color;

public abstract class Forme {
	protected Color couleur;
	//CONSTRUCTOR
	public Forme(Color couleur) {
		this.couleur = couleur;
	}
	//METHODS
		public abstract double calculAire();
	
	//GET SET
	public Color getCouleur() {
		return couleur;
	}
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	//toString METHOD
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Forme [couleur=");
		builder.append(couleur);
		builder.append("]");
		return builder.toString();
	}	
	
}
