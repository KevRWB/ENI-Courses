package eni.fr.tpCouleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class traitementCouleur
 */
@WebServlet("/traitementCouleur")
public class traitementCouleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public traitementCouleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		
		
		//----COmpteur d'accès
		int compteurAcces = 0;
		if(session.getAttribute("compteur") !=null) {
			compteurAcces=(int)session.getAttribute("compteur");
		}
		compteurAcces++;
		session.setAttribute("compteur", compteurAcces);
		
		//------couleur disponibles
	
		String[] colorList = this.getServletContext().getInitParameter("colors").split(", ");
		request.setAttribute("colorList", colorList);
		for(String couleur : colorList) {
			System.out.println(couleur);
		}
		//----------forward
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/accueil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String colorSession = request.getParameter("colorChoice");
		session.setAttribute("couleurSession",colorSession );
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/couleur.jsp");
		rd.forward(request, response);
	}
	

}

