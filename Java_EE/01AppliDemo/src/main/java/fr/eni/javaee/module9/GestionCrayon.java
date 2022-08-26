package fr.eni.javaee.module9;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import fr.eni.javaee.module9.bo.Crayon;

@Path("/crayons")
public class GestionCrayon {
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
	
	@GET
	@Path("/{id : \\d+}") // regex
	public Crayon getCrayon(@PathParam("id") int indice) {
		Crayon crayon = null;
		
		if(indice > 0) {
			for(Crayon crayon1 : listeC) {
				if(crayon1.getId() == indice) {
					crayon = crayon1;
				}
			}
		}
		return crayon;
	}
}
