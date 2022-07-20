package fr.eni.ecole.exemplLocalDate;

import java.time.LocalDate;

public class TestLocalDate {

	public static void main(String[] args) {
		//creation d'une instance "aujourd'hui" de la class LocalDate - method .now
		LocalDate aujourdhui = LocalDate.now();
		//accès aux methodes de la class LocalDate
		System.out.println("Nous sommes le : " + aujourdhui.getDayOfMonth() + "/" +
							String.format("%02d", aujourdhui.getMonthValue()) + "/" + 
							aujourdhui.getYear());
		
		LocalDate dateNaissance = LocalDate.of(1986, 9 , 27 );
		System.out.println(dateNaissance);
		System.out.println(dateNaissance.getMonthValue());
		
		LocalDate autreDate = LocalDate.parse("2022-01-01");
		System.out.println(autreDate);
		System.out.println("Autre date " + autreDate.getDayOfMonth() + "/" +
				String.format("%02d", autreDate.getMonthValue()) + "/" + 
				autreDate.getYear());

	}

}
