package fr.eni.javaee.module2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletIllegalStateException
 */
@WebServlet("/modules/module2/ServletIllegalStateException")
public class ServletIllegalStateException extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		pw.print("Coucou");
		pw.flush();
		
		ServletOutputStream fluxBinaire = response.getOutputStream();
		fluxBinaire.print("Autre");
		fluxBinaire.flush();
	}

}
