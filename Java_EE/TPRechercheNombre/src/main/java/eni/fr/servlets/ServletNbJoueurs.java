package eni.fr.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletNbJoueurs
 */
@WebServlet("/ServletNbJoueurs")
public class ServletNbJoueurs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int nbJoueurs;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.html");
		nbJoueurs = Integer.valueOf(request.getParameter("nbJoueurs"));
		Stockage.setnbJoueurs(nbJoueurs);
		System.out.println(Stockage.getNbJoueurs());
	}

}
