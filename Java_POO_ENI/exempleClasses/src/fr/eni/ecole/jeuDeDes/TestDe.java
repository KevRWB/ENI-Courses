package fr.eni.ecole.jeuDeDes;

public class TestDe {

	public static void main(String[] args) {
		//Instance de la class "De" - pas de construceur donc constructeur par default (java lang object)
		try {
			De monDe = new De();
			De autreDe = new De(6);
			//boucle de jeu
			do {		//affichage du resultat du lancer
				System.out.println("Le dé a fait : " + autreDe.lancer());
			//tant que tirage n'est pas 6, relance	
			}while(autreDe.getFaceTiree()!=6);
		} catch (Exception e) {
			e.printStackTrace();
	
		}
		//Set le nombre de faces du dé - avec try exception
		//Surround by try catch car peut retourner un exception
		/*try {
			monDe.setNbFaces(6);
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}	
		
		
	

}
