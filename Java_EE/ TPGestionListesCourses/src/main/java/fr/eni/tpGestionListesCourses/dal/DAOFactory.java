package fr.eni.tpGestionListesCourses.dal;

public abstract class DAOFactory {
	
	public static ListesCourseDAO getListeCourseDAO()
	{
		return new ListesCourseDAOJdbcImpl();
	}
}
	