package fr.eni.ecole.tpUseClass;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class CorrectinTpUseClass {

	public static void main(String[] args) {
		GregorianCalendar date = new GregorianCalendar();//Création d'un objet calendrier au mois et à l'année en cours
		afficherMois(date.get(GregorianCalendar.YEAR), date.get(GregorianCalendar.MONTH)); // afficher calendrier
		
		//declaration scanner
		Scanner sc = new Scanner(System.in);
		String inputUser;
		//Boucle de programme
		do {
			//Affichage menu / consigne
			System.out.println("---------------");
			System.out.println("***  Choisissez une option : ***");
			System.out.println("     -------");
			System.out.println("- mois précédent");
			System.out.println("+ mois précédent");
			System.out.println("+ mois et année de votre choix(mm/yyyy)");
			System.out.println("q - Quitter");
			System.out.println("--------------");
			//Scanner de saisie utilisateur
			inputUser = sc.next();
			
			switch(inputUser) {
			case "-": 
				date.add(GregorianCalendar.MONTH, -1);
				afficherMois(date.get(GregorianCalendar.YEAR), date.get(GregorianCalendar.MONTH));
			break;
			case "+": 
				date.add(GregorianCalendar.MONTH, +1);
				afficherMois(date.get(GregorianCalendar.YEAR), date.get(GregorianCalendar.MONTH));
			break;
			case "q":
				System.out.println("Au revoir");
			break;
				
			default:
				if(inputUser.length()==7) {
					//Substring de mm/yyyy
					// On récupère mm avec substring - Converti en Int pour stockage dans variable
					int mois = (Integer.valueOf(inputUser.substring(0,2)) -1); // -1 -> Mois commencent à zero dans GregorianCalendar
					int annee = Integer.valueOf(inputUser.substring(3,7)); // valeur de année avec substring
					//Changement des valeurs de l'objet GragorianCalendar "date" avec paramètres renseignés par utilisateur
					date.set(annee, mois, 1);
					afficherMois(date.get(GregorianCalendar.YEAR), date.get(GregorianCalendar.MONTH));
				}else {
					System.out.println("Saisie incorrecte");
				}
			}
		}while(!inputUser.equalsIgnoreCase("q")); // tant que saisie différente de "q" (en ignorant majuscules)
		
		
		
	}
	//### METHODS
	private static void afficherMois(int annee, int mois) {
		//Creation d'une instance de GregorianCalendar
		GregorianCalendar maDate = new GregorianCalendar(annee, mois, 1);
		// affichage mois - année
		System.out.println(String.format("* %s %d *",		
				// getDisplayName = methode de l'instance "maDate"
				maDate.getDisplayName(GregorianCalendar.MONTH, GregorianCalendar.LONG, Locale.FRANCE),
				maDate.get(GregorianCalendar.YEAR)));
		//affichage jour(String) semaine
		System.out.println("L  Ma Me J  V  S  D");
		
		//decalage en fonction du premier jour du mois
		int jourDeLaSemaine = maDate.get(GregorianCalendar.DAY_OF_WEEK);
		int decalage = 0;
		switch(jourDeLaSemaine) {
		case GregorianCalendar.MONDAY :;
		case GregorianCalendar.TUESDAY : decalage=1; break;
		case GregorianCalendar.WEDNESDAY : decalage=2; break;
		case GregorianCalendar.THURSDAY : decalage=3; break;
		case GregorianCalendar.FRIDAY : decalage=4; break;
		case GregorianCalendar.SATURDAY : decalage=5; break;
		case GregorianCalendar.SUNDAY : decalage=6; break;
		}
		//affichage du décalage
		for(int i = 0; i<decalage; i++) {
			System.out.print("   ");
		}
		//Nombre de jours maximum dans le mois en cours de l'instance "maDate"
		int dernierJourMois = maDate.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		//affichage des jours
		for (int i = 1; i <= dernierJourMois ; i++) {
			System.out.printf("%02d ", maDate.get(GregorianCalendar.DAY_OF_MONTH));
			//condition pour passer à la ligne - si dimanche
			if(maDate.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SUNDAY) {
				System.out.printf("%n");
			}
			//passe au jour suivant -> Methode add de l'instance
			maDate.add(GregorianCalendar.DAY_OF_MONTH, 1);
		}	
	}//END Fonction afficherMois

}
