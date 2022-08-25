package fr.eni.javaee.module9;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import fr.eni.javaee.module9.bo.Crayon;

@Path("/crayons")
public class GestionCrayons {
	private static List<Crayon> listeC;
	
	static {
		listeC = new ArrayList<>();
		listeC.add(new Crayon(1, "bille", "bleu"));
		listeC.add(new Crayon(2, "bille", "vert"));
		listeC.add(new Crayon(3, "plume", "rouge"));
	}
	
	@GET
	public List<Crayon> getCrayons(){
		return listeC;
	}
}
