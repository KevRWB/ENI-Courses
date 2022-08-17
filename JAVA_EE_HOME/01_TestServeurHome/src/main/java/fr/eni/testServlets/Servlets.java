package fr.eni.testServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlets
 */
@WebServlet(
		name = "servletUn",
		urlPatterns = "/Page2.html")
public class Servlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int nbInit=0;
	private int nbGet=0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlets() {
        super();
        }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		try( PrintWriter out = response.getWriter()){
			out.print("<!DOCTYPE html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<title>Identification</title>");
			out.print("</head>");
			out.print("<body>");
			out.print("<h1>Veuillez vous identifier :</h1>");
			out.print("<h2>"+ new Date() +"</h2>");
			out.print("<form method='post' action='login'>"); //action pas obgligatoire. Par default a lui même
			out.print("<input name='txtlogin' type='text' /><br/>");
			out.print("<input name='txt' type='text' /><br/>");
			out.print("</form>");
			out.print("</body>");
			
			out.print("<!DOCTYPE html>");
			out.print("</html>");
			
		}
		
	}
		 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Methode Post");
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Nb init : " + nbInit);
	}
	
	

}
