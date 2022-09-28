package com.eni.demoAuthentification.dao;

import java.sql.SQLException;

public class UtilisateurDAOImplSTUB implements UtilisateurDAO{

	@Override
	public boolean authentifier(String user, String password) throws SQLException {
		if("bob".equals(user) && "Pa$$w0rd".equals(password)) {
			return true;
		}
		return false;
	}

}
