package fr.eni.javaee.module3;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/modules/module3/ServletFournissantInformationALaJSP")
public class ServletFournissantUneInformationALaJSP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("chaine", "Salut tout le monde");
		request.setAttribute("Today", new Date());
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/jspAffichantInformationFournieParServlet.jsp");
		rd.forward(request, response);
	}

}
