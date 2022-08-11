package fr.eni.blagues.bo;

public class Blague {
	
	private int idBlague;
	private String libelle;
	private float note;
	private int nbNotes;
	
	//Constructor
	public Blague(String txtBlague, float note) {
		super();
		this.libelle = txtBlague;
		this.note = note;
	}
	

	public Blague(String libelle, float note, int nbNotes) {
		super();
		this.libelle = libelle;
		this.note = note;
		this.nbNotes = nbNotes;
	}


	public Blague() {}

	//Getters Setters
	public int getIdBlague() {
		return idBlague;
	}
	public String getTxtBlague() {
		return libelle;
	}
	public void setTxtBlague(String libelle) {
		this.libelle = libelle;
	}
	public float getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public int getNbNotes() {
		return nbNotes;
	}
	public void setNbNotes(int nbNotes) {
		this.nbNotes = nbNotes;
	}
	

}
