package exoEni;

import java.util.Random;
import java.util.Scanner;

public class Melangeur {

		static int phraseLength;
		static char[] tabCharPhrase;
		static char[] tabLettres;
		static int indiceRepere = 0;
		
	public static void main(String[] args) {
		
		Random random = new Random();
		String phrase;
		
		
		
		//saisie phrase utilisateur
		Scanner input = new Scanner(System.in);
		System.out.println("Veuillez saisir une phrase(terminée par un point):");
		phrase = input.nextLine();
		System.out.println("Voici votre phrase:");
		System.out.println("\"" + phrase + "\"");
		
		// phraseLength <- longueur de la phrase
		phraseLength = phrase.length();
		//taille tu tableau = taille de la phrase
		tabCharPhrase = new char[phraseLength];
		//rempli tableau des charactères de la phrase
		for(int i  = 0; i < phrase.length(); i++) {
			tabCharPhrase[i] = phrase.charAt(i);
		}
		
		//###--melangeur
		
		for(int i = 0; i < phraseLength; i++) {
			//---test si caractère dans tableau = ' '
			if(tabCharPhrase[i] == ' ' || tabCharPhrase[i] == '.') {
				
				//--init tableau taille lettres à mélanger
				tabLettres = new char[i - (indiceRepere + 2)];
				
				// init compteur pour tableau tabLettres
				int count = 0;
				//--itère dans lettre entre la première et la derniere du mot en cours
				for(int j = indiceRepere + 1; j < i -1; j++) {
					// rempli indice count du tableau avec valeur correspondante de tabCharPhrases
					tabLettres[count] = tabCharPhrase[j];
					count++;
				}
				//#####---
				int[] tabCheckRandomIndex = new int[tabLettres.length];
				//---rempli tableau tabCheckRandomIndex des O à sa taille -1
				for(int j = 0; j<tabCheckRandomIndex.length; j++) {
					tabCheckRandomIndex[j] = j;
				}
				
				//####
				//--itère dans lettre entre la première et la derniere du mot en cours
				for(int j = indiceRepere + 1; j < i -1; j++) {
					//genere un randomIndex compris entre 0 et nombre de caractères à mélanger
					int randomIndex = random.nextInt(tabCheckRandomIndex.length);
					
					// si le caractère à randomIndex est différent de la valeur randomIndex -> on re-genere un nouveau randomIndex
					while(tabCheckRandomIndex[randomIndex] != randomIndex) {
						randomIndex = random.nextInt(tabCheckRandomIndex.length);
					}
					
					// modifie valeur dans tableau "phrase" par valeur à l'index randomIndex du tableau des caractères à mélanger
					tabCharPhrase[j] = tabLettres[randomIndex];
					
					//modifie la valeur du tableau de controle pour valider que cet index est déjà utilisé
					tabCheckRandomIndex[randomIndex] = -1;	
					}
				indiceRepere = i+1;
				}
						
			
			}//fin condition de nouveau mot
		
		printTableInLine(tabCharPhrase);
		
		input.close();
		}
	
	//----methods--
	
	//--afficher tableau en une ligne
	public static void printTableInLine(char[] tab){
		for(int i = 0; i < tab.length; i++) {
			System.out.print(tab[i]);
		}
	}

}
