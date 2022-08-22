package fr.eni.TPSuiviRepas.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.TPSuiviRepas.Exceptions.BusinessException;
import fr.eni.TPSuiviRepas.bll.RepasManager;
import fr.eni.TPSuiviRepas.bo.Aliment;
import fr.eni.TPSuiviRepas.bo.Repas;

/**
 * Servlet implementation class AddMeal
 */
@WebServlet("/AddMeal")
public class AddMeal extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private LocalDate date;
	private LocalTime heure;
	private String[] listeRepasTxt;
	private List<Aliment> listeRepas = new ArrayList<>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMeal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/Ajout.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		date =  LocalDate.parse(request.getParameter("date"));

		System.out.println(date);
		DateTimeFormatter formatterHeure = DateTimeFormatter.ofPattern("HH:mm");
		heure = LocalTime.parse(request.getParameter("heure"), formatterHeure);
		System.out.println(heure);
		
		String repasTxt = request.getParameter("repas");
		listeRepasTxt =  repasTxt.split(", ");
		
		for(String alimentTxt : listeRepasTxt) {
			Aliment aliment = new Aliment(alimentTxt);
			listeRepas.add(aliment);
			
		}
		
		Repas repas = new Repas(date, heure, listeRepas);
		
		RepasManager repasManager = new RepasManager();
		try {
			repasManager.ajouter(repas);
		} catch (BusinessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/Historique.jsp");
		rd.forward(request, response);
		
	}

}
