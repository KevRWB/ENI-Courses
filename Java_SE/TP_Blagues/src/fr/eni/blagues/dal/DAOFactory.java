package fr.eni.blagues.dal;

import fr.eni.blagues.dal.jdbc.BlaguesDAOJdbcImpl;

public class DAOFactory {

	public static BlaguesDAO getBlagueDAO() {
		return new BlaguesDAOJdbcImpl();
	}
}
