package fr.eni.tpGestionListesCourses.bll;

import java.util.List;

import fr.eni.tpGestionListesCourses.BusinessException;
import fr.eni.tpGestionListesCourses.bo.Liste;
import fr.eni.tpGestionListesCourses.dal.DAOFactory;
import fr.eni.tpGestionListesCourses.dal.ListesCourseDAO;

public class ListesCourseManager {
	private ListesCourseDAO listesCourseDAO;
	
	public ListesCourseManager() {
		this.listesCourseDAO=DAOFactory.getListeCourseDAO();
	}
	
	
	public List<Liste> selectAll() throws BusinessException {
		return listesCourseDAO.selectList();
	}

	
	
	
}
