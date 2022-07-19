package fr.eni.ecole.testGregorian;

import java.util.GregorianCalendar;
import java.util.Locale;

public class TestLocales {
	// #### MAIN PROGRAM #####
	public static void main(String[] args) {
		
		//creation d'un array de Local -> On y insère toutes les locales disponibles
		Locale[] locales = GregorianCalendar.getAvailableLocales();
		
		
		GregorianCalendar maDate = new GregorianCalendar(2010, 7, 23);
		GregorianCalendar aujourdhui = new GregorianCalendar();
		//les Locale sont des attributs de class -> communs à toutes les instances
		afficheLesLocales(maDate.getAvailableLocales());
		//Les jours sont des attributs d'instance
		System.out.println(maDate.get(GregorianCalendar.DAY_OF_MONTH));
		System.out.println(aujourdhui.get(GregorianCalendar.DAY_OF_MONTH));
	}
	
	//##### METHODS
	
	private static void afficheLesLocales(Locale[] locales) {
		for (Locale l : locales) {
			System.out.println(l);
		}
	}

}
