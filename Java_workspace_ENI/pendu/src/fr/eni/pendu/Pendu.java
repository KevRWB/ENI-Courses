package fr.eni.pendu;

import java.util.Arrays;
import java.util.Scanner;

public class Pendu {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//constantes
		char CARAC_VIDE = '_';
		char CARAC_SEP = '-';
		
		//variables
		String mot;
		char[] tabMot;
		char[] tabMotVide;
		
		//  PROGRAM
		System.out.println("Bienvenue dans ce jeu de pendu");
		System.out.println();
		System.out.println("Joueur 1, veuillez saisir un mot:");
		
		//saisie utilisateur du mot à découvrir
		mot = input.nextLine();
		
		//remplir tableau mot avec caractères de "mot"
		tabMot = mot.toCharArray();
		
		//creer tableau vide et remplir avec "_" ou "-"
		tabMotVide = new char[mot.length()];
		for(int i = 0; i < tabMotVide.length; i++) {
			if(tabMot[i] == '-'){
				tabMotVide[i] = CARAC_SEP;
			}else {
				tabMotVide[i] = CARAC_VIDE;
			}
		}
		
		System.out.println(Arrays.toString(tabMotVide));
	
	}

}
