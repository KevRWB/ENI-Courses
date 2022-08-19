package CalculAllure;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calcul
 */
@WebServlet("/CalculCAP")
public class Calcul extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int tpsHeures;
	private int tpsMinutes;
	private int tpsSecondes;
	private int allMinutes;
	private int allSecondes;
	private float distance;
	private float vitesse;
	
	private String calculToDo;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getValues(request);
		checkWhichCalcul();
		
		calculTpsVitesse(tpsHeures, tpsMinutes, tpsSecondes, vitesse);
		
		printValues();
		
		
	}

	//METHODS
	
	private void checkWhichCalcul() {
		if(tpsMinutes != 0 && allMinutes !=0) calculToDo = "tpsAllure";
		if(tpsMinutes != 0 && distance !=0) calculToDo = "tpsDistance";
		if(tpsMinutes !=0 && vitesse !=0) calculToDo = "tpsVitesse";
		if(allMinutes !=0 && distance != 0) calculToDo = "allureDistance";
		if(distance !=0 && vitesse !=0) calculToDo = "vitesseDistance";
		System.out.println(calculToDo);
	}

	private void getValues(HttpServletRequest request) {
		if(!request.getParameter("tpsHeures").isBlank()) {
			tpsHeures = Integer.valueOf(request.getParameter("tpsHeures"));
			System.out.println(tpsHeures);
		}
		if(!request.getParameter("tpsMinutes").isBlank()) {
			tpsMinutes = Integer.valueOf(request.getParameter("tpsMinutes"));
			System.out.println(tpsMinutes);
		}
		if(!request.getParameter("tpsSecondes").isBlank()) {
			tpsSecondes = Integer.valueOf(request.getParameter("tpsSecondes"));
			System.out.println(tpsSecondes);
		}
		if(!request.getParameter("allMinutes").isBlank()) {
			allMinutes = Integer.valueOf(request.getParameter("allMinutes"));
			System.out.println(allMinutes);
		}
		if(!request.getParameter("allSecondes").isBlank()) {
			allSecondes = Integer.valueOf(request.getParameter("allSecondes"));
			System.out.println(allSecondes);
		}
		if(!request.getParameter("distance").isBlank()) {
			distance = Float.valueOf(request.getParameter("distance"));
			System.out.println(distance);
		}
		if(!request.getParameter("vitesse").isBlank()) {
			vitesse = Float.valueOf(request.getParameter("vitesse"));
			System.out.println(vitesse);
		}
	}
	
	private void calculTpsVitesse(int heures, int minutes, int secondes, float vitesseKmH) {
		int tpsSecondes = calculTempsEnSecondes(heures, minutes, secondes);
		distance = vitesseKmH * tpsSecondes/3600;
		
		float allure = 60/vitesseKmH;
		System.out.println("Allure : " + allure);
		
	}
	
	private int calculTempsEnSecondes(int heures, int minutes, int secondes) {
		return (heures*3600) + (minutes*60) + secondes;
	}
	
	private void printValues() {
		System.out.println("Temps : " + tpsHeures + " h : " + tpsMinutes + " min : " + tpsSecondes);
		System.out.println("Allure : " + allMinutes + " min : " + allSecondes + "sec");
		System.out.println("Distance : " + distance + " km");
		System.out.println("Vitesse : " + vitesse + " km/h");
	}
	
	
	
	private int getIntPartOfAllure(float allure) {
		return 0;
	}

}
