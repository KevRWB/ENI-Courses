package fr.eni.demo.swing;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EcranStagiaire extends JFrame {

	private JPanel panel;
	private JLabel lblNoStagiaire;
	private JLabel lblNomStagiaire;
	private JLabel lblPrenomStagiaire;
	private JTextField txtNoStagiaire;
	private JTextField txtNomStagiaire;
	private JTextField txtPrenomStagiaire;
	private JButton btnOk;
	
	public EcranStagiaire() {
		super();
		setSize(500, 250);
		setLocation(100, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //arr�te l'application lors de la fermeture de la fen�tre
		setVisible(true); // ! � ne pas oublier !
		
		setContentPane(getPanel()); //remplace le panel d'origine par le panel que l'on cr�e
	}

	private JPanel getPanel() {
		if(panel == null) {
			panel = new JPanel(new GridBagLayout());
			
			//Ligne 0
			placeComponentInPanel(getLblNoStagiaire(), panel, 0, 0);
			placeComponentInPanel(getTxtNoStagiaire(), panel, 0, 1);
			
			//ligne 1
			placeComponentInPanel(getLblNomStagiaire(), panel, 1, 0);
			placeComponentInPanel(getTxtNomStagiaire(), panel, 1, 1);
			
			
			//ligne 2
			placeComponentInPanel(getLblPrenomStagiaire(), panel, 2, 0);
			placeComponentInPanel(getTxtPrenomStagiaire(), panel, 2, 1);
			
			//Ligne 3
			placeComponentInPanel(getBtnOk(), panel, 3, 0, 2);
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
	

	private JLabel getLblNoStagiaire() {
		if(lblNoStagiaire == null) {
			lblNoStagiaire = new JLabel("No Stagiaire :");
		}
		return lblNoStagiaire;
	}

	private JLabel getLblNomStagiaire() {
		if(lblNomStagiaire == null) {
			lblNomStagiaire = new JLabel("Nom :");
		}
		return lblNomStagiaire;
	}

	private JLabel getLblPrenomStagiaire() {
		if(lblPrenomStagiaire == null) {
			lblPrenomStagiaire = new JLabel("Pr�nom :");
		}
		return lblPrenomStagiaire;
	}

	private JTextField getTxtNoStagiaire() {
		if(txtNoStagiaire == null) {
			txtNoStagiaire = new JTextField(30);
		}
		return txtNoStagiaire;
	}

	private JTextField getTxtNomStagiaire() {
		if(txtNomStagiaire == null) {
			txtNomStagiaire = new JTextField(30);
		}
		return txtNomStagiaire;
	}

	private JTextField getTxtPrenomStagiaire() {
		if(txtPrenomStagiaire == null) {
			txtPrenomStagiaire = new JTextField(30);
		}
		return txtPrenomStagiaire;
	}

	private JButton getBtnOk() {
		if(btnOk == null) {
			btnOk = new JButton("OK");
			//1. ajout d'un listener (classe externe)
			//btnOk.addActionListener(new BoutonOkListenerExterne());
			
			//2. ajout d'un listener (classe interne)
//			btnOk.addActionListener(new BoutonOkListenerInterne());
			
			//3. ajout d'un listener (classe anonyme)
			btnOk.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Clic ok classe anonyme");
				}
			});
			
			//4. ajout d'un listener (lambda : à partir de Java 8)
			btnOk.addActionListener(e -> {
				System.out.println("Clic ok lambda");
			});
			
		}
		return btnOk;
	}
	
	private class BoutonOkListenerInterne implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Clic ok classe interne");			
		}
		
	}
	
	
}
