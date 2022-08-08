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

public class TestIhm {
	
	private static int indexList = 0;
	private static Article currentArticle;
	
	public static void main(String[] args) {
		
		
		//Afficher IHM
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				//init instances
				EcranPapeterie ecranPapeterie = new EcranPapeterie();
				CatalogueManager catalogue = CatalogueManager.getInstance();
				//Listeners Radio Type
				ecranPapeterie.getRadioRamette().addActionListener(e -> {
					enableFields(ecranPapeterie);
				});	
				ecranPapeterie.getRadioStylo().addActionListener(e -> {
					enableFields(ecranPapeterie);
				});	
				
				//Delete Button
				ecranPapeterie.getBtnDelete().addActionListener(e -> {
					try {
						deleteArticle(catalogue, indexList);
					} catch (BLLException e1) {
						e1.printStackTrace();
					}
				});	
				
				//Previous Button
				ecranPapeterie.getBtnPrevious().addActionListener(e -> {
					try {
						previousArticle(catalogue);
						printArticle(currentArticle, ecranPapeterie);
					} catch (BLLException e1) {
						e1.printStackTrace();
					}
				});	
				//Next Button
				ecranPapeterie.getBtnNext().addActionListener(e -> {
					try {
						nextArticle(catalogue);
						printArticle(currentArticle, ecranPapeterie);
					} catch (BLLException e1) {
						e1.printStackTrace();
					}
				});	
				//Add Article Button
				ecranPapeterie.getBtnNouvelArticle().addActionListener(e -> {
					addArticle(catalogue, ecranPapeterie);
				});	
			}
		});
	}
	
	//METHODS
	//
	public static void saveArticle(CatalogueManager catalogue, EcranPapeterie ecran) throws BLLException {
		Article articleAdd = null;
		String reference = ecran.getTxtReference().getText();
		String designation = ecran.getTxtDesignation().getText();
		String marque = ecran.getTxtMarque().getText();
		int qteStock = Integer.valueOf(ecran.getTxtQteStock().getText());
		float prix = Float.valueOf(ecran.getTxtPrix().getText());
		
		if(ecran.getRadioStylo().isSelected()) {
			String color = (String) ecran.getColorCombo().getSelectedItem();
			articleAdd = new Stylo(reference, designation, marque, prix, qteStock, color);
		}else {
			int grammage;
			if(ecran.getChk80().isSelected()) {
				grammage = 80;
			}else grammage = 100;
			articleAdd = new Ramette(reference, designation, marque, prix, qteStock, grammage);
		}	
		catalogue.addArticle(articleAdd);
	}
	public static void nextArticle(CatalogueManager catalogue) throws BLLException {
		List<Article> articleList = new ArrayList<Article>();
		articleList = catalogue.getCatalogue();
		if(indexList == articleList.size() - 1) {	
			currentArticle =  articleList.get(0);
			indexList = 0;
			System.out.println(indexList);
		}else {
			indexList  += 1;
			currentArticle = articleList.get(indexList);
			
		}	
	}
	public static void previousArticle(CatalogueManager catalogue) throws BLLException {
		List<Article> articleList = new ArrayList<Article>();
		articleList = catalogue.getCatalogue();
		if(indexList == 0) {	
			currentArticle =  articleList.get(articleList.size()-1);
			indexList = (articleList.size() - 1);
			System.out.println(indexList);
		}else {
			indexList  -= 1;
			currentArticle = articleList.get(indexList);
			
		}	
	}
	
	public static void deleteArticle(CatalogueManager catalogue, int index) throws BLLException {
				catalogue.removeArticle(catalogue.getArticle(index));
	}
	
	public static void printArticle(Article article, EcranPapeterie ecran) throws BLLException {
		ecran.getTxtDesignation().setText(article.getDesignation());
		ecran.getTxtReference().setText(article.getReference());
		ecran.getTxtMarque().setText(article.getMarque());
		ecran.getTxtQteStock().setText(String.valueOf(article.getQteStock()));
		ecran.getTxtPrix().setText(String.valueOf(article.getPrixUnitaire()));
	}
	public static void resetFields(EcranPapeterie ecran) {
		ecran.getTxtDesignation().setText("");
		ecran.getTxtReference().setText("");
		ecran.getTxtMarque().setText("");
		ecran.getTxtQteStock().setText("");
		ecran.getTxtPrix().setText("");
	}
	
	public static void addArticle(CatalogueManager catalogue, EcranPapeterie ecran) {
		resetFields(ecran);
		ecran.getRadioStylo().setEnabled(true);
		ecran.getRadioStylo().setSelected(true);
		ecran.getRadioRamette().setEnabled(true);
		ecran.getColorCombo().setEnabled(true);
	}
	
	public static void enableFields(EcranPapeterie ecran) {
		if(ecran.getRadioStylo().isSelected()) {
			ecran.getChk80().setEnabled(false);
			ecran.getChk100().setEnabled(false);
			ecran.getColorCombo().setEnabled(true);
		}else {
			ecran.getChk80().setEnabled(true);
			ecran.getChk100().setEnabled(true);
			ecran.getColorCombo().setEnabled(false);
		}
	}
	
}
