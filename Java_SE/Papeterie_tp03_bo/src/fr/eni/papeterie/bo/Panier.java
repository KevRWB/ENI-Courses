package fr.eni.papeterie.bo;

import java.util.ArrayList;
import java.util.List;

public class Panier {
	private float montant;
	private List<Ligne> lignes;
	
	//Constructor
	public Panier() {
		lignes = new ArrayList<Ligne>();
	}
	
	//Methods
	public void addLigne(Article article, int qte) {
		lignes.add(new Ligne(article, qte));
	}
	
	public void removeLigne( int index) {
		lignes.remove(index);
	}
	
	public void updateLigne(int index, int newQte) {
		lignes.get(index).setQte(newQte);
	}
	
	//Getters Setters
	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public List<Ligne> getLignesPanier() {
		return lignes;
	}
	public Ligne getLigne(int index) {
		return lignes.get(index);
	}

	public void setLignes(List<Ligne> lignes) {
		this.lignes = lignes;
	}

	//ToString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("Panier :%n"));
		for(int i = 0; i < lignes.size(); i++) {
			builder.append(String.format("Ligne : " + i + " " + lignes.get(i) ));
		}
		builder.append(String.format("%n Valeur du panier : %.2f ", montant));
		
		return builder.toString();
	}
	
	
	
	
	
}
