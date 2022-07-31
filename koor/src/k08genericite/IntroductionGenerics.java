package k08genericite;

import java.util.ArrayList;

public class IntroductionGenerics {
	
	
	public static void main(String[] args) {
		
		ArrayList collection = new ArrayList();
		
		collection.add("Toto");
		collection.add("Titi");
		collection.add("Tutu");
		collection.add("Tata");
		
		for (Object object : collection) {
			System.out.println(object.toString().toUpperCase());
		}		
	}
}
