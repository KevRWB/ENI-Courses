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
import javax.swing.JPanel;

import fr.eni.blagues.ihm.controller.BlagueController;

public class EcranAccueil extends JFrame {

	private static final long serialVersionUID = 1L;

	private BlagueController blagueController = BlagueController.getInstance();
	private JPanel panelGeneral;
	private JButton buttonFaitMoiRire;
	private JButton buttonAjouter;

	public EcranAccueil() {
		setTitle("Antichambre du rire");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(450, 300));
		setLocation(500, 500);

		add(getPanelGeneral());
		addComponentToPanel(0, 0, getButtonFaitMoiRire(), panelGeneral);
		addComponentToPanel(1, 0, getButtonAjouter(), panelGeneral);

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

	public JPanel getPanelGeneral() {
		if (panelGeneral == null) {
			panelGeneral = new JPanel(new GridBagLayout());
		}
		return panelGeneral;
	}

	public JButton getButtonFaitMoiRire() {
		if (buttonFaitMoiRire == null) {	
			buttonFaitMoiRire = new JButton(" Fait moi rire ");
			buttonFaitMoiRire.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					blagueController.openEcranNoteBlague();
				}
			});
		}
		return buttonFaitMoiRire;
	}

	public JButton getButtonAjouter() {
		if (buttonAjouter == null) {	
			buttonAjouter = new JButton(" Ajouter ");
			buttonAjouter.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					blagueController.openEcranAddBlague();
				}
			});
		}
		return buttonAjouter;
	}
	
}
