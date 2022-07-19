package fr.eni.ecole.testGregorian;

import java.util.GregorianCalendar;

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
	}

}
