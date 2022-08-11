package fr.eni.blagues.ihm.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;

import fr.eni.blagues.bll.BLLException;
import fr.eni.blagues.bo.Blague;
import fr.eni.blagues.ihm.controller.BlagueController;

public class EcranNoteBlague extends JFrame{
	private BlagueController blagueController = BlagueController.getInstance();
	
	private JPanel panelGeneral;
	private JPanel panelBas;
	private JTextArea textArea;
	private JSlider panelSlider;
	private JLabel lblNote;
	private JButton buttonOk;
	
	
	public EcranNoteBlague() {
		setTitle("Palais de la boutade");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(500, 450));
		setLocation(400, 100);
		
		add(getPanelGeneral(), BorderLayout.CENTER);

		
		//ligne 1 text Area
		addComponentToPanel(0, 0, 200, getTextArea(), panelGeneral );
			
		//ligne 2
		add(getPanelBas(),BorderLayout.SOUTH);
		
		addComponentToPanel(1, 1, getLblNote(), panelBas);
		addComponentToPanel(1, 2, getPanelSlider(), panelBas);
		addComponentToPanel(1, 3, getButtonOk(), panelBas);
		
		//METHODS
		AfficherBlague();
		

	}

	
	//Methods
	private Blague getBlagueTopUn() {
		Blague blague = null;
	
		try {
			return blagueController.getBlagueTopUn();
		} catch (BLLException e) {
			e.printStackTrace();
		}
		return blague;
	}
	
	private void AfficherBlague() {
		Blague blague = null;
		try {
			blague = blagueController.getBlagueTopUn();
		} catch (BLLException e) {
			e.printStackTrace();
		}		
		textArea.setText(blague.getTxtBlague());
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
	public JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea(20, 40);
		}
		return textArea;
	}
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	public JSlider getPanelSlider() {
		if (panelSlider == null) {
			panelSlider = new JSlider(0, 5);
		}
		return panelSlider;
	}
	public void setPanelSlider(JSlider panelSlider) {
		this.panelSlider = panelSlider;
	}
	public JLabel getLblNote() {
		if (lblNote == null) {
			lblNote = new JLabel("Note");
		}
		return lblNote;
	}
	public void setLblNote(JLabel lblNote) {
		this.lblNote = lblNote;
	}
	public JButton getButtonOk() {
		if (buttonOk == null) {	
			buttonOk = new JButton("Ok");
		}
		return buttonOk;
	}
	public void setButtonOk(JButton buttonOk) {
		this.buttonOk = buttonOk;
	}
	public JPanel getPanelBas() {
		if (panelBas == null) {
			panelBas = new JPanel(new GridBagLayout());
		}
		return panelBas;
	}

	public void setPanelBas(JPanel panelBas) {
		this.panelBas = panelBas;
	}
	
	
}
