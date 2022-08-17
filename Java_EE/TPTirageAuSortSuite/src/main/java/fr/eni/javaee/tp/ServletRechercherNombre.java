package fr.eni.javaee.tp;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletRechercherNombre extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private int nombreATrouver;
	private static int borneMin = 0;
	private static int borneMax = 10;
    /**
     * @see HttpServlet#HttpServlet()
     */
  
    
    @Override
    public void init() throws ServletException {
    	if(!this.getInitParameter("MIN").isBlank() || Integer.valueOf(this.getInitParameter("MIN")) < borneMax ) {
    		borneMin = Integer.valueOf(this.getInitParameter("MIN"));
    	}
    	
    	if(!this.getInitParameter("MAX").isBlank() || Integer.valueOf(this.getInitParameter("MAX")) > borneMin ) {
    		borneMin = Integer.valueOf(this.getInitParameter("MAX"));
    	}
    	
    	//On recherche entre 0 inclus et la différence max-min+1 (car valeur max exclue)
    	//On ajoute ensuite borneMin pour arriver dans la plage ([borneMin;borneMax])
    	this.nombreATrouver=new Random().nextInt(this.borneMax - 1 -this.borneMin+1)+this.borneMin;
    	System.out.println("Min " + borneMin);
    	System.out.println("Max " + borneMax);
    	System.out.println(this.nombreATrouver);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreSaisie = request.getParameter("nombre");
		boolean isOK = true;
		
		try {
			int nombre = Integer.parseInt(nombreSaisie.trim());
			if (nombre != nombreATrouver) {
				isOK = false;
			}
		} catch (Exception e) {
			isOK = false;
		}
		
		if(isOK) {
			response.sendRedirect("succes.html");
		}
		else{
			response.sendRedirect("echec.html");
		}
	}

}















