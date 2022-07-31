package k03instructions;

import java.util.Scanner;

public class DemoOperators {
	
	public static void main(String[] args) {
	
		try(Scanner scanner = new Scanner(System.in)){
			
			while (true) {
				System.out.println("Veuillez saisir une première valeur :");
				double valUn = scanner.nextDouble();
				System.out.println("Veuillez saisir une seconde valeur :");
				double valDeux = scanner.nextDouble();
				System.out.println("Veuillez saisir un opérateur (+ - * /):");
				String operateur = scanner.next();
				
				
				switch (operateur) {
				case "+":
					System.out.println("add " + valUn + " " +  valDeux );
					System.out.println(valUn + valDeux);
					break;
				case "-":
					System.out.println("sub " + valUn + " " +  valDeux );
					System.out.println(valUn - valDeux);
					break;
				case "*":
					System.out.println("mul " + valUn + " " +  valDeux );
					System.out.println(valUn * valDeux);
					break;
				case "/":
					System.out.println("div " + valUn + " " +  valDeux );
					System.out.println(valUn / valDeux);
					break;

				default:
					System.out.println("Je n'ai pas compris votre opérateur");
					break;
				}
			}
			
		}
		
		
}
}
