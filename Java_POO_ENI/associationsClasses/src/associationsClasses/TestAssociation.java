package associationsClasses;

public class TestAssociation {

	public static void main(String[] args) {
		
		Voiture maVoiture = new Voiture(1234, "rouge");
		Individu marcel = new Individu("Marcel", "Dupont");
		Individu roger = new Individu("Roger", "Dupuit");
		Individu merceline = new Individu("merceline", "Loufoque");
		
		maVoiture.ajouterProprio(marcel);
		maVoiture.ajouterProprio(roger);
		maVoiture.ajouterProprio(merceline);
		
		System.out.println(maVoiture.toString());
		

	}
}
