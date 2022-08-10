package fr.eni.papeterie.bll;

import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DALException;
import fr.eni.papeterie.dal.DAOFactory;

public class CatalogueManager {

	private static CatalogueManager instance;

	private ArticleDAO dao;
	
	private CatalogueManager() {
		dao = DAOFactory.getArticleDAO();
	}

	public static CatalogueManager getInstance() {
		if (instance == null) {
			instance = new CatalogueManager();
		}
		return instance;
	}

	public void addArticle(Article a) throws BLLException {
		// 1. validation des données de l'article
		validerArticle(a);

		// 2. si l'article a été validé, on peut l'envoyer à la DAL
		try {
			dao.insert(a);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e.getMessage());
		}
	}
	
	public void updateArticle(Article a) throws BLLException {
		// 1. validation des données de l'article
		validerArticle(a);

		// 2. si l'article a été validé, on peut l'envoyer à la DAL
		try {
			dao.update(a);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e.getMessage());
		}
	}
	
	public List<Article> getCatalogue() throws BLLException {
		try {
			return dao.selectAll();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e.getMessage());
		}
	}
	
	public void removeArticle(int idArticle) throws BLLException {
		validationIdArticle(idArticle);
		
		try {
			dao.delete(idArticle);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e.getMessage());
		}
	}
	
	public Article getArticle(int idArticle) throws BLLException {
		validationIdArticle(idArticle);
		
		try {
			return dao.selectById(idArticle);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e.getMessage());
		}
	}

	private void validerArticle(Article a) throws BLLException {
		validationDesignation(a.getDesignation());
		validationMarque(a.getMarque());
		validationReference(a.getReference());
		validationPrixUnitaire(a.getPrixUnitaire());
		validationQteStock(a.getQteStock());
		if (a instanceof Ramette) {
			validationGrammage(((Ramette) a).getGrammage());
		} else {
			validationCouleur(((Stylo) a).getCouleur());
		}
	}
	
	private void validationIdArticle(int id) throws BLLException {
		if(id < 1) {
			throw new BLLException("L'ID doit être > 0");
		}
	}

	private void validationReference(String reference) throws BLLException {
		if (reference == null || reference.isBlank() || reference.length() > 10) {
			throw new BLLException("La référence est obligatoire et doit être <= 10 caractères");
		}
	}

	private void validationMarque(String marque) throws BLLException {
		if (marque == null || marque.isBlank() || marque.length() > 200) {
			throw new BLLException("La marque est obligatoire et doit être <= 200 caractères");
		}
	}

	private void validationDesignation(String designation) throws BLLException {
		if (designation == null || designation.isBlank() || designation.length() > 250) {
			throw new BLLException("La designation est obligatoire et doit être <= 250 caractères");
		}
	}

	private void validationPrixUnitaire(float prixUnitaire) throws BLLException {
		if (prixUnitaire <= 0) {
			throw new BLLException("Le prix unitaire doit être >= 0");
		}
	}

	private void validationQteStock(int qteStock) throws BLLException {
		if (qteStock <= 0) {
			throw new BLLException("La quantité stock doit être >= 0");
		}
	}

	private void validationCouleur(String couleur) throws BLLException {
		if (couleur == null || couleur.isBlank() || couleur.length() > 50) {
			throw new BLLException("La couleur est obligatoire et doit être <= 250 caractères");
		}
	}

	private void validationGrammage(int grammage) throws BLLException {
		if (grammage <= 0) {
			throw new BLLException("Le grammage doit être >= 0");
		}
	}
	
}
