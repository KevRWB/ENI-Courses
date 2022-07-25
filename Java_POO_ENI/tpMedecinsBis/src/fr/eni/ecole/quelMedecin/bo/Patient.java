package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Patient extends Personne{

	private char sexe;
	private long numSecu;
	private LocalDate dateNaissance;
	private String commentaire;

	
	//CONSTRUCTOR
	public Patient(String nom, String prenom, String numTel, char sexe, long numSecu,
			LocalDate dateNaissance, String commentaire, Adresse adresse) {
		super(nom, prenom, numTel, adresse);
	
		this.sexe = sexe;
		this.numSecu = numSecu;
		this.dateNaissance = dateNaissance;
		this.commentaire = commentaire;

		
	}
	//METHODS
	public void afficher() {
		System.out.println(toString());
		System.out.println("Adresse : ");
		this.adresse.afficher();
	}
	
	//ToString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("Sexe : ");
		if(this.sexe == 'M') {
			builder.append("Masculin");
		} else builder.append("Féminin");
		builder.append(String.format("%n"));
		builder.append("Numéro de sécurité sociale : ");
		builder.append(numSecu);
		builder.append(String.format("%n"));
		builder.append("Date de naissance : ");
		DateTimeFormatter dateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		builder.append(dateNaissance.format(dateFormat));
		builder.append(String.format("%n"));
		builder.append("Commentaire : ");
		if(this.commentaire == null) {
			builder.append("[Aucun commentaire]");
		}else {
			builder.append(commentaire);
		}

		return builder.toString();
	}

}
