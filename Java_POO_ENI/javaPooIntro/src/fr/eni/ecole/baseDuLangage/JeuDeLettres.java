package fr.eni.ecole.baseDuLangage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JeuDeLettres {

	private static final String ADRESSE = "./dictionnaire.txt";
	
	public static void main(String[] args) {
		
		try {
			//un mot est tiré dans le dictionnaire
			char[] mot = tirerMotAleatoirement();
			//melange des lettres du mot -> Retour du nouveau mot mélangé (char[])
			char[] motMelange = melanger(mot);
			//afficher tirage au joueur
			System.out.println("Voici le tirage :");
			afficher(motMelange);
			//permettre une proposition de mot
			System.out.println("Quel mot proposez-vous ?");
			Scanner input = new Scanner(System.in);
			char[]prop = input.nextLine().toUpperCase().toCharArray();
			//--check si les lettre de la proposition sont bonnes
			if(!bonnesLettres(motMelange,prop)) {
				System.out.println("Les lettres proposées sont incorrectes");
			}else {
				//--Check si mot dans le dico
				if(dansLeDico(prop)) {
					System.out.println("Le mot est bien dans le dictionnaire. Vous avez gagné !");
					System.out.println(String.format("Vous avez obtenu %d points", prop.length));
				}else {
					System.out.println("Mot non présent dans le dictionnaire...");
				}
			}	
		//catch de toutes le exceptions possibles
		}catch(Exception e) {
			System.out.println("Erreur lors de la lecture du dictionnaire");
		}	
	}
	
	//###  METHODS
	//--######--METHODS
	
	//--Tirer mot aleatoirement dans le fichier dictionnaire
	private static char[] tirerMotAleatoirement() throws FileNotFoundException, IOException {
		char[] tableau=null;
		try (
				//charge le flux d'entrée
				FileInputStream fichier = new FileInputStream(ADRESSE);
				FileInputStream fichier2 = new FileInputStream(ADRESSE);
				//je met le fux dans un scanner pour pouvoir le lire
				Scanner s= new Scanner(fichier);
				Scanner s2=new Scanner(fichier2);
				){
			// j'initialise mon nombre de mot à zéro
			int nbMots=0;
			//tant que j'ai une ligne qui suit
			while(s.hasNextLine()) {
				//j'incrémente mon nombre de ligne
				nbMots++;
				//je passe à la ligne suivante
				s.nextLine();
			}
			// je recupere l'objet random rnd et je l'initialise
			Random rnd = new Random();
			// je crée un nombre entier aleatoire par rapport au nombre de mot du dictionnaire
			int nbAlea = rnd.nextInt(nbMots)+1;

			// je parcours le fichier jusqu'au nombre tiré au sort
			for(int i=1;i<=nbAlea;i++)
			{
				// je passe à la ligne suivante
				s2.nextLine();
			}
			// j'indique que mon tableau de chaîne est la ligne actuelle
			//à mettre en majuscule et à convertir en tableau
			tableau=s2.nextLine().toUpperCase().toCharArray();
		}
		// je retourne le tableau
		return tableau;
	}
	
	//---FONCTION MELANGER
	private static char[] melanger(char[] tabAmelanger) {
		char[] tabMelange= new char[tabAmelanger.length];
		// clonage du tableau
		for(int i=0;i<tabAmelanger.length;i++)
		{
			tabMelange[i]=tabAmelanger[i];
		}
	//	char[] tabMelange= Arrays.copyOf(tabAmelanger, tabAmelanger.length);
		Random rnd = new Random();
		for(int i=0;i<tabMelange.length;i++)
		{
			int positionLettre1=rnd.nextInt(tabMelange.length);
			int positionLettre2=rnd.nextInt(tabMelange.length);
			char tmp=tabMelange[positionLettre1];
			tabMelange[positionLettre1]=tabMelange[positionLettre2];
			tabMelange[positionLettre2]=tmp;
		}
		return tabMelange;
	}
	
	//--FONCTION AFFICHER
	private static void afficher(char[] motAafficher)
	{
		for(int i=0;i<motAafficher.length;i++)
		{
			System.out.print(motAafficher[i]);
		}
		System.out.println(motAafficher);
	
	}
	
	
	//FONCTION CHECK SI BONNES LETTRES
	private static boolean bonnesLettres(char[]lettresDuTirage,char[] motJoueur) {
		
		char[] copie=Arrays.copyOf(lettresDuTirage, lettresDuTirage.length);
		int j=0;
		boolean ok=true;
		while(ok && j<motJoueur.length)
		{
			int k=0;
			while( k<copie.length && motJoueur[j]!=copie[k])
			{
				k++;
			}
			if (k==copie.length) {
				ok=false;
			}
			else {
				copie[k]=' ';
				j++;
			}
		}
		return ok;
	}
	
	//--CHECK SI MOTS SONT IDENTIQUES
	private static boolean sontIdentiques(char[] mot1, char[] mot2) {
		boolean ok = mot1.length == mot2.length;
		if(ok) {
			int i = 0;
			while(ok && i<mot1.length) {
				ok = mot1[i] == mot2[i];
				i++;
			}
		}
		return ok;
	}
	
	//--CHECK SI MOT DANS LE DICO (UTILISANT FONCTION sontIdentiques)
	private static boolean dansLeDico(char[]prop) throws FileNotFoundException, IOException {
		boolean trouve=false;
		try(FileInputStream fichier = new FileInputStream(ADRESSE);
				Scanner s = new Scanner(fichier)){
			char[] motDico;
			while(s.hasNextLine() && !trouve) {
				motDico = s.nextLine().toUpperCase().toCharArray();
				trouve=sontIdentiques(prop, motDico);
			}
		}
		return trouve;
	}

}
