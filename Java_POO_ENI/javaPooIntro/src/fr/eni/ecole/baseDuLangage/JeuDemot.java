package fr.eni.ecole.baseDuLangage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class JeuDemot {


	
	public static void main(String[] args) {
		try {
			char [] motAlea = tirerMotAleatoirement();
			System.out.println(motAlea);// permets d'afficher le tableau car tableau de caractères
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// METHODS
	private static char[]tirerMotAleatoirement() throws FileNotFoundException, IOException { // retourne exception si fichier non trouvé ou si erreur d'ezntrée dans le fichier
		//Création tableau null (valeur de retour
		char[] tableau = null;
		
		try(
				FileInputStream fichier = new FileInputStream("./dictionnaire.txt"); 
				FileInputStream fichier2 = new FileInputStream("./dictionnaire.txt"); 
				Scanner s = new Scanner(fichier);
				Scanner s2 = new Scanner(fichier2);) {
			//Compte nombre lignes dans le fichier
			int nbMots=0;
			while(s.hasNextLine()) {
				nbMots++;
				s.nextLine();
			}
			// Génère un nombre aléatoire entre 0 et nbMots
			Random rnd = new Random();
			int nbAlea = rnd.nextInt(nbMots)+1;
			
			// Je parcours le  fichier jusqu'au nombre tiré au sort
			for(int i = 0; i <= nbAlea; i++) {
				s2.nextLine();
			}
			//Stocke dans tableau la valeur nextLine() à la ligne nbAlea
			tableau = s2.nextLine().toUpperCase().toCharArray();
		}
		
		return tableau;
	}
}

