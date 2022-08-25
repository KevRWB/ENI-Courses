package fr.eni.javaee.module4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ServletTestPoolConnexion
 */
@WebServlet("/modules/module4/ServletTestPoolConnexion")
public class ServletTestPoolConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		try {
			Context context = new InitialContext();
			
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");
			
			Connection cnx = ds.getConnection();
			
			System.out.println("Bdd ouverte ? " + !cnx.isClosed());
			out.print("La connexion est "+ (cnx.isClosed()?"fermée":"ouverte")+".");
			
			cnx.close();
		} catch (NamingException | SQLException  e) {
			e.printStackTrace();
		}
		
	}

}
