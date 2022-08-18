package fr.eni.javaee.module2;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEcrivantDesEnTetes
 */
@WebServlet("/modules/module2/ServletEcrivantDesEnTetes")
public class ServletEcrivantDesEnTetes extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(HttpServletResponse.SC_OK);
		response.setLocale(Locale.FRENCH);
		response.setContentType("text/plain"); //"text/html" -> Si envoi de code html
		response.setCharacterEncoding("UTF-8");
		
		response.setHeader("MA_CLE", "MA_VALEUR");
		
		response.getWriter().append("<html><body><h1>Coucou</h1></body></html>");
	}

}
