
public class Rectangle implements Forme{

	private float longeur;
	private float largeur;
	
	
	
	public Rectangle(float longeur, float largeur) {
		this.longeur = longeur;
		this.largeur = largeur;
	}


	public double calculerAire() {
	
		return getLargeur() * getLongeur();
	}



	public float getLongeur() {
		return longeur;
	}



	public void setLongeur(float longeur) {
		this.longeur = longeur;
	}



	public float getLargeur() {
		return largeur;
	}



	public void setLargeur(float largeur) {
		this.largeur = largeur;
	}


	@Override
	public String toString() {
		return "Rectangle [longeur=" + longeur + ", largeur=" + largeur + "]";
	}
	
	
}
