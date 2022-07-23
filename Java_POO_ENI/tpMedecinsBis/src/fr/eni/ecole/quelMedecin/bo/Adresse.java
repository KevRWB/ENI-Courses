package fr.eni.ecole.quelMedecin.bo;

public class Adresse {
	private String mentionComp = null;;
	private int numero;
	private String mentionCompNum;
	private String nomVoie;
	private int codePostal;
	private String ville;
	
	//CONSTRUCTOR FULL
	public Adresse(String mentionComp, int numero, String mentionCompNum, String nomVoie, int codePostal,
			String ville) {
		super();
		this.mentionComp = mentionComp;
		this.numero = numero;
		this.mentionCompNum = mentionCompNum;
		this.nomVoie = nomVoie;
		this.codePostal = codePostal;
		this.ville = ville.toUpperCase();
	}
	//CONSTRUCTOR LESS "Mentions complémentaires"
	public Adresse(int numero, String mentionCompNum, String nomVoie, int codePostal, String ville) {
		super();
		this.numero = numero;
		this.mentionCompNum = mentionCompNum;
		this.nomVoie = nomVoie;
		this.codePostal = codePostal;
		this.ville = ville.toUpperCase();
	}
	//METHODS
	public void afficher() {
		System.out.println(toString());
	}
	
	//toString method
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if(mentionComp != null) {
			builder.append(mentionComp);
			builder.append(String.format("%n"));
		}
		builder.append(numero);
		if(mentionComp != null) {
			builder.append(mentionCompNum);
		}
		builder.append(" " + nomVoie);
		builder.append(String.format("%n"));
		builder.append(codePostal);
		builder.append(" " + ville);
		
		return builder.toString();
	}
	
	
	
	
}


