package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.Locale;

public class Patient {
	private String nom;
	private String prenom;
	private String tel;
	private char sexe;
	private long numSecu;
	private LocalDate dateNaissance;
	private String commentaire;
	private Adresse adresse;
	
	public Patient(String nom, String prenom, String tel, char sexe, long numSecu, LocalDate dateNaissance, String commentaire, Adresse adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.sexe = sexe;
		this.numSecu = numSecu;
		this.dateNaissance = dateNaissance;
		this.commentaire = commentaire;
		this.adresse = adresse;
	}
	
	//METHODS
	public void afficher() {
		System.out.println(this.nom.toUpperCase() + " " + this.prenom);
		System.out.println("Téléphone : " + this.tel);
		if (this.sexe == 'F') {
			System.out.println("Sexe : Féminin");
		}else {
			System.out.println("Sexe : Masculin");
		}
		System.out.println("Numéro de sécurité sociale : " + this.numSecu);
		
		//Creation formatage Date
		DateTimeFormatter format = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(dateNaissance));
		System.out.println(format.format(dateNaissance));
		//Autre formatage de date
		System.out.printf("Date de naissance : %02d %s %d%n" , this.dateNaissance.getDayOfMonth(), 
								this.dateNaissance.getMonth().getDisplayName(TextStyle.FULL, Locale.FRANCE),  
								this.dateNaissance.getYear());		
		if(this.commentaire == null) {
			System.out.println("[Aucun commentaire]");
		}else {
			System.out.println("Commentaires : " + this.commentaire);
		}
		
		//print adresse
		this.adresse.afficher();
	}
}
