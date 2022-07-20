package fr.eni.ecole.jeuDeDes;

public class TestDe {

	public static void main(String[] args) {
		//Instance de la class "De" - pas de construceur donc constructeur par default (java lang object)
		De monDe = new De();
		
		//Set le nombre de faces du dé - avec try exception
		try {					//Surround by try catch car peut retourner un exception
			monDe.setNbFaces(6);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//boucle de jeu
		do {		//affichage du resultat du lancer
			System.out.println("Le dé a fait : " + monDe.lancer());
		//tant que tirage n'est pas 6, relance	
		}while(monDe.getFaceTiree()!=6);
	}

}
