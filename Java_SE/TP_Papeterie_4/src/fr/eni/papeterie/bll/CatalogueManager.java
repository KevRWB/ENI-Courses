package fr.eni.papeterie.bll;

import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
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
			throw new BLLException("Erreur lors du selectAll : " + e.getMessage());
		}
		return list;
	}
	
	public void addArticle(Article article) throws BLLException{
		validerArticle(article);
		try {
			articleDAO.insert(article);
		} catch (DALException e) {

			e.printStackTrace();
			throw new BLLException("Erreur lors du selectAll : " + e.getMessage());
		}
	}
	
	public void updateArticle(Article article)throws BLLException{
		validerArticle(article);
		try {
			articleDAO.update(article);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur lors du selectAll : " + e.getMessage());
		}
	}
	
	public void removeArticle(Article article) throws BLLException{
		try {
			articleDAO.delete(article.getIdArticle());
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur lors du selectAll : " + e.getMessage());
		}
	}
		
	public Article getArticle(int index) throws BLLException {
		Article article = null;
		try {
			article =  articleDAO.selectById(index);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur lors du selectAll : " + e.getMessage());
		}
		return article;
	}
	
	public void validerArticle(Article article) throws BLLException {
		if(article.getMarque() == null ||article.getMarque().isBlank() || article.getMarque().length() > 200) {
			throw new BLLException("La marque est obligatoire et sa taille < 200");
		}
		if(article.getReference() == null ||article.getReference().isBlank() || article.getReference().length() > 10) {
			throw new BLLException("La reference est obligatoire et sa taille < 200");
		}
		if(article.getDesignation() == null ||article.getDesignation().isBlank() || article.getDesignation().length() > 250) {
			throw new BLLException("La designation est obligatoire et sa taille < 200");
		}
		if(article.getQteStock() <= 0) {
			throw new BLLException("La quantite doit etre > 0");
		}
		if(article.getPrixUnitaire() <= 0) {
			throw new BLLException("Le prix doit etre > 0");
		}
		if(article instanceof Stylo) {
			if(((Stylo) article).getCouleur() == null ||((Stylo) article).getCouleur().isBlank() ||((Stylo) article).getCouleur().length() > 50) {
				throw new BLLException("La couleur est obligatoire et sa taille < 50");
			}
		}else if(article instanceof Ramette){
			if(((Ramette) article).getGrammage() <= 0) {
				throw new BLLException("Le grammage doit etre > 0");
			}
		}
		
	}
	
}
