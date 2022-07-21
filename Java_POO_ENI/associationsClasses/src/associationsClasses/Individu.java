package associationsClasses;

public class Individu {
	private String prenom;
	private String nom;
	private Voiture voiture;
	//CONSTRUCTEUR
	public Individu(String prenom, String nom) {
		super();
		this.prenom = prenom;
		this.nom = nom;
	}
	//GETTERS / SETTERS	
	public String getPrenom() {
		return prenom;
	}
	public Voiture getVoiture() {
		return voiture;
	}
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	//ToString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Individu [prenom=");
		builder.append(prenom);
		builder.append(", nom=");
		builder.append(nom);
		if(this.voiture!= null) {
			builder.append(", Voiture=");
			builder.append(voiture);
		}
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
