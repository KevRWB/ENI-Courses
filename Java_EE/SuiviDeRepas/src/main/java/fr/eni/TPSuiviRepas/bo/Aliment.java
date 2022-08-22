package fr.eni.TPSuiviRepas.bo;

public class Aliment {
	private int id;
	private String nom;
	private int idRepas;
	
	
	public Aliment(String nom) {
		this.nom = nom;
	}


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


	public int getIdRepas() {
		return idRepas;
	}


	public void setIdRepas(int idRepas) {
		this.idRepas = idRepas;
	}
	
	
	
	
}
