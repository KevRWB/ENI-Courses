package fr.eni.papeterie.ihm.vue;

import java.awt.Button;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

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
	
	private JLabel	txtGrammage; 			
	private ButtonGroup chkGroup;
	private JCheckBox chkGrammage80;
	private JCheckBox chkGrammage100;
	
	private JLabel	txtCouleur;
	private JComboBox colorCombo;
	
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
			placeComponentInPanel(getLblType(), panel, 5, 0);
			getRadioGroup();
			placeComponentInPanel(getRadioStylo(), panel, 5, 1);
			placeComponentInPanel(getRadioRamette(), panel, 6, 1);
			
			//ligne 7 Grammage
			placeComponentInPanel(getLblGrammage(), panel, 7, 0);
			
						
//			//Ligne 5
//			placeComponentInPanel(getBtnOk(), panel, 3, 0, 2);
		}
		return panel;
	}
	
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
	

	private JLabel getLblReference() {
		if(lblReference == null) {
			lblReference = new JLabel("Reference");
		}
		return lblReference;
	}
	private JLabel getLblDesignation() {
		if(lblDesignation == null) {
			lblDesignation = new JLabel("Designation");
		}
		return lblDesignation;
	}
	private JLabel getLblMarque() {
		if(lblMarque == null) {
			lblMarque = new JLabel("Marque");
		}
		return lblMarque;
	}
	private JLabel GetLblQteStock() {
		if(lblQteStock == null) {
			lblQteStock = new JLabel("Stock");
		}
		return lblQteStock;
	}
	private JLabel getLblPrix() {
		if(lblPrix == null) {
			lblPrix = new JLabel("Prix");
		}
		return lblPrix;
	}
	private JTextField getTxtReference() {
		if(txtReference == null) {
			txtReference = new JTextField(30);
		}
		return txtReference;
	}
	private JTextField getTxtDesignation() {
		if(txtDesignation == null) {
			txtDesignation = new JTextField(30);
		}
		return txtDesignation;
	}
	private JTextField getTxtMarque() {
		if(txtMarque == null) {
			txtMarque = new JTextField(30);
		}
		return txtMarque;
	}
	private JTextField getTxtQteStock() {
		if(txtQteStock == null) {
			txtQteStock = new JTextField(30);
		}
		return txtQteStock;
	}
	private JTextField getTxtPrix() {
		if(txtPrix == null) {
			txtPrix = new JTextField(30);
		}
		return txtPrix;
	}
	//--Section TYPE--------------
	private JLabel getLblType() {
		if(txtType == null) {
			txtType = new JLabel("Type");
		}
		return txtType;
	}
	private ButtonGroup getRadioGroup() {
		if(radioGroup == null) {
			radioGroup = new ButtonGroup();
		}
		return radioGroup;
	}
	private JRadioButton getRadioStylo() {
		if(radioStylo == null) {
			radioStylo = new JRadioButton("Stylo");
			radioGroup.add(radioStylo);		
		}
		return radioStylo;
	}
	private JRadioButton getRadioRamette() {
		if(radioRamette == null) {
			radioRamette = new JRadioButton("Ramette");
			radioGroup.add(radioRamette);
		}
		return radioRamette;
	}
	
	//---Section Grammage-------
	private JLabel getLblGrammage() {
		if(txtGrammage == null) {
			txtGrammage = new JLabel("Grammage");
		}
		return txtGrammage;
	}
	private ButtonGroup getChk80() {
		if(chkGrammage80 == null) {
			chkGrammage80 = new JCheckBox("80 grammes");
		}
		return chkGrammage80;
	}
	private JRadioButton getChk100() {
		if(chkGrammage100 == null) {
			chkGrammage100 = new JCheckBox("100 grammes");
			chkGrammage100.add(chkGrammage100);		
		}
		return radioStylo;
	}

	
	//----Section couleur
	private JLabel getLblColor() {
		if(txtCouleur == null) {
			txtCouleur = new JLabel("Couleur");
		}
		return txtCouleur;
	}

	
	
	//---Section Boutons
//	private JButton getBtnOk() {
//		if(btnOk == null) {
//			btnOk = new JButton("OK");
//			//1. ajout d'un listener (classe externe)
//			//btnOk.addActionListener(new BoutonOkListenerExterne());
//			
//			//2. ajout d'un listener (classe interne)
//			//btnOk.addActionListener(new BoutonOkListenerInterne());
//			
//			//3. ajout d'un listener (classe anonyme)
//			btnOk.addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					System.out.println("Clic ok classe anonyme");
//				}
//			});
//			
//			//4. ajout d'un listener (lambda : à partir de Java 8)
//			btnOk.addActionListener(e -> {
//				System.out.println("Clic ok lambda");
//			});
//			
//		}
//		return btnOk;
//	}
	
	private class BoutonOkListenerInterne implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Clic ok classe interne");			
		}
		
	}
	
	
}
