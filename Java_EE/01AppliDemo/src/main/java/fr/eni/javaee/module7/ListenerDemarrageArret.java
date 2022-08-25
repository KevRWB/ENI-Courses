package fr.eni.javaee.module7;

import java.time.LocalDateTime;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ListenerDemarrageArret
 *
 */
@WebListener
public class ListenerDemarrageArret implements ServletContextListener {

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
        arg0.getServletContext().setAttribute("demarrage", LocalDateTime.now()); 
        arg0.getServletContext().setAttribute("EMAIL_ADMINISTRATEUR", arg0.getServletContext().getInitParameter("EMAIL_ADMINISTRATEUR"));
    	System.out.println("Démarrage de l'application");
    	System.out.println(arg0.getServletContext().getAttribute("demarrage"));
    }
	
}
