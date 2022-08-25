package fr.eni.tpGestionListesCourses.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.tpGestionListesCourses.bo.Article;
import fr.eni.tpGestionListesCourses.bo.Liste;

/**
 * Servlet implementation class Panier
 */
@WebServlet("/Panier")
public class Panier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idListe = Integer.valueOf(request.getParameter("idListe")) ;
		List<Liste> listeListes = (List<Liste>) this.getServletContext().getAttribute("listeListe");
		List<Article> listeArticle = new ArrayList<>();
		Liste currentList=null;
		
		for(Liste list : listeListes) {
			if(idListe == list.getIdListe()) {
				currentList = list;
			}
		}
		for(Article article : currentList.getListeArticles()) {
			listeArticle.add(article);
		}
		
		for(Article article : listeArticle) {
			System.out.println(article.getNom());
		}
		
		request.setAttribute("nomList", currentList.getNom());
		request.setAttribute("listeArticles", listeArticle);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/votrePanier.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
