package fr.eni.tpAnnuaire;

import java.util.Map;
import java.util.Scanner;

public class TestAnnuaire {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		
		Annuaire annuaire = new Annuaire();
		Map<String, Contact> listAnnuaire =annuaire.getListAnnuaire();
		String nom;
		String tel;
		
		while(true) {
			System.out.println("ANNUAIRE");
			System.out.println("Ajouter contact : add ");
			System.out.println("Voir contact : voir");
			System.out.println("Changer numéro téléphone : change");
			System.out.println("Supprimer contact : supp");
			System.out.println("Quitter : q");
			String input = scanner.nextLine();
			
			
			switch (input) {
			case "add":
				System.out.println("Veuillez entrer un nom et un numero de telephone :");
				nom = scanner.nextLine();
				tel = scanner.nextLine();			
				listAnnuaire.put(nom, new Contact(nom, tel));				
				System.out.println(annuaire.afficherContact(nom));
					
				break;
			case "voir":
				System.out.println("Veuillez saisir le nom du contact :");
				nom = scanner.nextLine();		
				System.out.println(annuaire.afficherContact(nom));
				
				break;
			case "change":
				System.out.println("Veuillez entrer un nom et un nouveau numero de telephone :");
				nom = scanner.nextLine();
				tel = scanner.nextLine();
				
				annuaire.modifierTel(nom, tel);
				
				break;
			case "supp":
				System.out.println("Veuillez entrer un nom de contact a supprimer:");
				nom = scanner.nextLine();
				annuaire.supprimerContact(nom);
				break;
			case "q": break;

			default: System.out.println("Je n'ai pas compris votre saisie");
				break;
			}
			
			if(input == "q") {
				System.out.println("Au revoir");
				break;
			}
			
		}
		
	}
}
