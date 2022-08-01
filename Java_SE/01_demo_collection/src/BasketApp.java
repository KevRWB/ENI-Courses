import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasketApp {

	public static void main(String[] args) {
		Personne p1 = new Personne("Parker", "Tony");
		Personne p2 =  new Personne("Jordan", "Mickael");
		Personne p3 =  new Personne("Brian", "Kobe");
		
		//Versions tableau
		System.out.println("Version tableau");
		Personne[] tableauEquipe = new Personne[3];
		
		tableauEquipe[0] = p1;
		tableauEquipe[1] = p2;
		tableauEquipe[2] = p3;
		
		System.out.println(Arrays.toString(tableauEquipe));
		
		//Version liste
		System.out.println("Version liste");
		
		List<Personne> listeEquipe = new ArrayList<>();
		
		listeEquipe.add(p1);
		listeEquipe.add(p2);
		listeEquipe.add(p3);
		
		System.out.println(listeEquipe);
		
		//intro stream -> Recherche la première personne qui s'appelle Mickael dans la liste -> Stocke dans une variable du même type
		Personne mickael = listeEquipe.stream().filter(p -> p.getPrenom().equals("Mickael")).findFirst().orElse(null);
		System.out.println(mickael.getPrenom());
		
		listeEquipe.remove(0);
		System.out.println(listeEquipe);
		//SUpprime tous les éléments de la liste(sans supprimer la liste)
		listeEquipe.clear();
			
		//Version dictionnnaire
		System.out.println("Version dictionnaire / Map");
		Map<String, Personne>listeEquipeMap = new HashMap<>();
		
		listeEquipeMap.put(p1.getNom(), p1);
		listeEquipeMap.put(p2.getNom(), p2);
		listeEquipeMap.put(p3.getNom(), p3);
		
		System.out.println(listeEquipeMap);
		
		System.out.println(listeEquipeMap.keySet());
		
	}

}
