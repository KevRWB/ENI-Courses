package fr.eni.tpGestionListesCourses.bo;

public class Article {
	private int idArticle;
	private String nom;
	private int idListe;
	private boolean coche;
	
	
	public Article(String nom, int idListe) {

		this.nom = nom;
		this.idListe = idListe;
	}
	public Article() {
		super();
	}
	public int getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getIdListe() {
		return idListe;
	}
	public void setIdListe(int idListe) {
		this.idListe = idListe;
	}
	public boolean isCoche() {
		return coche;
	}
	public void setCoche(boolean coche) {
		this.coche = coche;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Article [idArticle=");
		builder.append(idArticle);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", idListe=");
		builder.append(idListe);
		builder.append(", coche=");
		builder.append(coche);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	

}
