package fr.eni.papeterie.ihm.controller;

import java.util.List;

import javax.swing.SwingUtilities;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bll.CatalogueManager;
import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.ihm.vue.EcranPapeterie;

public class PapeterieController {

	public static void main(String[] args) {
		//Afficher IHM
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				EcranPapeterie ecranPapeterie = new EcranPapeterie();
			}
		});
		
		//Create new Catalogue
		CatalogueManager catalogue = CatalogueManager.getInstance();
		
		//Get all products
		List<Article> catalogueList = null;
		try {
			catalogueList = catalogue.getCatalogue();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//print catalogue list
		System.out.println(catalogueList);
		
		//

	}
	
	
}
