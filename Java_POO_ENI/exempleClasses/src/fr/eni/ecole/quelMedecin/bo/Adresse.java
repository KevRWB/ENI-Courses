package fr.eni.ecole.quelMedecin.bo;

public class Adresse {
	private String mentionComp = null;
	private int numVoie;
	private String mentionCompNum = null;
	private String nomVoie;
	private int CP;
	private String ville;
	
	//Constructeur 1
	public Adresse(String mentionComp, int numVoie, String mentionCompNum, String nomVoie, int CP, String ville) {
		this.mentionComp = mentionComp;
		this.numVoie = numVoie;
		this.mentionCompNum = mentionCompNum;
		this.nomVoie = nomVoie;
		this.CP = CP;
		this.ville = ville.toUpperCase();
	}
	// Constructeur 2
	public Adresse( int numVoie, String typeVoie, String nomVoie, int CP, String ville) {
		this.numVoie = numVoie;
		this.nomVoie = nomVoie;
		this.CP = CP;
		this.ville = ville.toUpperCase();
	}
	
	//METHODS
	
	//Fonction afficher les adresses
	public void afficher() {
		// Si mentions complémentaires -> 
		if(this.mentionComp == null && this.mentionCompNum == null) {
			System.out.println(this.numVoie+ " " + (this.nomVoie));
			System.out.println(String.format("%05d %s", this.CP, this.ville));
		// SI pas de mention complémentaire -> 
		}else {
			System.out.println(this.mentionComp);
			System.out.println(this.numVoie+ " " + (this.mentionCompNum)+ " " + (this.nomVoie));
			System.out.println(String.format("%05d %s", this.CP, this.ville));
		}
	}
}
