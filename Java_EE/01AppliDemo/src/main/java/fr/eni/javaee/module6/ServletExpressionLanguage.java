package fr.eni.javaee.module6;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.module6.bo.Voiture;

/**
 * Servlet implementation class ServletExpressionLanguage
 */
@WebServlet("/modules/module6/ServletExpressionLanguage")
public class ServletExpressionLanguage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExpressionLanguage() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession maSession = request.getSession();
    	
    	Random r = new Random();
    	if(r.nextBoolean()) {
    		Voiture v = new Voiture("Lada", "deMerde", "ZZ-666-XX", 9999999);
    		request.setAttribute("voiture", v);
    		
    		Voiture v2 = new Voiture("Dodge", "tropBien", "AA-AZE-12", 1111111);
    		maSession.setAttribute("voiture", v2);
    	}
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modules/module6/pageExpressionLanguage.jsp");
		rd.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
