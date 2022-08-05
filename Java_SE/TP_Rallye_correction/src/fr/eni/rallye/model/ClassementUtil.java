package fr.eni.rallye.model;

import java.util.Arrays;
import java.util.Comparator;

public class ClassementUtil {

	/**
	 * Classe un tableau de Resultat par temps
	 * @param resultats
	 * @return
	 */
	public static Resultat[] classerParTemps(Resultat[] resultats) {
		
		Arrays.sort(resultats, new Comparator<Resultat>() {

			@Override
			public int compare(Resultat r1, Resultat r2) {
				return r1.getTemps().compareTo(r2.getTemps());
			}
		});
		return resultats;	
	}
	
	public static Classement[] classerParTemps(Classement[] classements) {
		
		Arrays.sort(classements, new Comparator<Classement>() {

			@Override
			public int compare(Classement r1, Classement r2) {
				return r1.getCumulTemps().compareTo(r2.getCumulTemps());
			}
		});
		return classements;	
	}
	
	public static Resultat[] classerParEquipage(Resultat[] resultats) {
		
		Arrays.sort(resultats, new Comparator<Resultat>() {

			@Override
			public int compare(Resultat r1, Resultat r2) {
				return r1.getEquipage().getDossard() - r2.getEquipage().getDossard();
			}
		});
		return resultats;	
	}
	
	
}
