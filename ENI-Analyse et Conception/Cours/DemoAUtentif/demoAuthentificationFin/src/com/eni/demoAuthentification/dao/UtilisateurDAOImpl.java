package com.eni.demoAuthentification.dao;

import java.sql.SQLException;

public class UtilisateurDAOImpl implements UtilisateurDAO{
	
	public boolean authentifier(String user, String password) throws SQLException {
		return false;
	}

	@Override
	public String toString() {
		
		return "instance de UtilisateurDAO";
	}

}
