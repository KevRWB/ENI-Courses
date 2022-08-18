package fr.eni.javaee.module2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLectureEnTetes
 */
@WebServlet("/modules/module2/ServletLectureEnTetes")
public class ServletLectureEnTetes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String methodeHttp = request.getMethod();
		String locale = request.getLocale().toString();
		response.getWriter().append("Methode Http : ").append(methodeHttp).append(System.lineSeparator())
			.append("Locale : ").append(locale);
	}

}
