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
			System.out.println(((Carre)unCarre).calculAire());
		}
		//---------
		//Création de formes par saisies utilisateur
		System.out.println("Vous allez saisir 4 formes : carré, cercle ou autre");
		Forme[] desFormes = new Forme[4];
		Scanner sc = new Scanner(System.in);
		String saisie;
		for (int i = 0; i < desFormes.length; i++) {
			System.out.println("Forme " + (i+1) + " ?");
			saisie = sc.next();
			switch (saisie) {
			case "carré":
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
			//Verification du type de Forme " instanceof"
			if(desFormes[i] instanceof Carre) {
				//Validation du type de forme avec le CAST -> (Carre) -> "Ceci est bien un carré, je l'ai vérifié"
				System.out.println("C'est un carré de côté " + ((Carre)desFormes[i]).getCote() + " - Son toString est " + desFormes[i]);
				
			}else if (desFormes[i] instanceof Cercle) {
				System.out.println("C'est un cercle de rayon " +  ((Cercle) desFormes[i]).getRayon() );
				System.out.println("Son toString est " + desFormes[i]);
			}else {
				System.out.println("C'est une forme de couleur " + desFormes[i].getCouleur() );
				System.out.println("Son toString est " + desFormes[i]);
			}
				
			System.out.println("L'aire de ma forme est : " + desFormes[i].calculAire());
		}
		
		
	}

}
