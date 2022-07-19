package fr.eni.ecole.testGregorian;

import java.util.GregorianCalendar;
import java.util.Locale;

public class Test {

	public static void main(String[] args) {
		
		// Déclaration d'une variable de type Gregorian Calendar
		GregorianCalendar revo;
		// Création d'une nouvelle instance de GregorianCalendar en faisant appel au constructeur
		revo = new GregorianCalendar(1789, 6, 14);
		
		//afficher contenu instance
		System.out.format("La révolution a eu lieu le %02d/%02d/%d%n", 
				revo.get(GregorianCalendar.DAY_OF_MONTH),
				revo.get(GregorianCalendar.MONTH)+1,
				revo.get(GregorianCalendar.YEAR)
				);
		//afficher date au format long (mois)
		afficherDate(revo);
		//ajouter 6 mois après la date
		revo.add(GregorianCalendar.YEAR, 7);
		afficherDate(revo);
		
		//Creation d'une instance de la date du jour
		GregorianCalendar aujourdhui = new GregorianCalendar();
		afficherDate(aujourdhui);
		//Creation d'une autre instante de Gregorian Calendar avec des paramètres
		GregorianCalendar cal = new GregorianCalendar(2022, GregorianCalendar.JULY, 19);
		//--Modifie la date dans instance "cal"
		cal.set(GregorianCalendar.YEAR, 2666);
		//-- Modifie la date de chacun des attributes de "cal"
		cal.set(2022, GregorianCalendar.FEBRUARY, 1);
		afficherDate(cal);
		//------

	
		
		
	}
	
	//### METHODS
	// Fonction afficher le mois au format long
	private static void afficherDate(GregorianCalendar date) {
		System.out.format("%02d %s %d%n",
				date.get(GregorianCalendar.DAY_OF_MONTH),
				date.getDisplayName(GregorianCalendar.MONTH, GregorianCalendar.LONG_FORMAT, Locale.FRANCE), // SHORT_FORMAT == SHORT
				date.get(GregorianCalendar.YEAR));
	}

}
