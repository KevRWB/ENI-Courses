package fr.eni.ficheSalaire;

import java.util.Scanner;

public class FeuilleSalaire {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Finals
		final int FIRST_STEP = 169;
		final int SECOND_STEP = 180;
		final double COEFF_DEPT = 3.49; 
		final double COEFF_CSG = 6.15;
		final int ONE_CHILD = 20;
		final int TWO_CHILD = 50;
		final int MORE_CHILD = 70;
		final int FOR_MORE_CHILD = 20;
		final int MAJ_50 = 50;
		final int MAJ_60 = 60;
		final String CADRE = "cadre";
		final String AGENT = "agent de maîtrise";
		final String EMPLOYE = "employé de bureau";
			
			
		//Variables
		String name, surname;
		int nbHours, statut;
		int hoursNormal = 0;
		int hours50 = 0;
		int hours60 = 0;
		float salaryRate, netToPay;
		String statutString = "0";
		int primeFamiliale = 0;
		int nbChild = 0;
		
		float salaireBrut, cotisDept, cotisCSG, salaireNet;
		
		//############-------PROGRAM
		
		//user inputs
		System.out.println("Quel est votre prénom ?");
		surname = input.nextLine();
		
		System.out.println("Quel est votre nom ?");
		name = input.nextLine();
		
		System.out.println("Quel est votre statut ?");
		System.out.println("1: cadre");
		System.out.println("2: agent de maîtrise");
		System.out.println("3: employé de bureau");
		statut = input.nextInt();
		
		System.out.println("Combien d'heures avez-vous travaillé ?");
		nbHours = input.nextInt();
		
		System.out.println("Quel est votre taux horaire ?");
		salaryRate = (float)input.nextDouble();
		
		System.out.println("Combien d'enfants avez-vous ?");
		nbChild = input.nextInt();
		

	
		//---calcul nombres heures
		if(nbHours <= FIRST_STEP) {
			hoursNormal = nbHours;
		}else if(nbHours > FIRST_STEP && nbHours <= SECOND_STEP) {
			hoursNormal = FIRST_STEP;
			hours50 = nbHours - FIRST_STEP;
		}else if(nbHours > SECOND_STEP){
			hoursNormal = FIRST_STEP;
			hours50 = SECOND_STEP - FIRST_STEP;
			hours60 = nbHours - SECOND_STEP;
		}
		//--salaire brut
		salaireBrut = (hoursNormal * salaryRate)  + (hours50 * salaryRate * MAJ_50/100) + (hours60 * salaryRate * MAJ_60/100);
		
		//calcul cotisations
		cotisDept = (float)(salaireBrut * COEFF_DEPT /100);
		cotisCSG = (float)(salaireBrut * COEFF_CSG /100);
		
		// salaire net
		salaireNet = (float)(salaireBrut - cotisDept - cotisCSG);
		
		//prime familiale
		if(nbChild == 2) {
			primeFamiliale = ONE_CHILD;
		}else if(nbChild == 3) {
			primeFamiliale = TWO_CHILD;
		} else if (nbChild > 3) {
			primeFamiliale = MORE_CHILD + (FOR_MORE_CHILD *(nbChild - 2));
		}
		
		//net à payer
		netToPay = (float)salaireNet + primeFamiliale;
		
		//---AFFICHAGE
		
		
		System.out.println(name + " " + surname);
		switch(statut) {
			case 1 : statutString = CADRE;
			break;
			case 2 : statutString = AGENT;
			break;
			case 3 : statutString = EMPLOYE;
			break;
		}
		System.out.println("Statut: " + statutString);
		System.out.println();
		System.out.println("Nombre d'heure travaillées: " + nbHours + " heures");
		System.out.println("Taux horaire: " + salaryRate );
		System.out.println();
		System.out.println("Nombre d'enfant: " + nbChild);
		System.out.println();
		
		System.out.println("Salaire brut: " + salaireBrut + "€");
		System.out.println("Nombre d'heures normales: " + hoursNormal);
		System.out.println("Nombre d'heure majorées à " + MAJ_50 + "%: " + hours50);
		System.out.println("Nombre d'heure majorées à " + MAJ_60 + "%: " + hours60);
		
		System.out.println();
		System.out.println("Montant cotisation Dette: " + cotisDept + "€");
		System.out.println("Montant cotisation CSG: " + cotisCSG + "€");
		System.out.println();
		System.out.println("Salaire net : " + salaireNet);
		
		System.out.println();
		System.out.println("Prime familiale : " + primeFamiliale + "€");
		System.out.println();
		
		System.out.println("Salaire net à payer: " + netToPay + "€");
			
		
		input.close();
	}	

}
