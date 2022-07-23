package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Patient {
private String nom;
private String prenom;
private String numTel;
private char sexe;
private long numeroSecu;
private LocalDate dateNais;
private String allergie;
public Patient(String nom, String prenom, String numTel, char sexe, long numeroSecu, LocalDate dateNais,
		String allergie) {
	this.nom = nom;
	this.prenom = prenom;
	this.numTel = numTel;
	this.sexe = sexe;
	this.numeroSecu = numeroSecu;
	this.dateNais = dateNais;
	this.allergie = allergie;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getNumTel() {
	return numTel;
}
public void setNumTel(String numTel) {
	this.numTel = numTel;
}
public char getSexe() {
	return sexe;
}
public void setSexe(char sexe) {
	this.sexe = sexe;
}
public long getNumeroSecu() {
	return numeroSecu;
}
public void setNumeroSecu(long numeroSecu) {
	this.numeroSecu = numeroSecu;
}
public LocalDate getDateNais() {
	return dateNais;
}
public void setDateNais(LocalDate dateNais) {
	this.dateNais = dateNais;
}
public String getAllergie() {
	return allergie;
}
public void setAllergie(String allergie) {
	this.allergie = allergie;
}
public void afficher() {
	System.out.println(this.toString()); // ????????????????????????????????????????
}
@Override // ??????????????????????????????????????
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append(nom);
	builder.append(" ");
	builder.append(prenom);
	builder.append(String.format("%n"));
	builder.append("Téléphone : ");
	builder.append(numTel);
	builder.append(String.format("%n"));
	builder.append("Sexe : ");
	if (sexe=='F') {
		builder.append("Féminin");
	}
	else
	{
		builder.append("Masculin");
	}
	builder.append(String.format("%n"));
	builder.append("Numéro de Sécurité sociale : ");
	builder.append(numeroSecu);
	builder.append(String.format("%n"));
	builder.append("Date de naissance : ");
//	DateTimeFormatter monFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	DateTimeFormatter monFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
	builder.append(dateNais.format(monFormat));
	builder.append(String.format("%n"));
	builder.append("Commentaires : ");
	if (allergie==null) {
		builder.append("[aucun commentaire]");
	}
	else {
	builder.append(allergie);
	}
	return builder.toString();
}

}
