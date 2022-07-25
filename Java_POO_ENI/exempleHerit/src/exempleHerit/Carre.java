package exempleHerit;
import java.awt.Color;

public class Carre extends Forme {
	private int cote;
	//CONSTRUCTOR
	public Carre(Color couleur, int cote) {
		//fait appel au constructeur du parent -> Toujours en première position
		super(couleur);
		this.cote = cote;
	}
	@Override	
	public double calculAire () {
		return cote*cote;
	}
	//GET SET
	public int getCote() {
		return cote;
	}
	public void setCote(int cote) {
		this.cote = cote;
	}
	//ToString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		//fait appel ) la methode toString du parent
		builder.append(super.toString());
		builder.append("Carre [cote=");
		builder.append(cote);
		builder.append("]");
		return builder.toString();
	}
	
	
}
