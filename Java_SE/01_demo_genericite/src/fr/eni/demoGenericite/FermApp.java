package fr.eni.demoGenericite;

public class FermApp {

	public static void main(String[] args) {
		//create new Animals
		Animal grosMinet = new Chat();
		Vache marguerite = new Vache();
		
		Ferme<Animal> fermeEnFolie = new Ferme<Animal>("Ferme en folie");
		
		fermeEnFolie.ajouter(marguerite);
		fermeEnFolie.ajouter(grosMinet);
		
		System.out.println(fermeEnFolie);
		
		Ferme<Stagiaire> eni = new Ferme<Stagiaire>("ENI");
		
		eni.ajouter(new Stagiaire());
		
		System.out.println(eni);

	}

}
