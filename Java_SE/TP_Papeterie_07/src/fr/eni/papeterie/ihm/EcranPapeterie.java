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
	public void setArticleEnTrainDEtreAffiche(Article articleEnTrainDEtreAffiche) {
		this.articleEnTrainDEtreAffiche = articleEnTrainDEtreAffiche;
	}

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

	private Article articleEnTrainDEtreAffiche = null;
	
	//SINGLETON
		private static EcranPapeterie instance;
		
		private EcranPapeterie() { 
			setTitle("TP papeterie");
			setVisible(true);
			setIconImage(new ImageIcon(getClass().getResource("images/aim.png")).getImage());
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(new Dimension(500, 450));
			setLocation(400, 100);

			add(getPanelFormulaire(), BorderLayout.CENTER);
			PanelBouton panelBouton = PanelBouton.getInstance();
			add(panelBouton.getPanelBoutons(), BorderLayout.SOUTH);

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
		
		public static EcranPapeterie getInstance() {
			if(instance == null) {
				instance = new EcranPapeterie();
			}
			return instance;
		}
		//FIN SINGLETON

	public void afficherArticle(Article articleAAfficher) {
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

	public JPanel getPanelFormulaire() {
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

	public void addComponentToPanel(int ligne, int col, int height, JComponent component, JPanel panel) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = col;
		gbc.gridy = ligne;
		gbc.gridheight = height;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel.add(component, gbc);
	}

	public void addComponentToPanel(int ligne, int col, JComponent component, JPanel panel) {
		addComponentToPanel(ligne, col, 1, component, panel);
	}

	public JLabel getLblReference() {
		if (lblReference == null) {
			lblReference = new JLabel("Référence :");
		}
		return lblReference;
	}

	public JTextField getTxtReference() {
		if (txtReference == null) {
			txtReference = new JTextField(30);
		}
		return txtReference;
	}

	public JLabel getLblDesignation() {
		if (lblDesignation == null) {
			lblDesignation = new JLabel("Désignation :");
		}
		return lblDesignation;
	}

	public JTextField getTxtDesignation() {
		if (txtDesignation == null) {
			txtDesignation = new JTextField(30);
		}
		return txtDesignation;
	}

	public JLabel getLblMarque() {
		if (lblMarque == null) {
			lblMarque = new JLabel("Marque :");
		}
		return lblMarque;
	}

	public JTextField getTxtMarque() {
		if (txtMarque == null) {
			txtMarque = new JTextField(30);
		}
		return txtMarque;
	}

	public JLabel getLblStock() {
		if (lblStock == null) {
			lblStock = new JLabel("Stock :");
		}
		return lblStock;
	}

	public JTextField getTxtStock() {
		if (txtStock == null) {
			txtStock = new JTextField(30);
		}
		return txtStock;
	}

	public JLabel getLblPrix() {
		if (lblPrix == null) {
			lblPrix = new JLabel("Prix :");
		}
		return lblPrix;
	}

	public JTextField getTxtPrix() {
		if (txtPrix == null) {
			txtPrix = new JTextField(30);
		}
		return txtPrix;
	}

	public JRadioButton getRadioRamette() {
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

	public JRadioButton getRadioStylo() {
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

	public JLabel getLblType() {
		if (lblType == null) {
			lblType = new JLabel("Type :");
		}
		return lblType;
	}

	public JCheckBox getChk80() {
		if (chk80 == null) {
			chk80 = new JCheckBox("80 grammes", true);
		}
		return chk80;
	}

	public JCheckBox getChk100() {
		if (chk100 == null) {
			chk100 = new JCheckBox("100 grammes");
		}
		return chk100;
	}

	public JLabel getLblGrammage() {
		if (lblGrammage == null) {
			lblGrammage = new JLabel("Grammage :");
		}
		return lblGrammage;
	}

	public JLabel getLblCouleur() {
		if (lblCouleur == null) {
			lblCouleur = new JLabel("Couleur :");
		}
		return lblCouleur;
	}

	public JComboBox<String> getCmbCouleur() {
		if (cmbCouleur == null) {
			// TODO : respecter les couleurs
			String[] couleurs = { "rouge", "bleu", "vert", "noir", "jaune" };
			cmbCouleur = new JComboBox<String>(couleurs);
		}
		return cmbCouleur;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ButtonGroup getGroupType() {
		return groupType;
	}

	public ButtonGroup getGroupGrammage() {
		return groupGrammage;
	}

	public Article getArticleEnTrainDEtreAffiche() {
		return articleEnTrainDEtreAffiche;
	}
	
}
