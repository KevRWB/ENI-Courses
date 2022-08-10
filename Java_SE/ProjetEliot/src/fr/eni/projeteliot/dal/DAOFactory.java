package fr.eni.projeteliot.dal;

import fr.eni.projeteliot.dal.jdbc.PersonnageDAOJdbcImpl;

public class DAOFactory {

	public static PersonnageDAO getPersonnageDAO() {
		return new PersonnageDAOJdbcImpl();
	}
	
}
