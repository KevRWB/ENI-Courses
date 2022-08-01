
public class Triangle implements Forme{
	
	float base;
	float hauteur;
	

	public Triangle(float base, float hauteur) {
		this.base = base;
		this.hauteur = hauteur;
	}


	public double calculerAire() {
		
		return getBase() * getHauteur() / 2;
	}


	public float getBase() {
		return base;
	}

	public String toString() {
		return "Triangle [base=" + base + ", hauteur=" + hauteur + "]";
	}


	public void setBase(float base) {
		this.base = base;
	}


	public float getHauteur() {
		return hauteur;
	}


	public void setHauteur(float hauteur) {
		this.hauteur = hauteur;
	}
	
}
