package exoEni;

import java.util.Scanner;

public class ListeInvite {

		static Scanner input = new Scanner(System.in);
		static int nbGuests = 0;
	
	public static void main(String[] args) {
			
		//finals
		final int TABLE_SIZE = 500;
		//variables
		String[] liste = new String[TABLE_SIZE];
		
		String name;
		int continuer;
		
		//---PROGRAM
		
		do {
			// saisir utilisateur
			System.out.println("Saisir le nom de l'invité:");
			name = input.nextLine();
			
			//add user input in the table / incrémente nombre de noms inséré
			liste[nbGuests] = name;
			nbGuests++;
			
			//---continuer ou non ?
			System.out.println("Souhaitez-vous saisir un autre nom ?");
			System.out.println("1- Oui");
			System.out.println("2- Non");
			System.out.println("Votre choix:");
			continuer = input.nextInt();
			while(continuer != 1 && continuer != 2) {
				System.out.println("Veuillez saisir 1(oui) ou 2(non)");
				continuer = input.nextInt();
			}
			input.nextLine();
			
			
		}while(continuer == 1 && nbGuests <= TABLE_SIZE);
		
		//--fin saisie
		System.out.println("Votre saisie est terminée");
		
		//---classer liste par ordre alphabétiquet
		sortByNames(liste);
		//--afficher liste invités
		printGuestList(liste);
		
		//---recherche nom dans la liste
		System.out.println("Souhaitez-vous chercher un nom dans la liste ?");
		System.out.println("1- Oui");
		System.out.println("2- Non");
		System.out.println("Votre choix:");
		continuer = input.nextInt();
		while(continuer != 1 && continuer != 2) {
			System.out.println("Veuillez saisir 1(oui) ou 2(non)");
			continuer = input.nextInt();
		}
		input.nextLine();
		
		if(continuer == 1) {
			isInTheList(liste);
		}
		
	input.close();	
	}
	
	//#############---------------methods
	
	
	
	
	//--afficher liste invités
	public static void printGuestList(String[] table) {
		System.out.println("Liste des invités :");
		for(int i = 0; i <= nbGuests -1; i++) {
			System.out.print(table[i] + ", ");
		}
		System.out.println();
	}
	
	//--fonction de recherche d'un invité dans une liste 
	public static void isInTheList(String[] table) {
		System.out.println("Est-ce que cet invité est dans le liste ?");
		System.out.println("Veuillez saisir un nom :");
		String name = input.nextLine();
		boolean isInTheList = false;
		int continuer;
		
		do {	
			for(int i = 0; i <= nbGuests -1; i++ ) {
				if(name.equals(table[i])) {
					isInTheList = true;
				}
			}
			
			if((isInTheList)) {
				System.out.println(name + " est bien dans la liste");
			}else {
				System.out.println(name + " n'est pas dans la liste");
			}	
			//--continuer oui ou non
			System.out.println("Souhaitez-vous chercher un autre nom ?");
			System.out.println("1- Oui");
			System.out.println("2- Non");
			System.out.println("Votre choix:");
			continuer = input.nextInt();
			while(continuer != 1 && continuer != 2) {
				System.out.println("Veuillez saisir 1(oui) ou 2(non)");
				continuer = input.nextInt();
			}
			input.nextLine();
			
			if(continuer == 1) {
				System.out.println("Veuillez saisir un nouveau nom:");
				name = input.nextLine();
			}
		}
		while(continuer == 1 );
	}
	
	//---fonction classer par ordre alphabetique
	public static void sortByNames(String[] table ) {
		String temp;
		
		if(nbGuests > 1) {
			for(int i = 0; i < nbGuests - 1; i++) {
				for(int j = i + 1; j < nbGuests; j++) {
					if(table[i].compareTo(table[j]) > 0) {
						temp = table[i];
						table[i] = table[j];
						table[j] = temp;
					}			
				}
			}
		}
	}
}
