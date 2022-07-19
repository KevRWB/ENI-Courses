package fr.eni.ecole.testString;

public class TestString {

	public static void main(String[] args) {
		//String "classique" -> L'instance ne se modifie pas. Il se creé à chaque fois une nouvelle instance
		String nom = "Dupont";
		String nomMaj = nom.toUpperCase();
		String avecUnD = nomMaj.replace('T', 'D');
		
		
		//StringBuilder -> Objet String qui peut être modifié
		StringBuilder name = new StringBuilder("Dupont");
		name.setCharAt((name.length())-1, 'D');
		name.append("###").append("Jean");
		System.out.println(name.toString());
	}

}
