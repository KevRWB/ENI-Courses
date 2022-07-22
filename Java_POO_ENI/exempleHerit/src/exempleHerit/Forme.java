package exempleHerit;

import java.awt.Color;

public class Forme {
	protected Color couleur;
	//CONSTRUCTOR
	public Forme(Color couleur) {
		super();
		this.couleur = couleur;
	}
	//GET SET
	public Color getCouleur() {
		return couleur;
	}
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}	
}
