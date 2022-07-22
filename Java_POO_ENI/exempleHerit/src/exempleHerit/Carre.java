package exempleHerit;
import java.awt.Color;

public class Carre extends Forme {
	private int cote;
	//CONSTRUCTOR
	public Carre(Color couleur, int cote) {
		super(couleur);
		this.cote = cote;
	}
		
	public double aire () {
		return cote*cote;
	}
	//GET SET
	public int getCote() {
		return cote;
	}
	public void setCote(int cote) {
		this.cote = cote;
	}
	

}
