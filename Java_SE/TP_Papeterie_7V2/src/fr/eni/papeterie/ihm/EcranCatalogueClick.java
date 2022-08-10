package fr.eni.papeterie.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.eni.papeterie.bo.Article;


public class EcranCatalogueClick {
	//----
	private Article currentArticle;
	
	
	//SINGLETON
		private static EcranCatalogueClick instance;
		
		private EcranCatalogueClick() { }
		
		public static EcranCatalogueClick getInstance() {
			if(instance == null) {
				instance = new EcranCatalogueClick();
			}
			return instance;
		}
		//FIN SINGLETON
		
		//Pattern observer
		public interface ListenersClick{
			void getArticleSelected();
			
		}	
		//Liste objets observabes
		private List<ListenersClick> observateursList = new ArrayList<>();
		
		public void ajouterObservateur(ListenersClick ListenersClick) {
			observateursList.add(ListenersClick);
		}
		
		//unregisterListener ou unregister ou unbind
		public void retirerObservateur(ListenersClick ListenersClick) {
			observateursList.remove(ListenersClick);
		}
		
		//notify ou notifyAll
		public void prevenirClick() {
			for(ListenersClick listener : observateursList) {
				listener.getArticleSelected();
			}
		}

		public Article getCurrentArticle() {
			return currentArticle;
		}

		public void setCurrentArticle(Article currentArticle) {
			this.currentArticle = currentArticle;
		}
		
		
		
}
