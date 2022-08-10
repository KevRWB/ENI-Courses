package fr.eni.projeteliot.ihm;

import java.time.LocalDate;
import java.util.List;

import fr.eni.projeteliot.bll.PersonnageManager;
import fr.eni.projeteliot.bo.Personnage;

public class MainApp {

	public static void main(String[] args) {
		
		String nom = "Eliot";
		LocalDate anniversaire = LocalDate.of(2000, 11, 16);
		int idRace = 1; //elfe
				
//		Personnage eliot = PersonnageManager.getInstance().insert(nom, anniversaire, idRace);
//		System.out.println(eliot);
		
//		PersonnageManager.getInstance().insert("Ludovic", LocalDate.of(1981, 2, 6), 2);
//		PersonnageManager.getInstance().insert("Jesse", LocalDate.of(1991, 2, 25), 4);
		
		List<Personnage> personnages = PersonnageManager.getInstance().selectAll();
		System.out.println(personnages);
	}
}
