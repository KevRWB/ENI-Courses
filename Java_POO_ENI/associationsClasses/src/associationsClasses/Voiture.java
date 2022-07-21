package associationsClasses;

public class Voiture {
	
	private int numSerie;
	private String couleur;
	private Individu[] proprietaires = new Individu[10];
	private int nbProprio;
	//CONSTRUCTEUR
	public Voiture(int numSerie, String couleur) {
		super();
		this.numSerie = numSerie;
		this.couleur = couleur;
		nbProprio = 0;
	}
	//GETTERS / SETTERS
	public Individu[] getProprietaires() {
		return proprietaires;
	}
	public void ajouterProprio(Individu proprio) {
		proprietaires[nbProprio] = proprio;
		this.nbProprio ++;		
	}
	public int getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(int numSerie) {
		this.numSerie = numSerie;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	//ToSTRING
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Voiture [numSerie=");
		builder.append(numSerie);
		builder.append(", couleur=");
		builder.append(couleur);
		for(int i = 0; i <= this.nbProprio; i++){	
			builder.append(", proprietaire[");
			builder.append(i+1);
			builder.append("]");
			builder.append(this.proprietaires[i]);
			i++;
		}
		builder.append("]");
		return builder.toString();
	}
	
	
}
