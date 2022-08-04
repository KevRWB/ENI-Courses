package fr.eni.demo.jdbc.dal;

import fr.eni.demo.jdbc.dal.jdbc.StagiaireDAOJdbcImpl;

public class DAOFactory {

	public static StagiaireDAO getStagiaireDAO() {
		return new StagiaireDAOJdbcImpl();
//		return new StagiaireDAOBouchonImpl();
	}
	
}
