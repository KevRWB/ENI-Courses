package fr.eni.ecole.tpUseClass;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class CorrectinTpUseClass {

	public static void main(String[] args) {
		GregorianCalendar date = new GregorianCalendar();
		afficherMois(date.get(GregorianCalendar.YEAR), date.get(GregorianCalendar.MONTH));
		System.out.println("---------------");
		System.out.println("***  Choisissez une option : ***");
		System.out.println("     -------");
		System.out.println("- mois précédent");
		System.out.println("+ mois précédent");
		System.out.println("+ mois et année de votre choix(mm/yyyy)");
		System.out.println("q - Quitter");
		System.out.println("--------------");
		
		Scanner input = new Scanner(System.in);
		String inputUser = input.next();
		
		
		
	}
	//### METHODS
	private static void afficherMois(int annee, int mois) {
		//Creation d'une instance de GregorianCalendar
		GregorianCalendar maDate = new GregorianCalendar(annee, mois, 1);
		// affichage mois - année
		System.out.println(String.format("* %s %d *",		
				maDate.getDisplayName(GregorianCalendar.MONTH, GregorianCalendar.LONG, Locale.FRANCE),
				maDate.get(GregorianCalendar.YEAR)));
		//affichage jour(String) semaine
		System.out.println("L  Ma Me J  V  S  D");
		
		//decalage en fonction du premier jour du mois
		int jourDeLaSemaine = maDate.get(GregorianCalendar.DAY_OF_WEEK);
		int decalage = 0;
		switch(jourDeLaSemaine) {
		case GregorianCalendar.MONDAY :;
		case GregorianCalendar.TUESDAY : decalage=1; break;
		case GregorianCalendar.WEDNESDAY : decalage=2; break;
		case GregorianCalendar.THURSDAY : decalage=3; break;
		case GregorianCalendar.FRIDAY : decalage=4; break;
		case GregorianCalendar.SATURDAY : decalage=5; break;
		case GregorianCalendar.SUNDAY : decalage=6; break;
		}
		//affichage du décalage
		for(int i = 0; i<decalage; i++) {
			System.out.print("   ");
		}
		//Dernier jour du mois
		int dernierJourMoi = maDate.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		//affichage des jours
		for (int i = 1; i <= dernierJourMoi ; i++) {
			System.out.printf("%02d ", maDate.get(GregorianCalendar.DAY_OF_MONTH));
			//condition pour passer à la ligne - si dimanche
			if(maDate.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SUNDAY) {
				System.out.printf("%n");
			}
			//passe au joueur suivant
			maDate.add(GregorianCalendar.DAY_OF_MONTH, 1);
		}	
	}//END Fonction afficherMois

}
