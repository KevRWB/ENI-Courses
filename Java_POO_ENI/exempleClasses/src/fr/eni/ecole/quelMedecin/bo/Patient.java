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
		//System.out.println(format.format(dateNaissance));
		//Autre formatage de date
		//System.out.printf("Date de naissance : %02d %s %d%n" , this.dateNaissance.getDayOfMonth(), 
		//						this.dateNaissance.getMonth().getDisplayName(TextStyle.FULL, Locale.FRANCE),  
		//						this.dateNaissance.getYear());	
		System.out.print("Commentaires : ");
		if(this.commentaire == null) {
			System.out.print("[Aucun commentaire]");
		}else {
			System.out.print(this.commentaire);
		}
		System.out.println();
		//print adresse
		this.adresse.afficher();
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the sexe
	 */
	public char getSexe() {
		return sexe;
	}

	/**
	 * @param sexe the sexe to set
	 */
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	/**
	 * @return the numSecu
	 */
	public long getNumSecu() {
		return numSecu;
	}

	/**
	 * @param numSecu the numSecu to set
	 */
	public void setNumSecu(long numSecu) {
		this.numSecu = numSecu;
	}

	/**
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * @return the commentaire
	 */
	public String getCommentaire() {
		return commentaire;
	}

	/**
	 * @param commentaire the commentaire to set
	 */
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
}
