package fr.eni.TPSuiviRepas.dal;

public class DAOFactory {
	public static RepasDAO getRepasDAO() {
		return new RepasDAOJdbcImpl();
	};
}
