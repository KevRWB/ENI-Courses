package fr.eni.demoGenericite;

import java.util.ArrayList;
import java.util.List;

//Creation d'une classe generique - "T" est un argument qui peut prendre plusieurs types en fonction de l'usage que l'on en fera
public class Ferme<T> { // <T, U, V> multiples générique  - T extends Vehicule & Comparable & Cloneable - D'abord Class puis Interface dans la déclaration

	private String nom;
	
	//CONSTRUCTOR
	public Ferme(String nom) {
		this.nom = nom;
	}
	
	//Déclaration et initialisation d'une liste de "T" call etresVivants - Peut contenir différents objets de différents types (Animal, Stagiaire...)
	List<T> etresVivants = new ArrayList<T>();
	
	//Methode ajouter un Objet T
	public void ajouter(T valeur) {
		etresVivants.add(valeur);
	}
	
	//toString
	@Override
	public String toString() {
		return etresVivants.toString();
	
	}
	//Getters
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<T> getEtresVivants() {
		return etresVivants;
	}

	public void setEtresVivants(List<T> etresVivants) {
		this.etresVivants = etresVivants;
	}
	
	
}
