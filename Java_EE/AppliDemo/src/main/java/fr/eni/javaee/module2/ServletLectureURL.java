package fr.eni.javaee.module2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLectureURL
 */
@WebServlet("/modules/module2/ServletLectureURL")
public class ServletLectureURL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperation des données de la requête
		String protocol = request.getScheme();
		String nomServeur = request.getServerName();
		int portServeur = request.getServerPort();
		String contexteApplicatif = request.getContextPath();
		String cheminRessource = request.getServletPath();
		
		//Affichage des données de la requête
		response.getWriter().append("protocol : ").append(protocol).append(System.lineSeparator())
			.append("nom serveur : ").append(nomServeur).append(System.lineSeparator())
			.append("port seveur : ").append("" + portServeur).append(System.lineSeparator())
			.append("contexte applicatif : ").append(contexteApplicatif).append(System.lineSeparator())
			.append("chemin ressource : ").append(cheminRessource).append(System.lineSeparator());
			
	}

}
