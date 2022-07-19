package fr.eni.ecole.tpUseClass;

import java.util.GregorianCalendar;
import java.util.Locale;

public class TPUseClass {
	// MAIN PROGRAM
	public static void main(String[] args) {
		afficherMois(2022, 6);		
	}
	//### METHODS
	private static void afficherMois(int year, int month) {

		GregorianCalendar moisAnnee = new GregorianCalendar(year,month, 0);
		//Afficher année et mois selectionnés
		System.out.println(moisAnnee.get(GregorianCalendar.YEAR));
		System.out.println(moisAnnee.getDisplayName(GregorianCalendar.MONTH, GregorianCalendar.LONG, Locale.FRANCE));

		//check le premier jour du mois
		int premierJour = moisAnnee.get(GregorianCalendar.DAY_OF_WEEK);
		System.out.println(premierJour);
		//afficher jours	
		System.out.print("Lun ");
		System.out.print("Mar ");
		System.out.print("Mer ");
		System.out.print("Jeu ");
		System.out.print("Ven ");
		System.out.print("Sam ");
		System.out.print("Dim ");

		System.out.println();
		//recherche du nombre de jours dans le mois 
		int jourMax = moisAnnee.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
	
		//affichage jours	
		for(int j = 1; j <= jourMax; j++) {
			// Tant que compteur par arrivé au numero du premier jour du mois -> Affichage " "
			while(j+1 < premierJour ) {
				System.out.print("    ");
				j++;
			}
			//Affichage des jours - Passage à la ligne 
			moisAnnee = new GregorianCalendar(year, month, j-premierJour+2);
			int day = moisAnnee.get(GregorianCalendar.DAY_OF_MONTH);
			System.out.printf("%02d  " ,day );
			if(j%7 == 0) {
				System.out.println();
			}
		}	
	}

}
