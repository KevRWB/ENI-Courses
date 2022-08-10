package fr.eni.projeteliot.bo;

import java.time.LocalDate;

public class Personnage {

	private int id;
	
	private String nom;
	
	private LocalDate dateNaissance;
	
	private Race race;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}
	
	public Personnage() {	}

	public Personnage(String nom, LocalDate dateNaissance, Race race) {
		this();
		this.nom = nom;
		this.dateNaissance = dateNaissance;
		this.race = race;
	}
	
	public Personnage(int id, String nom, LocalDate dateNaissance, Race race) {
		this(nom, dateNaissance, race);
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Personnage [id=");
		builder.append(id);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", dateNaissance=");
		builder.append(dateNaissance);
		builder.append(", race=");
		builder.append(race);
		builder.append("]");
		return builder.toString();
	}
	
	
}
