package com.eni.demoAuthentification.bll;

import java.sql.SQLException;

import com.eni.demoAuthentification.dao.UtilisateurDAO;
import com.eni.demoAuthentification.dao.UtilisateurDAOImpl;

public class UtilisateurMger {
	
	private UtilisateurDAO utilisateurDAO ;
	
	
	public UtilisateurMger() {
		utilisateurDAO = new UtilisateurDAOImpl();
	}
	
	public UtilisateurMger(UtilisateurDAO utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}
	
	
	/*
	 * Description : Permet d'authentifier un utilisateur
	 */
	public boolean authentifier(String user, String password) throws BLLException  {
		boolean authentification ;
		
		
		try {
			authentification = utilisateurDAO.authentifier(user, password);
		} catch (SQLException e) {
			throw new BLLException("Echec", e);
		}
		
		return authentification;
	
	}

	
	public UtilisateurDAO getUtilisateurDAO() {
		return utilisateurDAO;
	}

	public void setUtilisateurDAO(UtilisateurDAOImpl utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}
}
