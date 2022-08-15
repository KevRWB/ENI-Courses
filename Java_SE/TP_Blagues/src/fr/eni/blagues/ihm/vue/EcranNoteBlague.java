package fr.eni.blagues.ihm.vue;

import java.awt.BorderLayout;
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
import javax.swing.JSlider;
import javax.swing.JTextArea;

import fr.eni.blagues.bll.BLLException;
import fr.eni.blagues.bo.Blague;
import fr.eni.blagues.ihm.controller.BlagueController;
import fr.eni.blagues.ihm.controller.BlagueController.BlagueControllerListener;

public class EcranNoteBlague extends JFrame implements BlagueControllerListener{

	private static final long serialVersionUID = 1L;

public class EcranNoteBlague extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 

	private BlagueController blagueController = BlagueController.getInstance();
		
	private JPanel panelGeneral;
	private JPanel panelBas;
	private JTextArea textArea;
	private JSlider panelSlider;
	private JLabel lblNote;
	private JButton buttonOk;
	private JLabel lblSlider;
	
	
	public EcranNoteBlague() {
		setTitle("Palais de la boutade");
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setSize(new Dimension(500, 450));
		setLocation(50, 50);
		
		add(getPanelGeneral(), BorderLayout.CENTER);

		
		//ligne 1 text Area
		addComponentToPanel(0, 0, 200, getTextArea(), panelGeneral );
			
		//ligne 2
		add(getPanelBas(),BorderLayout.SOUTH);
		
		addComponentToPanel(1, 1, getLblNote(), panelBas);
		addComponentToPanel(1, 2, getPanelSlider(), panelBas);
		addComponentToPanel(1, 3, getButtonOk(), panelBas);
		addComponentToPanel(2, 1, getLblSlider(), panelBas);
		
		//METHODS
		AfficherBlague();
		
		//Listener
		blagueController.addListener(this);
	}

	//Methods
	@Override
	public void printBlagueActive() {
		textArea.setText(blagueController.getBlagueActive().getTxtBlague());
		
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
			panelSlider.setPaintTicks(true);
		    panelSlider.setPaintLabels(true); 
		    panelSlider.setMajorTickSpacing(1); 
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
			buttonOk.addActionListener( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					float note = panelSlider.getValue();
					Blague blagueActive = blagueController.getBlagueActive();
					blagueActive.setNote(note);
					try {
						blagueController.update(blagueActive);
					} catch (BLLException e1) {
						e1.printStackTrace();
					}
				}
			});
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
	public JLabel getLblSlider() {
		if (lblSlider == null) {
			lblSlider = new JLabel();
			
		}
		return lblSlider;
	}
	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
