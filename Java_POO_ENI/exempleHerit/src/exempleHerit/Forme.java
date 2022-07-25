package exempleHerit;

import java.awt.Color;

public class Forme {
	protected Color couleur;
	//CONSTRUCTOR
	public Forme(Color couleur) {
		this.couleur = couleur;
	}
	//METHODS
		public String calculAire() {
			return "Je ne sais pas calculer l'aire d'un forme quelconque";
		}
	
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
