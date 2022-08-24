package fr.eni.tpGestionListesCourses.bo;

import java.util.ArrayList;
import java.util.List;

public class Liste {
	private int idListe;
	private String nom;
	private List<Article> listeArticles = new ArrayList<>();
	
	public Liste(String nom) {
		super();
		this.nom = nom;
	}

	public Liste() {
		super();
	}

	public int getIdListe() {
		return idListe;
	}

	public void setIdListe(int idListe) {
		this.idListe = idListe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Article> getListeArticles() {
		return listeArticles;
	}

	public void setListeArticles(List<Article> listeArticles) {
		this.listeArticles = listeArticles;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Liste [idListe=");
		builder.append(idListe);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", listeArticles=");
		builder.append(listeArticles);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
