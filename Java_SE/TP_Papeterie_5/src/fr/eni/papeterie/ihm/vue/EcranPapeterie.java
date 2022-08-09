package fr.eni.papeterie.ihm.vue;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bll.CatalogueManager;
import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.ihm.controller.IhmController;

public class EcranPapeterie extends JFrame {

	private JPanel panel;
	private JLabel lblReference;
	private JLabel lblDesignation;
	private JLabel lblMarque;
	private JLabel lblQteStock;
	private JLabel lblPrix;
	private JTextField txtReference;
	private JTextField txtDesignation;
	private JTextField txtMarque;
	private JTextField txtQteStock;
	private JTextField txtPrix;
	
	private JLabel txtType;
	private ButtonGroup radioGroup;
	private JRadioButton radioRamette;
	private JRadioButton radioStylo;
	
	private JLabel	lblGrammage; 			
	private ButtonGroup chkGroup;
	private JCheckBox chkGrammage80;
	private JCheckBox chkGrammage100;
	
	private JLabel	lblCouleur;
	private JComboBox<Object> colorCombo;
	
	private JPanel panelBoutons;
	private JButton btnPrevious;
	private JButton btnNouvelArticle;
	private JButton btnSave;
	private JButton btnDelete;
	private JButton btnNext;
	
