package fr.eni.ecole;

import java.util.Scanner;

public class TestEnumeration {
	
	public static void main(String[] args) {
		//Print une valeur de l'énumeration Groupe
		System.out.println(Groupe.MAUVE);
		//Print toutes les valeurs de l'énumération Groupe
		for(Groupe groupe : Groupe.values()) {
			System.out.println(groupe);
		}
		//Saisie utilisateur
		System.out.println("Quel groupe ?");
		Scanner sc = new Scanner(System.in);
		String saisie = sc.next();
		//
		for(Groupe groupe : Groupe.values()) {
			boolean ok = false;
			//Si saisie = le nom de l'élément du groupe -> Print "L'élément fait bien parti de l'énumération" + Break (sortie de boucle)
			if(saisie.equalsIgnoreCase(groupe.name())) {
				ok = true;
				System.out.println("L'élément fait bien parti de l'énumération");
				break;
			}else System.out.println("L'élément ne fait pas partu de l'énumération");
			sc.close();
		}
			
		//Ajouter la propriété Montparnasse au groupe gare
		Groupe.GARE.ajouter("Montparnasse");
		Groupe.GARE.ajouter("Gare de Lyon");
		//Affichage du contenu de GARE
		for(String gare : Groupe.GARE.getProp()) {
			System.out.println(gare);
		}	
		
		//--------

	}
}
