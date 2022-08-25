package fr.eni.javaee.module9;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/couleurs")
public class GestionCouleurs {
	
	private static List<String> listeCouleurs;
	
	static {
		listeCouleurs = new ArrayList<>();
		listeCouleurs.add("bleu");
		listeCouleurs.add("rouge");
		listeCouleurs.add("noir");
		listeCouleurs.add("vert");
		
	}
	
	@GET
	public String getCouleurs() {
		return listeCouleurs.toString();
	}
	
	@GET
	@Path("/rouge")
	public String getCouleurRouge() {
		return "couleur rouge";
	}
	
	@GET
	@Path("/{ind}")
	public String getCouleur( @PathParam("ind") int indice) {
		String couleur = "Pas de couleurs associée";
		if(indice >= 0 && indice < listeCouleurs.size()) {
			couleur = listeCouleurs.get(indice);
		}
		return "Couleur trouvée : " + couleur;
	}
}
