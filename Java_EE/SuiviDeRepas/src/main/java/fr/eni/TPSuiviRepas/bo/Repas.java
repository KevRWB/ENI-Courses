package fr.eni.TPSuiviRepas.bo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Repas {
	private int id;
	private LocalDate date;
	private LocalTime heure;
	private  List<Aliment> listeAliments = new ArrayList<>();
	
	
	
	
	public Repas(LocalDate date, LocalTime heure, List<Aliment> listeAliments) {
		super();
		this.date = date;
		this.heure = heure;
		this.listeAliments = listeAliments;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public List<Aliment> getListeAliments() {
		return listeAliments;
	}
	public void setListeAliments(List<Aliment> listeAliments) {
		this.listeAliments = listeAliments;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getHeure() {
		return heure;
	}
	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}
	
	

}
