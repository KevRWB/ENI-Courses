package fr.eni.demo.jdbc.dal;

import fr.eni.demo.jdbc.dal.jdbc.Settings;

public class DAOFactory {

	public static StagiaireDAO getStagiaireDAO() throws DALException {
//		return new StagiaireDAOJdbcImpl();
//		return new StagiaireDAOBouchonImpl();
		
		String className = Settings.getValue("daostagiaire");
		try {
			return (StagiaireDAO)Class.forName(className)
							.getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("Erreur lors du chargement de la DAO");
		}
	}
	
}
