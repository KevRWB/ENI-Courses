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
	private static boolean inEdition = false;
	
	public static void main(String[] args) {	
		//Afficher IHM
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
				
				//init print
				if(list.size() == 0) {
					resetFields();
				}else {
					try {
						currentArticle = catalogue.getCatalogue().get(0);
						printArticle();
					} catch (BLLException e2) {
						e2.printStackTrace();
					}
				}
			
				//Listeners Radio Type -> enable fields on click
				ecranPapeterie.getRadioRamette().addActionListener(e -> {
					enableFields();
				});	
				ecranPapeterie.getRadioStylo().addActionListener(e -> {
					enableFields();
				});	
				
				//Delete Button
				ecranPapeterie.getBtnDelete().addActionListener(e -> {
					try {
						deleteArticle();
					} catch (BLLException e1) {
						e1.printStackTrace();
					}
				});	
				
				//Previous Button
				ecranPapeterie.getBtnPrevious().addActionListener(e -> {
					
					try {
						previousArticle();
						printArticle();
					} catch (BLLException e1) {
						e1.printStackTrace();
					}
				});	
				//Next Button
				ecranPapeterie.getBtnNext().addActionListener(e -> {
					try {
						nextArticle();
						printArticle();
					} catch (BLLException e1) {
						e1.printStackTrace();
					}
				});	
				//Add Article Button
				ecranPapeterie.getBtnNouvelArticle().addActionListener(e -> {
					addArticle();
				});	
				
				//Save Article Button
				ecranPapeterie.getBtnSave().addActionListener(e -> {
					try {
						saveArticle();
					} catch (BLLException e1) {
						e1.printStackTrace();
					}
				});	
			}
		});
	}
	
	//METHODS
	//
	public static void addArticle() {
		inEdition = true;
		resetFields();
		ecranPapeterie.getRadioStylo().setEnabled(true);
		ecranPapeterie.getRadioStylo().setSelected(true);
		ecranPapeterie.getRadioRamette().setEnabled(true);
		ecranPapeterie.getColorCombo().setEnabled(true);
	}
	public static void saveArticle() throws BLLException {
		//Recupere donnees champs de texte
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
		//Si creation d'un nouvel article
		if(inEdition) {		
			catalogue.addArticle(articleAdd);
		//Si update d'un article
		} else {	
			catalogue.updateArticle(currentArticle);
		}		
		list = catalogue.getCatalogue();
	}
	public static void nextArticle() throws BLLException {
		inEdition = false;
		//disabled fields
		disableFields();
		//set next article
		if(list.size() == 0) {
			resetFields();
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
	public static void previousArticle() throws BLLException {
		inEdition = false;
		//disabled fields
		disableFields();
		//set previous article
		if(list.size() == 0) {
			resetFields();
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
	public static void deleteArticle() throws BLLException {
		inEdition = false;
		if(list.size() == 0) {
			resetFields();
		}else {
			catalogue.removeArticle(currentArticle);
			indexList --;
			list = catalogue.getCatalogue();
			
			if(indexList == 0) {
				nextArticle();
				printArticle();
			} else if(indexList == list.size()-1) {
				nextArticle();
				printArticle();
			}else {
				nextArticle();
				printArticle();
			}
		}
	}
	
	public static void printArticle() throws BLLException {
		List<Article> list = catalogue.getCatalogue();
		if(list.size()== 0) {
			resetFields();
		}else {
			if(currentArticle instanceof Stylo) {
				ecranPapeterie.getRadioStylo().setSelected(true);
			}else ecranPapeterie.getRadioRamette().setSelected(true);
			ecranPapeterie.getTxtDesignation().setText(currentArticle.getDesignation());
			ecranPapeterie.getTxtReference().setText(currentArticle.getReference());
			ecranPapeterie.getTxtMarque().setText(currentArticle.getMarque());
			ecranPapeterie.getTxtQteStock().setText(String.valueOf(currentArticle.getQteStock()));
			ecranPapeterie.getTxtPrix().setText(String.valueOf(currentArticle.getPrixUnitaire()));
		}
	}
	public static void resetFields() {
		ecranPapeterie.getTxtDesignation().setText("");
		ecranPapeterie.getTxtReference().setText("");
		ecranPapeterie.getTxtMarque().setText("");
		ecranPapeterie.getTxtQteStock().setText("");
		ecranPapeterie.getTxtPrix().setText("");
	}	
	public static void enableFields() {
		if(ecranPapeterie.getRadioStylo().isSelected()) {
			ecranPapeterie.getChk80().setEnabled(false);
			ecranPapeterie.getChk100().setEnabled(false);
			ecranPapeterie.getColorCombo().setEnabled(true);
		}else {
			ecranPapeterie.getChk80().setEnabled(true);
			ecranPapeterie.getChk80().setSelected(true);;
			ecranPapeterie.getChk100().setEnabled(true);
			ecranPapeterie.getColorCombo().setEnabled(false);		
		}
	}
	public static void disableFields() {
		ecranPapeterie.getRadioRamette().setEnabled(false);
		ecranPapeterie.getRadioStylo().setEnabled(false);
		ecranPapeterie.getChk80().setEnabled(false);
		ecranPapeterie.getChk100().setEnabled(false);
		ecranPapeterie.getColorCombo().setEnabled(false);
	}
	
}
