package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class RendezVous {
	Creneau creneau;
	Patient patient;
	LocalDate date;
	//Constructor
	public RendezVous(Creneau creneau, Patient patient, LocalDate date) {
		super();
		this.creneau = creneau;
		this.patient = patient;
		this.date = date;
	}
	//METHODS
	//AFFICHER
	public void afficher() {
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		System.out.println("Rendez-vous le " + date.format(formatter) + " - " + creneau.afficher() );	
		System.out.println("Avec le Dr " + creneau.getMedecin().getNom());
		System.out.println("Pour ");
		patient.afficher();
		
	}
	
	/**
	 * @return the creneau
	 */
	public Creneau getCreneau() {
		return creneau;
	}
	/**
	 * @param creneau the creneau to set
	 */
	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}
	/**
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}
	/**
	 * @param patient the patient to set
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
}
