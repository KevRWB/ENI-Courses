package fr.eni.ecole.jeuDeDes;

import java.util.Random;

public class De {
	
	private int nbFaces;
	private int faceTiree;	
	private static Random rnd = new Random();
	
	//Methods	
	//getter nbFaces - accès en lecture
	public int getNbFaces() {
		return this.nbFaces; //this -> Accès à la la l'attribut d'instance
	}	
	//setter nbFaces - Accès en écriture
	public void setNbFaces(int nbFaces)throws Exception{ 
		if(nbFaces<=0) {
			//retourne erreur
			throw new Exception("Un dé doit au moins avoir 1 face");
		}	//si exception, suite n'est pas executée
			this.nbFaces = nbFaces;	
	}	
	//Lancer de dé
	public int lancer() {
		//De.rnd -> Attribut de class - static -> A porté de class
		return this.faceTiree = De.rnd.nextInt(this.nbFaces) + 1;
	}	
	//Getter faceTiree
	public int getFaceTiree() {
		return this.faceTiree;
	}
}	