	public EcranPapeterie() {
		setSize(500, 600);
		setLocation(100, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //arr�te l'application lors de la fermeture de la fen�tre
		setVisible(true); // ! � ne pas oublier !
		
		setContentPane(getPanel()); //remplace le panel d'origine par le panel que l'on cr�e
	}
	//create panel 
	private JPanel getPanel() {
		if(panel == null) {
			panel = new JPanel(new GridBagLayout());	
			//Ligne 0
			placeComponentInPanel(getLblReference(), panel, 0, 0);
			placeComponentInPanel(getTxtReference(), panel, 0, 1);
			
			//ligne 1
			placeComponentInPanel(getLblDesignation(), panel, 1, 0);
			placeComponentInPanel(getTxtDesignation(), panel, 1, 1);
						
			//ligne 2
			placeComponentInPanel(getLblMarque(), panel, 2, 0);
			placeComponentInPanel(getTxtMarque(), panel, 2, 1);
			
			//ligne 3
			placeComponentInPanel(GetLblQteStock(), panel, 3, 0);
			placeComponentInPanel(getTxtQteStock(), panel, 3, 1);
			
			//ligne 4
			placeComponentInPanel(getLblPrix(), panel, 4, 0);
			placeComponentInPanel(getTxtPrix(), panel, 4, 1);
			
			//ligne 5 - 6 Type
			placeComponentInPanelGridHeight(getLblType(), panel, 5, 0, 2);
			getRadioGroup();
			placeComponentInPanel(getRadioStylo(), panel, 5, 1);
			placeComponentInPanel(getRadioRamette(), panel, 6, 1);
			getRadioStylo().setSelected(true);
			getRadioStylo().setEnabled(false);
			getRadioRamette().setEnabled(false);
			//ligne 7 - 8 Grammage
			placeComponentInPanelGridHeight(getLblGrammage(), panel, 7, 0, 2);
			getChkGroup();	
			placeComponentInPanel(getChk80(), panel, 7, 1);
			placeComponentInPanel(getChk100(), panel, 8, 1);
			getChk80().setEnabled(false);
			getChk100().setEnabled(false);
			//condition affichage
					
			//ligne 9 Couleur
			placeComponentInPanel(getLblColor(), panel, 9, 0);
			placeComponentInPanel(getColorCombo(), panel, 9, 1);
			getColorCombo().setEnabled(false);
			//Conditions affichage	
			//ligne 10 boutons
			placeComponentInPanel(getPanelBoutons(), panel, 10, 0, 2);
			
			//print first article
			initFirstArticle();
			
		}
		return panel;
	}
	
	//Methods place components
	private void placeComponentInPanel(Component cmp, JPanel panel, 
										int ligne, int colonne) {
		placeComponentInPanel(cmp, panel, ligne, colonne, 1);
	}
	private void placeComponentInPanel(Component cmp, JPanel panel, 
			int ligne, int colonne, int gridWidth) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy = ligne;
		gbc.gridx = colonne;
		gbc.gridwidth = gridWidth;
		gbc.insets = new Insets(5, 5, 5, 5);
		panel.add(cmp, gbc);
	}
	private void placeComponentInPanelGridHeight(Component cmp, JPanel panel, 
			int ligne, int colonne, int gridHeight) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy = ligne;
		gbc.gridx = colonne;
		gbc.gridheight = gridHeight;
		gbc.insets = new Insets(5, 5, 5, 5);
		panel.add(cmp, gbc);
	}
	
	//Getters / setters
	public JLabel getLblReference() {
		if(lblReference == null) {
			lblReference = new JLabel("Reference");
		}
		return lblReference;
	}
	public JLabel getLblDesignation() {
		if(lblDesignation == null) {
			lblDesignation = new JLabel("Designation");
		}
		return lblDesignation;
	}
	public JLabel getLblMarque() {
		if(lblMarque == null) {
			lblMarque = new JLabel("Marque");
		}
		return lblMarque;
	}
	public JLabel GetLblQteStock() {
		if(lblQteStock == null) {
			lblQteStock = new JLabel("Stock");
		}
		return lblQteStock;
	}
	public JLabel getLblPrix() {
		if(lblPrix == null) {
			lblPrix = new JLabel("Prix");
		}
		return lblPrix;
	}
	public JTextField getTxtReference() {
		if(txtReference == null) {
			txtReference = new JTextField(30);
		}
		return txtReference;
	}
	public JTextField getTxtDesignation() {
		if(txtDesignation == null) {
			txtDesignation = new JTextField(30);
		}
		return txtDesignation;
	}
	public JTextField getTxtMarque() {
		if(txtMarque == null) {
			txtMarque = new JTextField(30);
		}
		return txtMarque;
	}
	public JTextField getTxtQteStock() {
		if(txtQteStock == null) {
			txtQteStock = new JTextField(30);
		}
		return txtQteStock;
	}
	public JTextField getTxtPrix() {
		if(txtPrix == null) {
			txtPrix = new JTextField(30);
		}
		return txtPrix;
	}
	//--Section TYPE--------------
	public JLabel getLblType() {
		if(txtType == null) {
			txtType = new JLabel("Type");
		}
		return txtType;
	}
	public ButtonGroup getRadioGroup() {
		if(radioGroup == null) {
			radioGroup = new ButtonGroup();
		}
		return radioGroup;
	}
	public JRadioButton getRadioStylo() {
		if(radioStylo == null) {
			radioStylo = new JRadioButton("Stylo");
			radioGroup.add(radioStylo);	
		}
		radioStylo.addActionListener(e -> {
			enableFields();
		});	
		return radioStylo;
	}
	public JRadioButton getRadioRamette() {
		if(radioRamette == null) {
			radioRamette = new JRadioButton("Ramette");
			radioGroup.add(radioRamette);
		}
		radioRamette.addActionListener(e -> {
			enableFields();
		});	
		return radioRamette;
	}	
	//grammage
	//---Section Grammage-------
	public JLabel getLblGrammage() {
		if(lblGrammage == null) {
			lblGrammage = new JLabel("Grammage");
		}
		return lblGrammage;
	}
	public ButtonGroup getChkGroup() {
		if(chkGroup == null) {
			chkGroup = new ButtonGroup();	
		}
		return chkGroup;
	}
	public JCheckBox getChk80() {
		if(chkGrammage80 == null) {
			chkGrammage80 = new JCheckBox("80 grammes");
			chkGroup.add(chkGrammage80);
		}
		return chkGrammage80;
	}
	public JCheckBox getChk100() {
		if(chkGrammage100 == null) {
			chkGrammage100 = new JCheckBox("100 grammes");
			chkGroup.add(chkGrammage100);
		}
		return chkGrammage100;
	}	
	//----Section couleur
	public JLabel getLblColor() {
		if(lblCouleur == null) {
			lblCouleur = new JLabel("Couleur");
		}
		return lblCouleur;
	}	
	@SuppressWarnings({ "unused", "rawtypes" })
	public JComboBox getColorCombo() {
		if(colorCombo == null) {
			String colors[] = {"Bleu", "Noir", "Vert", "Rouge"};
			colorCombo = new JComboBox<Object>(colors);
		}
		return colorCombo;
	}	
	//----Section boutons
	public JPanel getPanelBoutons() {
		if(panelBoutons == null) {
			panelBoutons = new JPanel(new GridBagLayout());	
		}
		placeComponentInPanel(getBtnPrevious(), panelBoutons, 0, 0);
		placeComponentInPanel(getBtnNouvelArticle(), panelBoutons, 0, 1);
		placeComponentInPanel(getBtnSave(), panelBoutons, 0, 2);
		placeComponentInPanel(getBtnDelete(), panelBoutons, 0, 3);
		placeComponentInPanel(getBtnNext(), panelBoutons, 0, 4);
		
		return panelBoutons;
	}	
	//---Boutons
	public JButton getBtnPrevious() {
		if(btnPrevious == null) {
			btnPrevious = new JButton(new ImageIcon("img/Back24.gif"));
			btnPrevious.setPreferredSize(new Dimension(80,70));
		}
		btnPrevious.addActionListener(e -> {
			
			try {
				previousArticle();
				printArticle();
			} catch (BLLException e1) {
				e1.printStackTrace();
			}
		});	
		return btnPrevious;
	}	

	public JButton getBtnNouvelArticle() {
		if(btnNouvelArticle == null) {
			btnNouvelArticle = new JButton(new ImageIcon("img/New24.gif"));
			btnNouvelArticle.setPreferredSize(new Dimension(80,70));
			btnNouvelArticle.addActionListener(e -> {
				System.out.println("New");
			});
		}
		btnNouvelArticle.addActionListener(e -> {
			addArticle();
		});	
		return btnNouvelArticle;
	}
	public JButton getBtnSave() {
		if(btnSave == null) {
			btnSave = new JButton(new ImageIcon("img/Save24.gif"));
			btnSave.setPreferredSize(new Dimension(80,70));
			btnSave.addActionListener(e -> {
				System.out.println("Save");
			});
		}
		btnSave.addActionListener(e -> {
			try {
				saveArticle();
			} catch (BLLException e1) {
				e1.printStackTrace();
			}
		});	
		return btnSave;
	}
	public JButton getBtnDelete() {
		if(btnDelete == null) {
			btnDelete = new JButton(new ImageIcon("img/Delete24.gif"));
			btnDelete.setPreferredSize(new Dimension(80,70));
		}
		btnDelete.addActionListener(e -> {
			try {
				deleteArticle();
			} catch (BLLException e1) {
				e1.printStackTrace();
			}
		});	
		return btnDelete;
	}
	public JButton getBtnNext() {
		if(btnNext == null) {
			btnNext = new JButton(new ImageIcon("img/Forward24.gif"));
			btnNext.setPreferredSize(new Dimension(80,70));
		}
		btnNext.addActionListener(e -> {
			try {
				nextArticle();
				printArticle();
			} catch (BLLException e1) {
				e1.printStackTrace();
			}
		});	
		return btnNext;
	}
	
	
	//---METHODS
	public void printArticle() throws BLLException {
		if(IhmController.getList().size()== 0) {
			resetFields();
		}else {
			if(IhmController.getCurrentArticle() instanceof Stylo) {
				getRadioStylo().setSelected(true);
			}else getRadioRamette().setSelected(true);
			
			getTxtDesignation().setText(IhmController.getCurrentArticle().getDesignation());
			getTxtReference().setText(IhmController.getCurrentArticle().getReference());
			getTxtMarque().setText(IhmController.getCurrentArticle().getMarque());
			getTxtQteStock().setText(String.valueOf(IhmController.getCurrentArticle().getQteStock()));
			getTxtPrix().setText(String.valueOf(IhmController.getCurrentArticle().getPrixUnitaire()));
		}
	}
	public void nextArticle() throws BLLException {
		//disabled fields
		disableFields();
		//set next article
		if(IhmController.getList().size() == 0) {
			resetFields();
		}else {
			if(IhmController.getIndexList() == IhmController.getList().size() - 1) {	
				IhmController.setCurrentArticle( IhmController.getList().get(0));
				IhmController.setIndexList(0);
			}else {
				IhmController.setIndexList(IhmController.getIndexList() + 1 );
				IhmController.setCurrentArticle(IhmController.getList().get(IhmController.getIndexList()));
			}	
		}	
	}
	public void previousArticle() throws BLLException {
		//disabled fields
			disableFields();
			//set next article
			if(IhmController.getList().size() == 0) {
				resetFields();
			}else {
				if(IhmController.getIndexList() == 0) {	
					IhmController.setCurrentArticle( IhmController.getList().get(IhmController.getList().size() - 1));
					IhmController.setIndexList(IhmController.getList().size() - 1);
				}else {
					IhmController.setIndexList(IhmController.getIndexList() - 1 );
					IhmController.setCurrentArticle(IhmController.getList().get(IhmController.getIndexList()));
				}	
			}	
	}	
	public void deleteArticle() throws BLLException {
		if(IhmController.getList().size() == 0) {
			resetFields();
		}else {
			IhmController.getCatalogue().removeArticle(IhmController.getCurrentArticle());
			IhmController.setIndexList(IhmController.getIndexList() - 1);
			IhmController.setList( IhmController.getCatalogue().getCatalogue());
			
			if(IhmController.getIndexList() == 0) {
				nextArticle();
				printArticle();
			} else if(IhmController.getIndexList() == IhmController.getList().size()-1) {
				nextArticle();
				printArticle();
			}else {
				nextArticle();
				printArticle();
			}
		}
	}
	public void addArticle() {
		resetFields();
		getRadioStylo().setEnabled(true);
		getRadioStylo().setSelected(true);
		getRadioRamette().setEnabled(true);
		getColorCombo().setEnabled(true);
	}
	public void saveArticle() throws BLLException {
		List<Article> list = IhmController.getList();
		CatalogueManager catalogue = IhmController.getCatalogue();
		int indexList = IhmController.getIndexList();
		Article currentArticle = IhmController.getCurrentArticle();
		//Recupere donnees champs de texte
		Article articleAdd = null;
		String reference = getTxtReference().getText();
		String designation = getTxtDesignation().getText();
		String marque = getTxtMarque().getText();
		int qteStock = Integer.valueOf(getTxtQteStock().getText());
		float prix = Float.valueOf(getTxtPrix().getText());
		if(getRadioStylo().isSelected()) {
			String color = (String) getColorCombo().getSelectedItem();
			articleAdd = new Stylo(reference, designation, marque, prix, qteStock, color);
		}else {
			int grammage;
			if(getChk80().isSelected()) {
				grammage = 80;
			}else grammage = 100;
			articleAdd = new Ramette(reference, designation, marque, prix, qteStock, grammage);
		}
		catalogue.addArticle(articleAdd);
		list = catalogue.getCatalogue();
		
	}
	
	public void initFirstArticle() {
		if(IhmController.getList().size() == 0) {
			resetFields();
		}else {
			try {
				IhmController.setCurrentArticle(IhmController.getList().get(0));
				printArticle();
			} catch (BLLException e2) {
				e2.printStackTrace();
			}
		}
	}
	public void enableFields() {
		if(getRadioStylo().isSelected()) {
			getChk80().setEnabled(false);
			getChk100().setEnabled(false);
			getColorCombo().setEnabled(true);
		}else {
			getChk80().setEnabled(true);
			getChk80().setSelected(true);;
			getChk100().setEnabled(true);
			getColorCombo().setEnabled(false);		
		}
	}
	public void resetFields() {
		getTxtDesignation().setText("");
		getTxtReference().setText("");
		getTxtMarque().setText("");
		getTxtQteStock().setText("");
		getTxtPrix().setText("");
	}	
	public void disableFields() {
		getRadioRamette().setEnabled(false);
		getRadioStylo().setEnabled(false);
		getChk80().setEnabled(false);
		getChk100().setEnabled(false);
		getColorCombo().setEnabled(false);
	}
	
}
