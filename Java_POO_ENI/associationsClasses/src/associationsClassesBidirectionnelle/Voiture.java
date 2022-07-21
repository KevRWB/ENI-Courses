package associationsClassesBidirectionnelle;

public class Voiture {
	
	private int numSerie;
	private String couleur;
	private Individu[]  proprietaires = new Individu[10];
	private int nbProprio;
	private static int[]listNumSeries=new int[100];
	private static int nbVoituresCrees = 0;
	//CONSTRUCTEUR
	public Voiture(int numSerie, String couleur) throws Exception {
		super();
		Voiture.verifNumSerie(numSerie);
		this.numSerie = numSerie;
		Voiture.listNumSeries[nbVoituresCrees] = this.numSerie;
		this.couleur = couleur;
		nbProprio = 0;
		this.nbVoituresCrees ++;
		
	}
	//METHODS
	private static void verifNumSerie(int num) throws Exception {
		for (int i = 0; i < listNumSeries.length; i++) {
			if(num == listNumSeries[i]) {
				throw new Exception("Le numéro se série existe déjà");
			}
		}
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
		builder.append("Voiture [numSerie :");
		builder.append(numSerie);
		builder.append(", couleur :");
		builder.append(couleur);
		if(this.nbProprio > 0) {
			builder.append(String.format("%nPropriétaire(s) : %n"));
			for(int i = 0; i < nbProprio; i++) {
				builder.append("Prenom : " + proprietaires[i].getPrenom() + " ");
				builder.append("Nom : " + proprietaires[i].getNom());	
				builder.append(String.format("%n"));
			}
		}
		builder.append("]");
		return builder.toString();
	}
	
	
}
