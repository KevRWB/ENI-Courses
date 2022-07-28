package poo.exoUn;

public class Livre extends Article {

	private int isbn;
	private int nbPages;
	private Personne auteur;
	//Constructor
	public Livre(String ref, String designation, int prix, int isbn, int nbPages, Personne auteur) {
		super(ref, designation, prix);
		this.isbn = isbn;
		this.nbPages = nbPages;
		this.auteur = auteur;
	}
	
	//GETTERS SETTERS
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public int getNbPages() {
		return nbPages;
	}
	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}
	public Personne getAuteur() {
		return auteur;
	}
	public void setAuteur(Personne auteur) {
		this.auteur = auteur;
	}
	//ToString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Livre [isbn=");
		builder.append(isbn);
		builder.append(", nbPages=");
		builder.append(nbPages);
		builder.append(", auteur=");
		builder.append(auteur);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
