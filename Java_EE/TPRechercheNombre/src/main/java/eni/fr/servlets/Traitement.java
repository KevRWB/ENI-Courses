package eni.fr.servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Traitement
 */
@WebServlet("/Traitement")
public class Traitement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int nbJoueurs;
	private int joueurActif=1;
	private int nbSaisie;
	private int nbMystere;
	
 
	@Override
	public void init() throws ServletException {
		super.init();
		Random rand = new Random();
		nbMystere = rand.nextInt(11);
		nbJoueurs = Stockage.getNbJoueurs();
		
		System.out.println("Nombre mystere : " + nbMystere);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		nbSaisie = Integer.valueOf(request.getParameter("saisie"));
		
		if(nbSaisie == nbMystere) {
			if(joueurActif == nbJoueurs) {
				joueurActif = 1;
			}else {
				joueurActif++;
			}
			nbJoueurs--;
			
			response.sendRedirect("reussite.html");
		}else {
			if(joueurActif == nbJoueurs) {
				joueurActif = 1;
			}else {
				joueurActif++;
			}
			response.sendRedirect("echec.html");
		}
		System.out.println("Nombre joueurs : " + nbJoueurs);
		System.out.println("Joueur actif : " + joueurActif);
		
		
	}
	
}
