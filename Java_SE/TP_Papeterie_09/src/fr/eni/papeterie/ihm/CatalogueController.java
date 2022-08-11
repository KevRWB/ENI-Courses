package fr.eni.papeterie.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bll.CatalogueManager;
import fr.eni.papeterie.bo.Article;

public class CatalogueController {

	//SINGLETON
	private static CatalogueController instance;
	
	private CatalogueController() { }
	
	public static CatalogueController getInstance() {
		if(instance == null) {
			instance = new CatalogueController();
		}
		return instance;
	}
	//FIN SINGLETON
	
	public interface CatalogueControllerListener {
		void onArticleSelectionne(Article article);
	}
	
	private List<CatalogueControllerListener> listeners = new ArrayList<>();

	private int position = 0;
	
	public int getPosition() {
		return position;
	}
	
	/**
	 * Permet d'ajouter un listener à ce contrôleur
	 * @param listener
	 */
	public void addListener(CatalogueControllerListener listener) {
		this.listeners.add(listener);
	}

	public Article getPremierArticle() throws BLLException, ArticleNotFoundException {
		List<Article> articles = CatalogueManager.getInstance().getCatalogue();
		if(articles.size() == 0) {
			throw new ArticleNotFoundException();
		}
		return articles.get(0);
	}

	public Article getArticleSuivant() throws BLLException, ArticleNotFoundException {
		List<Article> articles = CatalogueManager.getInstance().getCatalogue();
		
		//s'il n'y a pas d'article suivant
		if(position + 1 >= articles.size()) {
			//lève une exception
			throw new ArticleNotFoundException();
		}
		
		//sinon, renvoie l'article à la position 'position'
		position++;
		return articles.get(position);
	}
	
	public Article getArticlePrecedent() throws BLLException, ArticleNotFoundException {
		List<Article> articles = CatalogueManager.getInstance().getCatalogue();
		
		//s'il n'y a pas d'article suivant
		if(position - 1 < 0) {
			//lève une exception
			throw new ArticleNotFoundException();
		}
		
		//sinon, renvoie l'article à la position 'position'
		position--;
		return articles.get(position);
	}

	public void insererNouvelArticle(Article nouvelArticle) throws BLLException {
		CatalogueManager.getInstance().addArticle(nouvelArticle);
	}

	public void updateArticle(Article article) throws BLLException {
		CatalogueManager.getInstance().updateArticle(article);
	}

	public Article getDernierArticle() throws BLLException {
		List<Article> articles = CatalogueManager.getInstance().getCatalogue();
		position = articles.size() - 1;
		return articles.get(position);		
	}

	public void supprimerArticle(int idArticle) throws BLLException {
		CatalogueManager.getInstance().removeArticle(idArticle);
	}

	public Article getArticleCourant() throws BLLException, ArticleNotFoundException {
		List<Article> articles = CatalogueManager.getInstance().getCatalogue();
		
		//si la position est hors limite de la liste
		if(position < 0 || position >= articles.size()) {
			throw new ArticleNotFoundException();
		}
		
		return articles.get(position);
	}

	public List<Article> getCatalogue() throws BLLException {
		return CatalogueManager.getInstance().getCatalogue();
	}

	public void setArticleSelectionne(Article articleSelectionne) throws BLLException {
		List<Article> articles = CatalogueManager.getInstance().getCatalogue();
		position = 0;
		for(Article a : articles) {
			position++;
			if(a.getIdArticle() == articleSelectionne.getIdArticle()) {
				//préviens chaque listener d'afficher l'article a
				for(CatalogueControllerListener listener : listeners) {
					listener.onArticleSelectionne(a);
				}
				break;
			}
		}
		
	}
	
	
}
