package exempleHerit;

import java.awt.Color;
import java.util.Scanner;

public class TestFormes {

	public static void main(String[] args) {
		Forme uneForme = new Forme(Color.BLUE);
		Forme unCarre = new Carre(Color.GREEN,10);
		Cercle unCercle = new Cercle(Color.yellow,8);
		//---------------
		System.out.println("Couleur : " );
		System.out.println(uneForme.getCouleur());
		System.out.println(unCarre.getCouleur());
		System.out.println(unCercle.getCouleur());
		//--------------
		if(unCarre instanceof Carre) {
			System.out.println(((Carre)unCarre).aire());
		}
		//---------
		Forme[] desFormes = new Forme[4];
		Scanner sc = new Scanner(System.in);
		String saisie;
		for (int i = 0; i < desFormes.length; i++) {
			System.out.println("Quelle forme ?");
			saisie = sc.next();
			switch (saisie) {
			case "carre":
				desFormes[i] = new Carre(Color.BLUE, 10);
				break;
			case "cercle":
				desFormes[i] = new Cercle(Color.YELLOW, 10);
				break;
			default:
				desFormes[i] = new Forme(Color.BLUE);
			}
		}
		
		//Afficher information des éléments
		for (int i = 0; i < desFormes.length; i++) {
			if(desFormes[i] instanceof Carre) {
				System.out.println("C'est un carré de côté " + ((Carre)desFormes[i]).getCote() );
			}else if (desFormes[i] instanceof Cercle) {
				System.out.println("C'est un cercle de rayon " +  ((Cercle) desFormes[i]).getRayon() );
			}else System.out.println("C'est une forme de couleur " + desFormes[i].getCouleur() );
		}
		
		
	}

}
