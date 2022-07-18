package fr.eni.ecole.baseDuLangage;

import java.io.FileWriter;
import java.io.IOException;

public class EcritureFichier {

	public static void main(String[] args) {
		
		double[] valeurs = {16546, 22, 39, 78.456};
		
		try {
			FileWriter f = null;
			try {
				f = new FileWriter("./valeurs.txt");
				
				for (int i = 0; i < valeurs.length; i++)
					f.write(String.format("%.3f%n", valeurs[i]));
				System.out.println("Enregistrement ok");
			} finally {
				if ( f != null)
					f.close();
			}
		}catch (IOException e) {
			System.err.println("Ecriture impossible");
		}

	}

}
