package fr.eni.ecole.baseDuLangage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class LectureDonnees {

	public static void main(String[] args) {

		try {
			FileInputStream fichier = null;
			Scanner s = null;
			
			try {
				// Stockage du fichier dans une variable
				fichier = new FileInputStream("./valeurs.txt");
				// Scanner du fichier
				s = new Scanner(fichier);
				// Tant qu'il reste des lignes
				while (s.hasNextLine())
					System.out.println(s.nextLine()); // Print la ligne en cours (Possible d'écrire sur une ligne - attention espace sera lu)
				System.out.println("Fichier lu");
			} finally {
				if(s != null)
					s.close();
				if(fichier != null)
					fichier.close();
			}
		} catch (IOException e) {
			System.out.println("Lecture impossible");
		}
	}

}
