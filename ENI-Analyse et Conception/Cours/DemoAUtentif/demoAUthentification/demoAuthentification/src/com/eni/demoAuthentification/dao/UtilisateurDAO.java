package com.eni.demoAuthentification.dao;

import java.sql.SQLException;

public interface UtilisateurDAO {

	public boolean authentifier(String user, String password) 
			throws SQLException;
		
	
}
