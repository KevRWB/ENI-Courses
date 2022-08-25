package fr.eni.tpGestionListesCourses.dal;

import java.util.List;

import fr.eni.tpGestionListesCourses.BusinessException;
import fr.eni.tpGestionListesCourses.bo.Article;
import fr.eni.tpGestionListesCourses.bo.Liste;

public interface ListesCourseDAO {
	public void insertList(Liste liste) throws BusinessException;
	public List<Liste> selectList() throws BusinessException;
	public void deleteList(int idListe)  throws BusinessException;
	public void deleteArticle(String nomArticle)  throws BusinessException;
	
}
