package fr.eni.ecole.voiture;

public class TestVoiture {

	public static void main(String[] args) {
		//creation des instances de voiture
		Voiture maVoiture = new Voiture("Rouge", 12354);
		Voiture autreVoiture = new Voiture("bleue", 657);
		
		//Affichage des caractéristiques des instances
		System.out.println("Voiture 1 :");
		System.out.println(maVoiture.getColor());
		System.out.println(maVoiture.getNumImmat());
		System.out.println();
		
		System.out.println("Voiture 2 :");
		System.out.println(autreVoiture.getColor());
		System.out.println(autreVoiture.getNumImmat());
		System.out.println();
		
		// Affichage du nombre de voitures	
		System.out.println("Nombre de voitures crées : " + Voiture.getNbVoitures());

	}

}
