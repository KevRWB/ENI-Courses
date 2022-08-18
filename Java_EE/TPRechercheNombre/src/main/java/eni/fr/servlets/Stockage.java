package eni.fr.servlets;

public class Stockage {
	private static int nbJoueur;
	
	public static void setnbJoueurs(int nb) {
		nbJoueur = nb;
	}
	public static int getNbJoueurs() {
		return nbJoueur;
	}
	
}
