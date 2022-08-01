package fr.eni.tpAnnuaire;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Annuaire {
	
	//initialisation de la Map anniaire
	private Map<String, Contact> listAnnuaire = new HashMap<>();
	
	//---METHODS
	public void interfaceAnnuaire(Scanner scanner) {
		
		
		Map<String, Contact> listAnnuaire =this.getListAnnuaire();
		String nom;
		String tel;
		
		boolean exitProg = false;
		
		while(!exitProg) {
			System.out.println("ANNUAIRE");
			System.out.println("Ajouter contact : add ");
			System.out.println("Voir contact : voir");
			System.out.println("Changer numéro téléphone : change");
			System.out.println("Supprimer contact : supp");
			System.out.println("Afficher l'ensemble de l'annuaire : all");
			System.out.println("Quitter : q");
			String input = scanner.nextLine();
			
			switch (input) {
			case "add":
				System.out.println("Veuillez saisir un nom  :");
				nom = scanner.nextLine();
				System.out.println("Veuillez saisir un numéro de téléphone :");
				tel = scanner.nextLine();			
				listAnnuaire.put(nom, new Contact(nom, tel));				
				System.out.println(this.afficherContact(nom));
					
				break;
			case "voir":
				System.out.println("Veuillez saisir le nom du contact :");
				nom = scanner.nextLine();		
				System.out.println(this.afficherContact(nom));
				
				break;
			case "change":
				System.out.println("Veuillez entrer un nom :");
				nom = scanner.nextLine();
				System.out.println("Veuillez saisir un nouveau numéro de téléphone :");
				tel = scanner.nextLine();
				
				this.modifierTel(nom, tel);
				
				break;
			case "all":
				System.out.println("Liste complète de l'annuaire :");
				afficherAnnuaire();
				break;
			case "q": exitProg = true;
				break;

			default: System.out.println("Je n'ai pas compris votre saisie");
				break;
			}				
		}
		System.out.println("Au revoir");
		
		scanner.close();
	}
	
	public void ajouterContact(String nom, String num) {
		boolean trouve = false;
		for(String key : this.listAnnuaire.keySet()) {
			if(nom.equals(this.listAnnuaire.get(key).getNom())) {
				trouve = true;
			}
		}
		if(!trouve) listAnnuaire.put(nom, new Contact(nom, num));
		else System.out.println("Nom déjà présent");
		
	}
	
	public void supprimerContact(String nom) {
		listAnnuaire.remove(nom);
	}
	
	public void modifierTel(String nom, String num) {
		listAnnuaire.get(nom).setNumeroTel(num);;
	}
	
	public String afficherContact(String nom) {
		return listAnnuaire.get(nom).toString();
	}
	
	public void afficherAnnuaire() {
		for(Map.Entry<String, Contact> pair : listAnnuaire.entrySet()) {
			System.out.println(pair.getKey() + " " + pair.getValue());
		}
	}
	
	//Getters setters
	public Map<String, Contact> getListAnnuaire() {
		return listAnnuaire;
	}

	public void setListAnnuaire(Map<String, Contact> listAnnuaire) {
		this.listAnnuaire = listAnnuaire;
	}
	
	
	
	
}
