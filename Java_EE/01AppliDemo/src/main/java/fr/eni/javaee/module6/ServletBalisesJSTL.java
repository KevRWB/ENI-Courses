package fr.eni.javaee.module6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.module6.bo.Voiture;

/**
 * Servlet implementation class ServletBalisesJSTL
 */
@WebServlet("/modules/module6/ServletBalisesJSTL")
public class ServletBalisesJSTL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Random r = new Random();
    	if(r.nextBoolean()) {
    		Voiture v = new Voiture("Lada", "deMerde", "ZZ-666-XX", 9999999);
    		request.setAttribute("voiture", v);
    		
    	}
    	
    	List<Voiture> voitures = new ArrayList<>();
		voitures.add(new Voiture("AUDI","RS6","AZ456QS", 46434));
		voitures.add(new Voiture("MERCEDES","CLASSE C","ER789DF",5319));
		voitures.add(new Voiture("PEUGEOT","308","CV345TY",134567));
		request.setAttribute("voitures", voitures);
		
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modules/module6/pageBalisesJSTL.jsp");
		rd.forward(request, response);
	}

}
