package associationsClassesBidirectionnelle;

public class TestAssociation {

	public static void main(String[] args) {
		
		try {
			Voiture dacia = new Voiture(1234, "rouge");
			Voiture ferrari = new Voiture(6546, "bleu");
			Voiture porsche = new Voiture(654, "vert");
			Individu marcel = new Individu("Marcel", "Dupont");
			Individu roger = new Individu("Roger", "Dupuit");
			Individu marceline = new Individu("Mrceline", "Loufoque");
			
			dacia.ajouterProprio(marcel);
			dacia.ajouterProprio(roger);
			dacia.ajouterProprio(marceline);
			
			roger.addCarToCollection(dacia);
			roger.addCarToCollection(ferrari);
			roger.addCarToCollection(porsche);
			
			System.out.println(dacia.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
}
