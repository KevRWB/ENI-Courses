package fr.eni.tpGestionListesCourses.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.tpGestionListesCourses.BusinessException;
import fr.eni.tpGestionListesCourses.bll.ListesCourseManager;

/**
 * Servlet implementation class DeleteListe
 */
@WebServlet("/DeleteListe")
public class DeleteListe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ListesCourseManager listeCourseManager = new ListesCourseManager();
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idListeToDelete = Integer.valueOf(request.getParameter("idListe")) ;
		System.out.println("Id liste to delete : " + idListeToDelete);
		try {
			listeCourseManager.deleteListe(idListeToDelete);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/ListesPredefinies");
		rd.forward(request, response);
	}

}
