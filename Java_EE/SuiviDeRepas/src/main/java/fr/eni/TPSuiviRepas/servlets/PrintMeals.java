package fr.eni.TPSuiviRepas.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.TPSuiviRepas.Exceptions.BusinessException;
import fr.eni.TPSuiviRepas.bll.RepasManager;
import fr.eni.TPSuiviRepas.bo.Repas;

/**
 * Servlet implementation class PrintMeals
 */
@WebServlet("/PrintMeals")
public class PrintMeals extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintMeals() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RepasManager repasManager = new RepasManager();
		
		List<Repas> listeRepas = new ArrayList<>();
		
		try {
			listeRepas = repasManager.selectAll();
		} catch (BusinessException | SQLException e) {
			e.printStackTrace();
		}
		
		for(Repas repas : listeRepas) {
			System.out.println("Repas : " + repas + " Aliments: " + repas.getListeAliments());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/Historique.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
