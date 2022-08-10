package fr.eni.papeterie.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;

public class PanelBouton {
	private JPanel panelBoutons;

	private JButton btnPrecedent;
	private JButton btnNouveau;
	private JButton btnEnregistrer;
	private JButton btnSupprimer;
	private JButton btnSuivant;
	
	private EcranPapeterie ecranPapeterie = EcranPapeterie.getInstance();
	
	//SINGLETON
	private static PanelBouton instance;
	
	private PanelBouton() { }
	
	public static PanelBouton getInstance() {
		if(instance == null) {
			instance = new PanelBouton();
		}
		return instance;
	}
	//FIN SINGLETON

	//buttons
	public JPanel getPanelBoutons() {
		if (panelBoutons == null) {
			panelBoutons = new JPanel();

			panelBoutons.add(getBtnPrecedent());
			panelBoutons.add(getBtnNouveau());
			panelBoutons.add(getBtnEnregistrer());
			panelBoutons.add(getBtnSupprimer());
			panelBoutons.add(getBtnSuivant());

		}
		return panelBoutons;
	}
	
	private JButton getBtnPrecedent() {
		if (btnPrecedent == null) {
			ImageIcon icon = new ImageIcon(getClass().getResource("images/Back24.gif"));
			btnPrecedent = new JButton(icon);
			//version lambda
			btnPrecedent.addActionListener(e -> {
				precedent();
			});
		}
		return btnPrecedent;
	}

