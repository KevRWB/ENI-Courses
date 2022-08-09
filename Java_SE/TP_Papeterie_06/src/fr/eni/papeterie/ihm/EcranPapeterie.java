package fr.eni.papeterie.ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;

public class EcranPapeterie extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel panelFormulaire;

	private JLabel lblReference;
	private JTextField txtReference;

	private JLabel lblDesignation;
	private JTextField txtDesignation;

	private JLabel lblMarque;
	private JTextField txtMarque;

	private JLabel lblStock;
	private JTextField txtStock;

	private JLabel lblPrix;
	private JTextField txtPrix;

	private ButtonGroup groupType;
	private JRadioButton radioRamette;
	private JRadioButton radioStylo;
	private JLabel lblType;

	private ButtonGroup groupGrammage;
	private JCheckBox chk80;
	private JCheckBox chk100;
	private JLabel lblGrammage;

	private JLabel lblCouleur;
	private JComboBox<String> cmbCouleur;

	private JPanel panelBoutons;

	private JButton btnPrecedent;
	private JButton btnNouveau;
	private JButton btnEnregistrer;
	private JButton btnSupprimer;
	private JButton btnSuivant;
	
	private Article articleEnTrainDEtreAffiche = null;

	public EcranPapeterie() {
		setTitle("TP papeterie");
		setVisible(true);
		setIconImage(new ImageIcon(getClass().getResource("images/aim.png")).getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(500, 450));
		setLocation(400, 100);

		add(getPanelFormulaire(), BorderLayout.CENTER);
		add(getPanelBoutons(), BorderLayout.SOUTH);

		// une fois l'écran chargé, on affiche le premier article
		try {
			Article premierArticle = CatalogueController.getInstance().getPremierArticle();
			afficherArticle(premierArticle);
		} catch (BLLException e) {
			e.printStackTrace();
		} catch (ArticleNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(EcranPapeterie.this, "Pas d'articles dans le catalogue");
		}
	}

	private void afficherArticle(Article articleAAfficher) {
		articleEnTrainDEtreAffiche = articleAAfficher;
		getTxtDesignation().setText(articleAAfficher.getDesignation());
		getTxtMarque().setText(articleAAfficher.getMarque());
		getTxtPrix().setText(String.valueOf(articleAAfficher.getPrixUnitaire()));
		getTxtReference().setText(articleAAfficher.getReference());
		getTxtStock().setText(String.valueOf(articleAAfficher.getQteStock()));

		if (articleAAfficher instanceof Ramette) {
			initCheckAndRadio(true);
			getRadioRamette().setSelected(true);
			if(((Ramette) articleAAfficher).getGrammage() == 80) {
				getChk80().setSelected(true);
			} else {
				getChk100().setSelected(true);
			}
		} else { // Stylo
			initCheckAndRadio(false);
			getRadioStylo().setSelected(true);
			getCmbCouleur().setSelectedItem(((Stylo) articleAAfficher).getCouleur());
		}
	}

	private JPanel getPanelFormulaire() {
		if (panelFormulaire == null) {
			panelFormulaire = new JPanel(new GridBagLayout());

			// Ligne 1
			addComponentToPanel(0, 0, getLblReference(), panelFormulaire);
			addComponentToPanel(0, 1, getTxtReference(), panelFormulaire);
			// Ligne 2
			addComponentToPanel(1, 0, getLblDesignation(), panelFormulaire);
			addComponentToPanel(1, 1, getTxtDesignation(), panelFormulaire);
			// Ligne 3
			addComponentToPanel(2, 0, getLblMarque(), panelFormulaire);
			addComponentToPanel(2, 1, getTxtMarque(), panelFormulaire);
			// Ligne 4
			addComponentToPanel(3, 0, getLblStock(), panelFormulaire);
			addComponentToPanel(3, 1, getTxtStock(), panelFormulaire);
			// Ligne 5
			addComponentToPanel(4, 0, getLblPrix(), panelFormulaire);
			addComponentToPanel(4, 1, getTxtPrix(), panelFormulaire);
			// Ligne 6
			groupType = new ButtonGroup();
			groupType.add(getRadioRamette());
			groupType.add(getRadioStylo());
			addComponentToPanel(5, 1, getRadioRamette(), panelFormulaire);
			addComponentToPanel(6, 1, getRadioStylo(), panelFormulaire);
			addComponentToPanel(5, 0, 2, getLblType(), panelFormulaire);
			// Ligne 7
			groupGrammage = new ButtonGroup();
			groupGrammage.add(getChk80());
			groupGrammage.add(getChk100());
			addComponentToPanel(7, 1, getChk80(), panelFormulaire);
			addComponentToPanel(8, 1, getChk100(), panelFormulaire);
			addComponentToPanel(7, 0, 2, getLblGrammage(), panelFormulaire);
			// Ligne 8
			addComponentToPanel(9, 0, getLblCouleur(), panelFormulaire);
			addComponentToPanel(9, 1, getCmbCouleur(), panelFormulaire);

			initCheckAndRadio(true);
		}
		return panelFormulaire;
	}

	private void addComponentToPanel(int ligne, int col, int height, JComponent component, JPanel panel) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = col;
		gbc.gridy = ligne;
		gbc.gridheight = height;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel.add(component, gbc);
	}

	private void addComponentToPanel(int ligne, int col, JComponent component, JPanel panel) {
		addComponentToPanel(ligne, col, 1, component, panel);
	}

	private JLabel getLblReference() {
		if (lblReference == null) {
			lblReference = new JLabel("Référence :");
		}
		return lblReference;
	}

	private JTextField getTxtReference() {
		if (txtReference == null) {
			txtReference = new JTextField(30);
		}
		return txtReference;
	}

	private JLabel getLblDesignation() {
		if (lblDesignation == null) {
			lblDesignation = new JLabel("Désignation :");
		}
		return lblDesignation;
	}

	private JTextField getTxtDesignation() {
		if (txtDesignation == null) {
			txtDesignation = new JTextField(30);
		}
		return txtDesignation;
	}

	private JLabel getLblMarque() {
		if (lblMarque == null) {
			lblMarque = new JLabel("Marque :");
		}
		return lblMarque;
	}

	private JTextField getTxtMarque() {
		if (txtMarque == null) {
			txtMarque = new JTextField(30);
		}
		return txtMarque;
	}

	private JLabel getLblStock() {
		if (lblStock == null) {
			lblStock = new JLabel("Stock :");
		}
		return lblStock;
	}

	private JTextField getTxtStock() {
		if (txtStock == null) {
			txtStock = new JTextField(30);
		}
		return txtStock;
	}

	private JLabel getLblPrix() {
		if (lblPrix == null) {
			lblPrix = new JLabel("Prix :");
		}
		return lblPrix;
	}

	private JTextField getTxtPrix() {
		if (txtPrix == null) {
			txtPrix = new JTextField(30);
		}
		return txtPrix;
	}

	private JRadioButton getRadioRamette() {
		if (radioRamette == null) {
			radioRamette = new JRadioButton("Ramette", true);
			radioRamette.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					initCheckAndRadio(true);
				}
			});
		}
		return radioRamette;
	}

	private JRadioButton getRadioStylo() {
		if (radioStylo == null) {
			radioStylo = new JRadioButton("Stylo");
			radioStylo.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					initCheckAndRadio(false);
				}
			});
		}
		return radioStylo;
	}

	/**
	 * 
	 * @param isRamette true quand c'est une ramette, false sinon
	 */
	protected void initCheckAndRadio(boolean isRamette) {
		getRadioRamette().setSelected(isRamette);
		
		getLblCouleur().setEnabled(!isRamette);
		getCmbCouleur().setEnabled(!isRamette);

		getLblGrammage().setEnabled(isRamette);
		getChk80().setEnabled(isRamette);
		getChk100().setEnabled(isRamette);
	}

	private JLabel getLblType() {
		if (lblType == null) {
			lblType = new JLabel("Type :");
		}
		return lblType;
	}

	private JCheckBox getChk80() {
		if (chk80 == null) {
			chk80 = new JCheckBox("80 grammes", true);
		}
		return chk80;
	}

	private JCheckBox getChk100() {
		if (chk100 == null) {
			chk100 = new JCheckBox("100 grammes");
		}
		return chk100;
	}

	private JLabel getLblGrammage() {
		if (lblGrammage == null) {
			lblGrammage = new JLabel("Grammage :");
		}
		return lblGrammage;
	}

	private JLabel getLblCouleur() {
		if (lblCouleur == null) {
			lblCouleur = new JLabel("Couleur :");
		}
		return lblCouleur;
	}

	private JComboBox<String> getCmbCouleur() {
		if (cmbCouleur == null) {
			// TODO : respecter les couleurs
			String[] couleurs = { "rouge", "bleu", "vert", "noir", "jaune" };
			cmbCouleur = new JComboBox<String>(couleurs);
		}
		return cmbCouleur;
	}

	private JPanel getPanelBoutons() {
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
	
	private void suivant() {
		try {
			Article articleSuivant = CatalogueController.getInstance().getArticleSuivant();
			afficherArticle(articleSuivant);
		} catch (ArticleNotFoundException ae) {
			ae.printStackTrace();
			JOptionPane.showMessageDialog(EcranPapeterie.this, "Vous avez atteint la fin de la liste");
		} catch (BLLException be) {
			be.printStackTrace();
		}
	}
	
	private void precedent() {
		try {
			Article articlePrecedent = CatalogueController.getInstance().getArticlePrecedent();
			afficherArticle(articlePrecedent);
		} catch (ArticleNotFoundException ae) {
			ae.printStackTrace();
			JOptionPane.showMessageDialog(EcranPapeterie.this, "Vous avez atteint le début de la liste");
		} catch (BLLException be) {
			be.printStackTrace();
		}
	}
	
	private void nouveau() {
		articleEnTrainDEtreAffiche = null;
		
		getTxtReference().setText("");
		getTxtDesignation().setText("");
		getTxtMarque().setText("");
		getTxtPrix().setText("");
		getTxtStock().setText("");
		
		initCheckAndRadio(true);
	}
	
	private void enregistrer() {
		//1. on récupère les valeurs du formulaire
		String reference = getTxtReference().getText();
		String designation = getTxtDesignation().getText();
		String marque = getTxtMarque().getText();
		
		int qteStock = 0;
		try {
			qteStock = Integer.parseInt(getTxtStock().getText());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		float prixUnitaire = 0;
		try {
			prixUnitaire = Float.parseFloat(getTxtPrix().getText());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		//TODO : code à factoriser, on peut faire bcp mieux
		
		//Si c'est une ramette
		if(getRadioRamette().isSelected()) { //on a sélectionné le radio bouton ramette
			
			//ternaire (variable = condition ? valeur true: valeur false;
			int grammage = getChk80().isSelected() ? 80 : 100;
			//version if...else...
//			if(getChk80().isSelected() == true) {
//				grammage = 80;
//			} else {
//				grammage = 100;
//			}
			
			//2. il s'agit d'un nouvel article
			if(articleEnTrainDEtreAffiche == null) { //on va ajouter un nouvel article (il y n'avait pas d'article en cours d'affichage)
				Article nouvelArticle = new Ramette(reference, marque, designation, prixUnitaire, qteStock, grammage);
				try {
					CatalogueController.getInstance().insererNouvelArticle(nouvelArticle);
					Article a = CatalogueController.getInstance().getDernierArticle();
					afficherArticle(a);				
				} catch (BLLException e) {
					e.printStackTrace();
				}
			} else { //on va mettre à jour
				articleEnTrainDEtreAffiche.setDesignation(designation);
				articleEnTrainDEtreAffiche.setMarque(marque);
				articleEnTrainDEtreAffiche.setPrixUnitaire(prixUnitaire);
				articleEnTrainDEtreAffiche.setQteStock(qteStock);
				articleEnTrainDEtreAffiche.setReference(reference);
				((Ramette)articleEnTrainDEtreAffiche).setGrammage(grammage);
				try {
					CatalogueController.getInstance().updateArticle(articleEnTrainDEtreAffiche);
				} catch (BLLException e) {
					e.printStackTrace();
				}
			}
	
		} else { //sinon, stylo
			String couleur = (String) getCmbCouleur().getSelectedItem();
			
			if(articleEnTrainDEtreAffiche == null) { //on va ajouter un nouvel article (il y n'avait pas d'article en cours d'affichage)
				Article nouvelArticle = new Stylo(reference, marque, designation, prixUnitaire, qteStock, couleur);
				try {
					CatalogueController.getInstance().insererNouvelArticle(nouvelArticle);
					Article a = CatalogueController.getInstance().getDernierArticle();
					afficherArticle(a);				
				} catch (BLLException e) {
					e.printStackTrace();
				}
			} else { //on va mettre à jour
				articleEnTrainDEtreAffiche.setDesignation(designation);
				articleEnTrainDEtreAffiche.setMarque(marque);
				articleEnTrainDEtreAffiche.setPrixUnitaire(prixUnitaire);
				articleEnTrainDEtreAffiche.setQteStock(qteStock);
				articleEnTrainDEtreAffiche.setReference(reference);
				((Stylo)articleEnTrainDEtreAffiche).setCouleur(couleur);
				try {
					CatalogueController.getInstance().updateArticle(articleEnTrainDEtreAffiche);
				} catch (BLLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private void supprimer() {
		if(articleEnTrainDEtreAffiche != null) {
			try {
				//1. on supprime dans la BDD (Controller -> BLL -> DAL -> BDD)
				CatalogueController.getInstance().supprimerArticle(articleEnTrainDEtreAffiche.getIdArticle());
				
				//2. on essaye d'afficher l'article suivant dans la liste
				try {
					Article articleAAfficher = CatalogueController.getInstance().getArticleCourant();
					afficherArticle(articleAAfficher);
				} catch (ArticleNotFoundException e) {
					//3.Si pas de suivant, on affiche l'article précédent
					e.printStackTrace();
					try {
						Article articleAAfficher = CatalogueController.getInstance().getArticlePrecedent();
						afficherArticle(articleAAfficher);
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
