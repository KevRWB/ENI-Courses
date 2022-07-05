package exoEni;

import java.util.Scanner;

public class VitesseMoyenne {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		@SuppressWarnings("unused")
		final int MIN_TO_HOURS = 60;
		
		int timeMin, distKm;
		double avgSpeed;
	
		System.out.println("Entrer un temps en minutes ?");
		timeMin = input.nextInt();
		
		System.out.println("Entrer une distance en km ?");
		distKm = input.nextInt();
		
		avgSpeed = distKm / timeMin * MIN_TO_HOURS;
		
		System.out.println("Votre vitesse moyenne est de " + avgSpeed + " km/h.");
	}

}
