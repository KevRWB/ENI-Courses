package fr.eni.papeterie.bll;

import java.util.List;

import fr.eni.demo.jdbc.bll.BLLException;
import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DALException;
import fr.eni.papeterie.dal.DAOFactory;

public class CatalogueManager {
	/*
	 * PATTERN SINGLETON
	 */
	
	private static CatalogueManager instance;
	
	private CatalogueManager() { }
	
	public static CatalogueManager getInstance() {
		if(instance == null) {
			instance = new CatalogueManager();
		}
		return instance;
	}
	
	/*
	 * FIN PATTERN SINGLETON
	 */
	
	ArticleDAO articleDAO = DAOFactory.getArticleDAO();
	
	
	//METHODS
	public List<Article> getCatalogue()throws BLLException{
		List<Article> list = null;
		try {
			list =  articleDAO.selectAll();
		} catch (DALException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void addArticle(Article article) throws BLLException{
		try {
			articleDAO.insert(article);
		} catch (DALException e) {

			e.printStackTrace();
		}
	}
	
	public void updateArticle(Article article)throws BLLException{
		try {
			articleDAO.update(article);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
	
	public void removeArticle(int index) throws BLLException{
		try {
			articleDAO.delete(index);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
	
	public void validerArticle(Article article)throws BLLException {
		
	}
	
	public Article getArticle(int index) {
		try {
			return articleDAO.selectById(index);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
	
	//GETTERS
	public ArticleDAO getArticleDAO()throws BLLException {
		return articleDAO;
	}
	
	
	
	
	
}
