package poo.exoUn;

public class Dvd extends Article {

	private int duree;
	private Personne realisateur;
	
	//Constructeur
	public Dvd(String ref, String designation, int prix, int duree, Personne realisateur) {
		super(ref, designation, prix);
		this.duree = duree;
		this.realisateur = realisateur;
	}
	
	//GETTERS SETTERS
	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Personne getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(Personne realisateur) {
		this.realisateur = realisateur;
	}

	
	//ToString method
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dvd [duree=");
		builder.append(duree);
		builder.append(", realisateur=");
		builder.append(realisateur);
		builder.append("]");
		return builder.toString();
	}
	
	

}
