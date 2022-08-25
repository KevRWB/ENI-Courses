package fr.eni.javaee.module3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDelegantReponseAUneJSP
 */
@WebServlet("/modules/module3/ServletDelegantReponseAUneJSP")
public class ServletDelegantReponseAUneJSP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Appel servlet");
		
		//Delegation
		//Transfert de la requête et de la reponse à la JSP
		RequestDispatcher rd = request.getRequestDispatcher("/modules/module3/demonstrations/delegation.jsp");
		rd.forward(request, response);
	}

}
