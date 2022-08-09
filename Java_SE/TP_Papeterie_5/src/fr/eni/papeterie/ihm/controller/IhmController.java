package fr.eni.papeterie.ihm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bll.CatalogueManager;
import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.ihm.vue.EcranPapeterie;

public class IhmController {
	
	private static int indexList = 0;
	private static Article currentArticle;
	private static List<Article> list = new ArrayList<>();
	private static EcranPapeterie ecranPapeterie;
	private static CatalogueManager catalogue;
	
	public IhmController() {};
	
	//init instances
	public void initInstances() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				
				//init instances
				ecranPapeterie = new EcranPapeterie();
				catalogue = CatalogueManager.getInstance();
				//init liste articles
				try {
					list = catalogue.getCatalogue();
				} catch (BLLException e3) {
					e3.printStackTrace();
				}
			}
		});
	}
	
	//Getters - Setters
	public static int getIndexList() {
		return indexList;
	}
	public static void setIndexList(int indexList) {
		IhmController.indexList = indexList;
	}
	public static Article getCurrentArticle() {
		return currentArticle;
	}
	public static void setCurrentArticle(Article currentArticle) {
		IhmController.currentArticle = currentArticle;
	}
	public static List<Article> getList() {
		return list;
	}
	public static void setList(List<Article> list) {
		IhmController.list = list;
	}
	public static EcranPapeterie getEcranPapeterie() {
		return ecranPapeterie;
	}
	public static void setEcranPapeterie(EcranPapeterie ecranPapeterie) {
		IhmController.ecranPapeterie = ecranPapeterie;
	}
	public static CatalogueManager getCatalogue() {
		return catalogue;
	}
	public static void setCatalogue(CatalogueManager catalogue) {
		IhmController.catalogue = catalogue;
	}

}
