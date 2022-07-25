package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class RendezVous {
	private Creneau creneau;
	private Patient patient;
	private LocalDate date;
	//CONSTRUCTOR
	public RendezVous(Creneau creneau, Patient patient, LocalDate date) {
		super();
		this.creneau = creneau;
		this.patient = patient;
		this.date = date;
	}
	
	//AFFICHER
	public void afficher() {
		DateTimeFormatter format = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		System.out.print("Rendez-vous du " + date.format(format) + " ");
		this.creneau.afficher();
		System.out.println("avec le Dr " + creneau.getMedecin().getNom());
		System.out.println("Pour ");
		this.patient.afficher();
		
	}
	
	
}
