package fr.eni.ecole.baseDuLangage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class JeuDemot {


	// #### -- MAIN PROGRAM -- #####
	public static void main(String[] args) {
		char [] motAlea = null;
		
		//tirer mot aleatoire
		try {
			motAlea = motAleatoire();
		} catch (FileNotFoundException e) { // exception fichier non trouvé
			e.printStackTrace();
		} catch (IOException e) { // Exception problème lecture fichier
			e.printStackTrace();
		}
		
		//afficher mot melanger
		afficher(motAlea);
		
		char[] motTest = {'C', 'E', 'S','C', 'E', 'S'};
		//check letters
		System.out.println(motTest);
		checkLetters(motTest, "ECC");
		
		
	}
	
	// ################# METHODS ######################
	
	//-- Fonction aléatoire test
	private static char[] motAleatoire() throws FileNotFoundException, IOException{
		char[]  tableau = null;
		
		try (
			FileInputStream fichier = new FileInputStream("./dictionnaire.txt");
			FileInputStream fichier2 = new FileInputStream("./dictionnaire.txt");
			Scanner s = new Scanner(fichier);
			Scanner s2 = new Scanner(fichier2))
			{
			
			int nbMots = 0;
			
			while (s.hasNextLine()) {
				nbMots ++;
				s.nextLine();
			}			
			Random rand = new Random();
			int nbAlea = rand.nextInt(nbMots) +1;
			
			for(int i = 1; i <= nbAlea; i++) {
				s2.nextLine();
			}		
			 tableau = s2.nextLine().toUpperCase().toCharArray();			
		}
		
		return tableau;
	}
	
	// -- Fonction tirer mo aléatoirement
	/*private static char[]tirerMotAleatoirement() throws FileNotFoundException, IOException { // retourne exception si fichier non trouvé ou si erreur d'ezntrée dans le fichier
		//Création tableau null (valeur de retour
		char[] tableau = null;
		
		try(	//charge flux d'entrée (besoin de deux flux distincts pour réinitialiser le deuxième lors du scan jusqu'à nb aléatoire)
				FileInputStream fichier = new FileInputStream("./dictionnaire.txt"); 
				FileInputStream fichier2 = new FileInputStream("./dictionnaire.txt");
				// Flux dans scanners
				Scanner s = new Scanner(fichier);
				Scanner s2 = new Scanner(fichier2);) {
			//Compte nombre lignes dans le fichier
			int nbMots=0;
			while(s.hasNextLine()) { // tant qu'il y a des lignes...
				nbMots++; // incrémente nombre lignes
				s.nextLine();	// passe à la ligne
			}
			// Génère un nombre aléatoire entre 0 et nbMots
			Random rnd = new Random();	// création random
			int nbAlea = rnd.nextInt(nbMots)+1;	// initialisation random entre 0 et nbMots (+1 car random commence à zero)
			
			// Je parcours le  fichier jusqu'au nombre tiré au sort
			for(int i = 0; i <= nbAlea; i++) {
				s2.nextLine();	// positionne le Scanner à la ligne nbAlea
			}
			tableau = s2.nextLine().toUpperCase().toCharArray(); //Stocke dans tableau la valeur nextLine() à la ligne nbAlea
		}
		
		return tableau;
	}
	*/
	
	// Fonction mélangeur de lettres
	private static char[] melanger(char[] tab ) {
	 char[] newTableau = new char[tab.length];
	 //init newTableau
	 for(int i = 0; i < newTableau.length; i++) {
		 newTableau[i] = '#';
	 }
	 // generatet random index
	 Random rand = new Random();
	 int randIndex = rand.nextInt(newTableau.length);
	 
	 for(int i = 0; i < newTableau.length; i++) {
		 boolean lettreOk = false;
		 do {
			 randIndex = rand.nextInt(tab.length);
			 if(newTableau[randIndex] =='#') {
				 newTableau[randIndex] = tab[i];
				 lettreOk = true;
			 }; 
		 }while(!lettreOk);	
	 }	 
	 //--return	 
	 return newTableau;
	}
	
	//--Afficher
	private static void afficher(char[] tab) {
		System.out.println(melanger(tab));
	}
	
	//--Check si lettres saisies par utilisateur sont correctes
	private static boolean checkLetters(char[] tabMelange, String stringUser) {
		boolean lettersOk = true;
		
		if(stringUser.length() > tabMelange.length) {
			System.out.println("Mot trop long");
		}else {
			char[] tabUser = stringUser.toUpperCase().toCharArray();
			char[] tableTemp = tabMelange;
			char[] tableTempUser = tabUser;
			
			for(int i = 0; i < tabUser.length; i++) {
				for(int j = 0; j < tableTemp.length; j++) {
					if(tabUser[i] == tableTemp[j]) {
						tableTemp[j] = '#';
						tableTempUser[i] = '#';
						break;
					}			
				}	
			}
			for(int i = 0; i < tableTempUser.length; i++) {
				if(tableTempUser[i] != '#') {
					lettersOk = false;
				}
			}
			
			System.out.println(tabUser);
			System.out.println(tableTemp);
			if (lettersOk) System.out.println("Vrai");
			else System.out.println("False");	
		}	
		return lettersOk;
	}
	
	//-----------------------------------------
}

