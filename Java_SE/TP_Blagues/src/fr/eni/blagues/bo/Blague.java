package fr.eni.blagues.bo;

public class Blague {
	
	private int idBlague;
	private String libelle;
	private float note;
	private int nbNotes;
	
	//Constructor
	public Blague(String txtBlague) {
		super();
		this.libelle = txtBlague;
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
	
	public void setIdBlague(int idBlague) {
		this.idBlague = idBlague;
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
	public void setNote(float note) {
		this.note = note;
	}
	public int getNbNotes() {
		return nbNotes;
	}
	public void setNbNotes(int nbNotes) {
		this.nbNotes = nbNotes;
	}
	

}
