package fr.eni.blagues.ihm.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EcranAddBlague extends JFrame{
	
	
	private JPanel panelGeneral;
	private JLabel lblLibelle;
	private JTextField textField;	
	private JButton buttonAdd;
	
	public EcranAddBlague() {
		setTitle("Antichambre du rire");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(500, 450));
		setLocation(600, 200);
		
		add(getPanelGeneral());
		
		// Ligne 1
		addComponentToPanel(0, 0, getLblLibelle(), panelGeneral );
		addComponentToPanel(1, 0, getTextField(), panelGeneral );
		// Ligne 2
		addComponentToPanel(2, 0, getButtonAdd(), panelGeneral );	
	}

	//Methods Placement Item
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
	//Getters Setters
	public JPanel getPanelGeneral() {
		if (panelGeneral == null) {
			panelGeneral = new JPanel(new GridBagLayout());
		}
		return panelGeneral;
	}
	public void setPanelGeneral(JPanel panelGeneral) {
		this.panelGeneral = panelGeneral;
	}
	public JLabel getLblLibelle() {
		if (lblLibelle == null) {
			lblLibelle = new JLabel("Libelle");
		}
		return lblLibelle;
	}
	public void setLblLibelle(JLabel lblLibelle) {
		this.lblLibelle = lblLibelle;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField(100);
		}
		return textField;
	}
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	public JButton getButtonAdd() {
		if (buttonAdd == null) {	
			buttonAdd = new JButton("  +  ");
		}
		return buttonAdd;
	}
	public void setButtonAdd(JButton buttonAdd) {
		this.buttonAdd = buttonAdd;
	}
}
