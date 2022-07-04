package fr.eni.hello;

import java.util.Scanner;
/*
 * Progamme de test - intro cours Java ENI
 * @Kevin RENAULT
*/

public class HelloWorld {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		//variables 

		Scanner scan = new Scanner(System.in);
		int age;

		
		
		System.out.println("Quel est votre age ?");
		age = scan.nextInt();
		
		if(age >= 18) {
			System.out.println("Vous êtes majeur");
		} else {
			System.out.println("Vous êtes mineur");
		}
		
		
	}

}
