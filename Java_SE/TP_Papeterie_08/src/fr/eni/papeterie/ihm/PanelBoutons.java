package fr.eni.papeterie.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBoutons extends JPanel {

	private static PanelBoutons instance;
	
	public static PanelBoutons getInstance() {
		if(instance == null) {
			instance = new PanelBoutons();
		}
		return instance;
	}
	
	private List<IPanelBoutonsObserver> observateurs;
	
	private JButton btnPrecedent;
	private JButton btnNouveau;
	private JButton btnEnregistrer;
	private JButton btnSupprimer;
	private JButton btnSuivant;
	
	private PanelBoutons() {
		observateurs = new ArrayList<IPanelBoutonsObserver>();
		
		add(getBtnPrecedent());
		add(getBtnNouveau());
		add(getBtnEnregistrer());
		add(getBtnSupprimer());
		add(getBtnSuivant());
	}
	
	private JButton getBtnPrecedent() {
		if (btnPrecedent == null) {
			ImageIcon icon = new ImageIcon(getClass().getResource("images/Back24.gif"));
			btnPrecedent = new JButton(icon);
			//version lambda
			btnPrecedent.addActionListener(e -> {
				for(IPanelBoutonsObserver obs : observateurs) {
					obs.precedent();
				}
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
					for(IPanelBoutonsObserver obs : observateurs) {
						obs.nouveau();
					}
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
					for(IPanelBoutonsObserver obs : observateurs) {
						obs.enregistrer();
					}
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
					for(IPanelBoutonsObserver obs : observateurs) {
						obs.supprimer();
					}
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
					for(IPanelBoutonsObserver obs : observateurs) {
						obs.suivant();
					}
				}
			});
		}
		return btnSuivant;
	}
	
	public void addPanelBoutonObserver(IPanelBoutonsObserver obs) {
		observateurs.add(obs);
	}
}