	private JButton getBtnNouveau() {
		if (btnNouveau == null) {
			ImageIcon icon = new ImageIcon(getClass().getResource("images/New24.gif"));
			btnNouveau = new JButton(icon);
			btnNouveau.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					nouveau();
				}
			});
		}
		return btnNouveau;
	}	

	private JButton getBtnEnregistrer() {
		if (btnEnregistrer == null) {
			ImageIcon icon = new ImageIcon(getClass().getResource("images/Save24.gif"));
			btnEnregistrer = new JButton(icon);
			btnEnregistrer.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					enregistrer();
				}
			});
		}
		return btnEnregistrer;
	}

	private JButton getBtnSupprimer() {
		if (btnSupprimer == null) {
			ImageIcon icon = new ImageIcon(getClass().getResource("images/Delete24.gif"));
			btnSupprimer = new JButton(icon);
			btnSupprimer.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					supprimer();
				}
			});
		}
		return btnSupprimer;
	}

	private JButton getBtnSuivant() {
		if (btnSuivant == null) {
			ImageIcon icon = new ImageIcon(getClass().getResource("images/Forward24.gif"));
			btnSuivant = new JButton(icon);
			btnSuivant.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					suivant();
				}
			});
		}
		return btnSuivant;
	}
	
	//Methods
	private void suivant() {
		try {
			Article articleSuivant = CatalogueController.getInstance().getArticleSuivant();
			ecranPapeterie.afficherArticle(articleSuivant);
		} catch (ArticleNotFoundException ae) {
			ae.printStackTrace();
			JOptionPane.showMessageDialog(EcranPapeterie.getInstance(), "Vous avez atteint la fin de la liste");
		} catch (BLLException be) {
			be.printStackTrace();
		}
	}
	
	private void precedent() {
		try {
			Article articlePrecedent = CatalogueController.getInstance().getArticlePrecedent();
			ecranPapeterie.afficherArticle(articlePrecedent);
		} catch (ArticleNotFoundException ae) {
			ae.printStackTrace();
			JOptionPane.showMessageDialog(ecranPapeterie, "Vous avez atteint le début de la liste");
		} catch (BLLException be) {
			be.printStackTrace();
		}
	}
	
	private void nouveau() {
		ecranPapeterie.setArticleEnTrainDEtreAffiche(null);
		
		ecranPapeterie.getTxtReference().setText("");
		ecranPapeterie.getTxtDesignation().setText("");
		ecranPapeterie.getTxtMarque().setText("");
		ecranPapeterie.getTxtPrix().setText("");
		ecranPapeterie.getTxtStock().setText("");
		
		ecranPapeterie.initCheckAndRadio(true);
	}
	private void enregistrer() {
		//1. on récupère les valeurs du formulaire
		String reference = ecranPapeterie.getTxtReference().getText();
		String designation = ecranPapeterie.getTxtDesignation().getText();
		String marque = ecranPapeterie.getTxtMarque().getText();
		
		int qteStock = 0;
		try {
			qteStock = Integer.parseInt(ecranPapeterie.getTxtStock().getText());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		float prixUnitaire = 0;
		try {
			prixUnitaire = Float.parseFloat(ecranPapeterie.getTxtPrix().getText());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		//TODO : code à factoriser, on peut faire bcp mieux
		
		//Si c'est une ramette
		if(ecranPapeterie.getRadioRamette().isSelected()) { //on a sélectionné le radio bouton ramette
			
			//ternaire (variable = condition ? valeur true: valeur false;
			int grammage = ecranPapeterie.getChk80().isSelected() ? 80 : 100;
			//version if...else...
//			if(getChk80().isSelected() == true) {
//				grammage = 80;
//			} else {
//				grammage = 100;
//			}
			
			//2. il s'agit d'un nouvel article
			if(ecranPapeterie.getArticleEnTrainDEtreAffiche() == null) { //on va ajouter un nouvel article (il y n'avait pas d'article en cours d'affichage)
				Article nouvelArticle = new Ramette(reference, marque, designation, prixUnitaire, qteStock, grammage);
				try {
					CatalogueController.getInstance().insererNouvelArticle(nouvelArticle);
					Article a = CatalogueController.getInstance().getDernierArticle();
					ecranPapeterie.afficherArticle(a);				
				} catch (BLLException e) {
					e.printStackTrace();
				}
			} else { //on va mettre à jour
				ecranPapeterie.getArticleEnTrainDEtreAffiche().setDesignation(designation);
				ecranPapeterie.getArticleEnTrainDEtreAffiche().setMarque(marque);
				ecranPapeterie.getArticleEnTrainDEtreAffiche().setPrixUnitaire(prixUnitaire);
				ecranPapeterie.getArticleEnTrainDEtreAffiche().setQteStock(qteStock);
				ecranPapeterie.getArticleEnTrainDEtreAffiche().setReference(reference);
				((Ramette)ecranPapeterie.getArticleEnTrainDEtreAffiche()).setGrammage(grammage);
				try {
					CatalogueController.getInstance().updateArticle(ecranPapeterie.getArticleEnTrainDEtreAffiche());
				} catch (BLLException e) {
					e.printStackTrace();
				}
			}
	
		} else { //sinon, stylo
			String couleur = (String) ecranPapeterie.getCmbCouleur().getSelectedItem();
			
			if(ecranPapeterie.getArticleEnTrainDEtreAffiche() == null) { //on va ajouter un nouvel article (il y n'avait pas d'article en cours d'affichage)
				Article nouvelArticle = new Stylo(reference, marque, designation, prixUnitaire, qteStock, couleur);
				try {
					CatalogueController.getInstance().insererNouvelArticle(nouvelArticle);
					Article a = CatalogueController.getInstance().getDernierArticle();
					ecranPapeterie.afficherArticle(a);				
				} catch (BLLException e) {
					e.printStackTrace();
				}
			} else { //on va mettre à jour
				ecranPapeterie.getArticleEnTrainDEtreAffiche().setDesignation(designation);
				ecranPapeterie.getArticleEnTrainDEtreAffiche().setMarque(marque);
				ecranPapeterie.getArticleEnTrainDEtreAffiche().setPrixUnitaire(prixUnitaire);
				ecranPapeterie.getArticleEnTrainDEtreAffiche().setQteStock(qteStock);
				ecranPapeterie.getArticleEnTrainDEtreAffiche().setReference(reference);
				((Stylo)ecranPapeterie.getArticleEnTrainDEtreAffiche()).setCouleur(couleur);
				try {
					CatalogueController.getInstance().updateArticle(ecranPapeterie.getArticleEnTrainDEtreAffiche());
				} catch (BLLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private void supprimer() {
		if(ecranPapeterie.getArticleEnTrainDEtreAffiche() != null) {
			try {
				//1. on supprime dans la BDD (Controller -> BLL -> DAL -> BDD)
				CatalogueController.getInstance().supprimerArticle(ecranPapeterie.getArticleEnTrainDEtreAffiche().getIdArticle());
				
				//2. on essaye d'afficher l'article suivant dans la liste
				try {
					Article articleAAfficher = CatalogueController.getInstance().getArticleCourant();
					ecranPapeterie.afficherArticle(articleAAfficher);
				} catch (ArticleNotFoundException e) {
					//3.Si pas de suivant, on affiche l'article précédent
					e.printStackTrace();
					try {
						Article articleAAfficher = CatalogueController.getInstance().getArticlePrecedent();
						ecranPapeterie.afficherArticle(articleAAfficher);
					} catch (ArticleNotFoundException e1) {
						//4. pas de précédent non plus, affiche le formulaire de création
						e1.printStackTrace();
						nouveau();
					}	
				}		
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}
	}
}
