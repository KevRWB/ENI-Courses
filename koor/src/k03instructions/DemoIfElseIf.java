package k03instructions;

import java.util.Scanner;

public class DemoIfElseIf {
	public static void main(String[] args) {
		
		try(Scanner scanner = new Scanner(System.in)){
			System.out.println("Veuillez saisir une année :");
			int year = scanner.nextInt();
			
			boolean isBissextile = false;
			
			if(year%4 == 0) {
				if(year%400 == 0) isBissextile = true;
				else if(year%100 == 0) isBissextile = false;
				else isBissextile = true;}
			
			if(isBissextile) {
				System.out.println(year + " est une année bissextile");
			} else {
				System.out.println(year + " n'est pas une année bissextile");
			}
			
		}
		
		
		
	}
}
