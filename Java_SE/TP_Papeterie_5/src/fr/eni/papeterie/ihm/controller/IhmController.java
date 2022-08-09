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
	
	public static void main(String[] args) {	
		//Afficher IHM
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				
				//init instances
				EcranPapeterie ecranPapeterie = new EcranPapeterie();
				CatalogueManager catalogue = CatalogueManager.getInstance();
				//init liste articles
				try {
					list = catalogue.getCatalogue();
				} catch (BLLException e3) {
					e3.printStackTrace();
				}
				
				//init print
				if(list.size() == 0) {
					resetFields(ecranPapeterie);
				}else {
					try {
						currentArticle = catalogue.getCatalogue().get(0);
						printArticle(currentArticle, ecranPapeterie, catalogue);
					} catch (BLLException e2) {
						e2.printStackTrace();
					}
				}
			
				//Listeners Radio Type -> enable fields on click
				ecranPapeterie.getRadioRamette().addActionListener(e -> {
					enableFields(ecranPapeterie);
				});	
				ecranPapeterie.getRadioStylo().addActionListener(e -> {
					enableFields(ecranPapeterie);
				});	
				
				//Delete Button
				ecranPapeterie.getBtnDelete().addActionListener(e -> {
					try {
						deleteArticle(catalogue, ecranPapeterie);
					} catch (BLLException e1) {
						e1.printStackTrace();
					}
				});	
				
				//Previous Button
				ecranPapeterie.getBtnPrevious().addActionListener(e -> {
					
					try {
						previousArticle(ecranPapeterie);
						printArticle(currentArticle, ecranPapeterie, catalogue);
					} catch (BLLException e1) {
						e1.printStackTrace();
					}
				});	
				//Next Button
				ecranPapeterie.getBtnNext().addActionListener(e -> {
					try {
						nextArticle(ecranPapeterie);
						printArticle(currentArticle, ecranPapeterie, catalogue);
					} catch (BLLException e1) {
						e1.printStackTrace();
					}
				});	
				//Add Article Button
				ecranPapeterie.getBtnNouvelArticle().addActionListener(e -> {
					addArticle(catalogue, ecranPapeterie);
				});	
				
				//Save Article Button
				ecranPapeterie.getBtnSave().addActionListener(e -> {
					try {
						saveArticle();
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});	
			}
		});
	}
	
	//METHODS
	//
	public static void saveArticle() throws BLLException {
		Article articleAdd = null;
		String reference = ecranPapeterie.getTxtReference().getText();
		String designation = ecranPapeterie.getTxtDesignation().getText();
		String marque = ecranPapeterie.getTxtMarque().getText();
		int qteStock = Integer.valueOf(ecranPapeterie.getTxtQteStock().getText());
		float prix = Float.valueOf(ecranPapeterie.getTxtPrix().getText());
		
		if(ecranPapeterie.getRadioStylo().isSelected()) {
			String color = (String) ecranPapeterie.getColorCombo().getSelectedItem();
			articleAdd = new Stylo(reference, designation, marque, prix, qteStock, color);
		}else {
			int grammage;
			if(ecranPapeterie.getChk80().isSelected()) {
				grammage = 80;
			}else grammage = 100;
			articleAdd = new Ramette(reference, designation, marque, prix, qteStock, grammage);
		}	
		catalogue.addArticle(articleAdd);
		list = catalogue.getCatalogue();
	}
	public static void nextArticle(EcranPapeterie ecranPapeterie) throws BLLException {
		//disabled fields
		disableFields(ecranPapeterie);
		//set next article
		if(list.size() == 0) {
			resetFields(ecranPapeterie);
		}else {
			if(indexList == list.size() - 1) {	
				currentArticle =  list.get(0);
				indexList = 0;
				System.out.println(indexList);
			}else {
				indexList  += 1;
				currentArticle = list.get(indexList);
			}	
		}	
	}
	public static void previousArticle(EcranPapeterie ecranPapeterie) throws BLLException {
		//disabled fields
		disableFields(ecranPapeterie);
		//set previous article
		if(list.size() == 0) {
			resetFields(ecranPapeterie);
		}else {
			if(indexList == 0) {	
				currentArticle =  list.get(list.size()-1);
				indexList = (list.size() - 1);
				System.out.println(indexList);
			}else {
				indexList  -= 1;
				currentArticle = list.get(indexList);	
			}	
		}	
	}
	
	public static void deleteArticle(CatalogueManager catalogue, EcranPapeterie ecranPapeterie) throws BLLException {
		if(list.size() == 0) {
			resetFields(ecranPapeterie);
		}else {
			catalogue.removeArticle(currentArticle);
			indexList --;
			list = catalogue.getCatalogue();
			
			if(indexList == 0) {
				nextArticle(ecranPapeterie);
				printArticle(currentArticle, ecranPapeterie, catalogue);
			} else if(indexList == list.size()-1) {
				nextArticle(ecranPapeterie);
				printArticle(currentArticle, ecranPapeterie, catalogue);
			}else {
				nextArticle(ecranPapeterie);
				printArticle(currentArticle, ecranPapeterie, catalogue);
			}
		}
	}
	
	public static void printArticle(Article article, EcranPapeterie ecran, CatalogueManager catalogue) throws BLLException {
		List<Article> list = catalogue.getCatalogue();
		if(list.size()== 0) {
			resetFields(ecran);
		}else {
			ecran.getTxtDesignation().setText(article.getDesignation());
			ecran.getTxtReference().setText(article.getReference());
			ecran.getTxtMarque().setText(article.getMarque());
			ecran.getTxtQteStock().setText(String.valueOf(article.getQteStock()));
			ecran.getTxtPrix().setText(String.valueOf(article.getPrixUnitaire()));
		}
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
			ecran.getChk80().setSelected(true);;
			ecran.getChk100().setEnabled(true);
			ecran.getColorCombo().setEnabled(false);
			
		}
	}
	public static void disableFields(EcranPapeterie ecran) {
		ecran.getRadioRamette().setEnabled(false);
		ecran.getRadioStylo().setEnabled(false);
		ecran.getChk80().setEnabled(false);
		ecran.getChk100().setEnabled(false);
		ecran.getColorCombo().setEnabled(false);
	}
	
}
