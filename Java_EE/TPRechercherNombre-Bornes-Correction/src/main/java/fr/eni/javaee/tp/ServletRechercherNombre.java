package fr.eni.javaee.tp;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/rechercher")
public class ServletRechercherNombre extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private int nombreATrouver;
	private int borneMin=0;
	private int borneMax=10;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRechercherNombre() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	String minS = this.getInitParameter("BORNE_MIN");
    	String maxS = this.getInitParameter("BORNE_MAX");
    	int min = borneMin;
    	int max = borneMax;
    	try {
			min = Integer.parseInt(minS);
			if (min < 0 )
				min = borneMin;
		} catch (Exception e) {
		}
    	try {
			max = Integer.parseInt(maxS);
			if (max < 0 )
				max = borneMax;
		} catch (Exception e) {
		}
    	
    	borneMin = Math.min(min, max);
    	borneMax = Math.max(min, max);
    	System.out.println(borneMin + "/" + borneMax);
    	
    	this.nombreATrouver=new Random().nextInt(this.borneMax-this.borneMin+1)+this.borneMin;
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















