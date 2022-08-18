package fr.eni.chifoumi.traitements;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Traitement")
public class Traitement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int nbRand;
	private final int NB_MAX_RAND = 3;
	private String coupIa;
	private String coupUser;
	private String win;
	private int coupGagnantUser = 0;
	private int coupGagnantIa = 0;
	private int victoiresUser = 0;
	private int victoiresIa = 0;
	private int nbParties = 1;

	@Override
	public void init() throws ServletException {	
		super.init();
		Random rand = new Random();
		nbRand = rand.nextInt(NB_MAX_RAND);
		switch (nbRand) {
		case 0: coupIa = "pierre";
			break;
		case 1: coupIa = "feuille";
		break;

		default: coupIa = "ciseaux";
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//--recuperation et affichage des données saisies par le joueur
		String saisieUser = request.getParameter("chifumi");
		coupUser = saisieUser;
		System.out.println("user : " + coupUser);
		System.out.println("ia : " + coupIa);
		
		//---Conditions de victoires
		if(coupUser.equals(coupIa)) {
			win = "Egalité !";
		}else if(coupUser.equals("pierre")) {
			if(coupIa.equals("ciseaux")) {
				win = "Gagné !";
			}else win = "Perdu...";
		}else if(coupUser.equals("ciseaux")) {
			if(coupIa.equals("pierre")) win = "Perdu...";
			else win = "Gagné !";
		}else {
			if(coupIa.equals("ciseaux")) win = "Perdu...";
			else win = "Gagné";
		}
		
		//---Incremente le nombre de coup de chaque joueur		
		if(win.equals("Gagné")) coupGagnantUser++;
		else coupGagnantIa ++;
		
		//---Increment le nombre de parties gagnées si victoire d'un joueur (total de coups gagnants = 3)
		if(coupGagnantIa == 3) {		
			coupGagnantUser = 0;
			coupGagnantIa = 0;	
			nbParties++;
			victoiresIa++;
		}
		
		if(coupGagnantUser == 3) {
			victoiresUser++;
			coupGagnantUser = 0;
			coupGagnantIa = 0;
			nbParties++;
		}
		
	
		//----Set attribute to request 
		
		request.setAttribute("valUser", coupUser);
		request.setAttribute("valIa", coupIa);
		request.setAttribute("result", win);
		request.setAttribute("coupGagnantIa", coupGagnantIa);
		request.setAttribute("coupGagnantUser", coupGagnantUser);
		request.setAttribute("victoiresUser", victoiresUser);
		request.setAttribute("victoiresIa", victoiresIa);
		request.setAttribute("nbParties", nbParties);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/reponse.jsp");
		rd.forward(request, response);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/jouer.jsp");
		rd.forward(request, response);
	}

}
