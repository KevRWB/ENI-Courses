package fr.eni.ecole.jeuDeDes;

import java.util.Random;

public class De {
	
	private int nbFaces;
	private int faceTiree;	
	private static Random rnd = new Random();
	
	//CONSTRUCTEUR
	public De(int nbFaces) throws Exception{
		this.setNbFaces(nbFaces); // set nbFace avec la method setNbFace
		this.faceTiree = lancer(); // initialise faceTiree par un lancer
	}
	//CONSTRUCTEUR par default
	public De() throws Exception{
		this(6); // this (constructeur existant)  (6) spécifié par le nombre d'arguments
	}
	
	//METHODS
	//getter nbFaces - accès en lecture
	public int getNbFaces() {
		return this.nbFaces; //this -> Accès à la la l'attribut d'instance
	}	
	//setter nbFaces - Accès en écriture - avec method de verification Exception
	public void setNbFaces(int nbFaces)throws Exception{ 
		verifNbFaces(nbFaces);
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
	
	//verification nombre faces - method de class static privée
	private static void verifNbFaces(int nbFaces) throws Exception{
		if(nbFaces <=1) {
			throw new Exception("Un dé a minimum deux faces");
		}
	}
}	
