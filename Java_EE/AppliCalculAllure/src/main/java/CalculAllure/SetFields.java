package CalculAllure;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetFields
 */
@WebServlet("/SetFields")
public class SetFields extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*
	 * Variables
	 */
	String typeCourse;
	String txtTypeCourse;
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		typeCourse = request.getParameter("type");
		
		switch (typeCourse) {
		case "CAP": 
			
			break;

		default:
			break;
		}
	}

}
