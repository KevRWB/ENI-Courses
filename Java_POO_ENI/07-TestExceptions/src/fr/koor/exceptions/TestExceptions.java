package fr.koor.exceptions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class TestExceptions {
	
	public static void method3() {
		System.out.println("Begin method 3");
		while(true) {
			try {
				FileOutputStream fos = new FileOutputStream("/root/save.data");
				fos.write("Ok\n".getBytes());
				fos.close();
				break;
			} catch (IOException e) {
				System.out.println("Problème d'écriture. Voulez-vous recommencer :");
				Scanner scanner = new Scanner(System.in);
				String response = scanner.nextLine();
				if(response.equalsIgnoreCase("non")) {
					break;
				}
				scanner.close();
			}
		}
		System.out.println("End method 3");
	}
	
	public static void method2() {
		System.out.println("Begin method 2");	
		method3();
		System.out.println("END method2");
	}
	
	public static void method1() {
		System.out.println("Begin method 1");
		method2();
		System.out.println("End method 1");
	}
	//MAIN PROGRAM
	public static void main(String[] args) {
		System.out.println("BEGIN main");
			method1();		
		System.out.println("END main");
	}
}
