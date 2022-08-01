package fr.eni.tpAnnuaire;

import java.util.Scanner;

public class TestAnnuaire {

	private final static Scanner SCAN = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		Annuaire annuaire = new Annuaire();
		annuaire.interfaceAnnuaire(SCAN);
		
	}
}
