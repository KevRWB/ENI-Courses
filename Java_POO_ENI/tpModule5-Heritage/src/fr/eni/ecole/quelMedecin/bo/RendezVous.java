package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class RendezVous {
private Creneau creneau;
private Patient patient;
private LocalDate date;
public RendezVous(Creneau creneau, Patient patient, LocalDate date) {
	this.creneau = creneau;
	this.patient = patient;
	this.date = date;
}
public Creneau getCreneau() {
	return creneau;
}
public void setCreneau(Creneau creneau) {
	this.creneau = creneau;
}
public Patient getPatient() {
	return patient;
}
public void setPatient(Patient patient) {
	this.patient = patient;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("RendezVous [creneau=");
	builder.append(creneau);
	builder.append(", patient=");
	builder.append(patient);
	builder.append(", date=");
	builder.append(date);
	builder.append("]");
	return builder.toString();
}
public void afficher() {
	// TODO Auto-generated method stub
	StringBuilder sb = new StringBuilder();
	sb.append("Rendez-vous du ");
	DateTimeFormatter format = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
	sb.append(this.getDate().format(format));//23 mai 2020  (15 minutes)))
	sb.append(" ");
	sb.append(this.creneau);//09:00 - 09:15
	sb.append(" ");
	sb.append(String.format("%n"));
	sb.append("avec le Dr ");
	sb.append(this.creneau.getMedecin().getNom());
	sb.append(String.format("%n"));
	sb.append("pour ");
	sb.append(this.patient);
	System.out.println(sb.toString());
}

}
