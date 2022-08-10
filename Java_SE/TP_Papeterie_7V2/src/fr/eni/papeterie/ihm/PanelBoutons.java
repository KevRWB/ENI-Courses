package fr.eni.papeterie.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBoutons {
	private JPanel panelBoutons;

	private JButton btnPrecedent;
	private JButton btnNouveau;
	private JButton btnEnregistrer;
	private JButton btnSupprimer;
	private JButton btnSuivant;
	
	//SINGLETON
	private static PanelBoutons instance;
	
	private PanelBoutons() { }
	
	public static PanelBoutons getInstance() {
		if(instance == null) {
			instance = new PanelBoutons();
		}
		return instance;
	}
	//FIN SINGLETON
	
	//Pattern observer
	public interface Listeners{
		void precedent();
		void suivant();
		void nouveau();
		void enregistrer();
		void supprimer();
		
	}	
	//Liste objets observabes
	private List<Listeners> observateursList = new ArrayList<>();
	
	public void ajouterObservateur(Listeners listener) {
		observateursList.add(listener);
	}
	
	//unregisterListener ou unregister ou unbind
	public void retirerObservateur(Listeners listener) {
		observateursList.remove(listener);
	}
	
	//notify ou notifyAll
	public void prevenirClickPrecedent() {
		for(Listeners listener : observateursList) {
			listener.precedent();
		}
	}
	public void prevenirClickSuivant() {
		for(Listeners listener : observateursList) {
			listener.suivant();
		}
	}
	public void prevenirClickDelete() {
		for(Listeners listener : observateursList) {
			listener.supprimer();
		}
	}
	public void prevenirClickNew() {
		for(Listeners listener : observateursList) {
			listener.nouveau();
		}
	}
	public void prevenirClickSave() {
		for(Listeners listener : observateursList) {
			listener.enregistrer();
		}
	}
	
	// FIN PATTERN OBSERVER
	public JPanel getPanelBoutons() {
		if (panelBoutons == null) {
			panelBoutons = new JPanel();

			panelBoutons.add(getBtnPrecedent());
			panelBoutons.add(getBtnNouveau());
			panelBoutons.add(getBtnEnregistrer());
			panelBoutons.add(getBtnSupprimer());
			panelBoutons.add(getBtnSuivant());

		}
		return panelBoutons;
	}
	
	private JButton getBtnPrecedent() {
		if (btnPrecedent == null) {
			ImageIcon icon = new ImageIcon(getClass().getResource("images/Back24.gif"));
			btnPrecedent = new JButton(icon);
			//version lambda
			btnPrecedent.addActionListener(e -> {
				prevenirClickPrecedent();
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
					prevenirClickNew();
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
					prevenirClickSave();
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
					prevenirClickDelete();
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
					prevenirClickSuivant();
				}
			});
		}
		return btnSuivant;
	}
	
}

