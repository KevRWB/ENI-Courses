package fr.eni.papeterie.bo;

import java.util.ArrayList;
import java.util.List;

public class Panier {

	private List<Ligne> lignesPanier;
	
	private float montant;

	public Panier() {
		lignesPanier = new ArrayList<Ligne>();
	}

	public float getMontant() {
		return montant;
	}

	public List<Ligne> getLignesPanier() {
		return lignesPanier;
	}
	
	public Ligne getLigne(int index) {
		return lignesPanier.get(index);
	}
	
	public void addLigne(Article article, int qte) {
		//1. on crée la ligne
		Ligne nouvelleLigne = new Ligne(article, qte);
		//2. on l'ajoute à la liste (!! bien initialiser la liste avant !!)
		lignesPanier.add(nouvelleLigne);
	}
	
	public void updateLigne(int index, int newQte) {
		lignesPanier.get(index).setQte(newQte);
	}
	
	public void removeLigne(int index) {
		lignesPanier.remove(index);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Panier :")
				.append(System.lineSeparator());
		for(int i = 0 ; i < lignesPanier.size() ; i++) {
			builder.append("ligne ")
					.append(i)
					.append(" :\t")
					.append(lignesPanier.get(i))
					.append(System.lineSeparator());
		}
		builder.append(System.lineSeparator());
		builder.append("Valeur du panier : ");
		builder.append(montant);
		return builder.toString();
	}
	
}
