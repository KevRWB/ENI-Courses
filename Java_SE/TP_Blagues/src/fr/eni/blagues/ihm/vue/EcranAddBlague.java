package fr.eni.blagues.ihm.vue;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.eni.blagues.bll.BLLException;
import fr.eni.blagues.bo.Blague;
import fr.eni.blagues.ihm.controller.BlagueController;

public class EcranAddBlague extends JFrame{
	private BlagueController blagueController = BlagueController.getInstance();
	
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

	//METHODS
	private void addBlague() {
		String txtBlague = textField.getText();
		Blague blague = new Blague(txtBlague, 0, 0);
		try {
			blagueController.insert(blague);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			buttonAdd.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					addBlague();
					textField.setText("Blague envoyée");
				}
			});
		}
		return buttonAdd;
	}
	public void setButtonAdd(JButton buttonAdd) {
		this.buttonAdd = buttonAdd;
	}
}
