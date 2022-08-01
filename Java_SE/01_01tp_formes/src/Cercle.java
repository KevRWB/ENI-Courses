
public class Cercle implements Forme{

	float rayon;
	
	public Cercle(float rayon) {
		super();
		this.rayon = rayon;
	}

	public double calculerAire() {
		return (float) (Math.PI * getRayon() * getRayon());
	}

	public float getRayon() {
		return rayon;
	}

	public void setRayon(float rayon) {
		this.rayon = rayon;
	}
	@Override
	public String toString() {
		return "Cercle [rayon=" + rayon + "]";
	}
	
	

}
