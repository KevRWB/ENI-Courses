package fr.eni.javaee.module7;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLisantDateDemarrage
 */
@WebServlet("/modules/module7/ServletLisantDateDemarrage")
public class ServletLisantDateDemarrage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		LocalDateTime dem = (LocalDateTime) this.getServletContext().getAttribute("demarrage"); 
		String emailAdmin = (String) this.getServletContext().getAttribute("EMAIL_ADMINISTRATEUR");
		pw.append("Date demarrage serveur : " + dem);
		pw.append("Email admin : " + emailAdmin);	
	}
}
