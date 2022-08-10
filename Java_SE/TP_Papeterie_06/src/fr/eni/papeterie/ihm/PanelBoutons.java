package fr.eni.papeterie.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBoutons {
	
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
	
	public void ajouterObservateur(Listeners EcranPapeterie) {
		observateursList.add(EcranPapeterie);
	}
	
	//unregisterListener ou unregister ou unbind
	public void retirerObservateur(Listeners EcranPapeterie) {
		observateursList.remove(EcranPapeterie);
	}
	
	//notify ou notifyAll
	public void prevenirTousLesObservateurs() {
		for(Listeners o : observateursList) {
		
		}
	}
	// FIN PATTERN OBSERVER
	
	
	private JPanel panelBoutons;

	
	
	private JButton getBtnPrecedent() {
		if (btnPrecedent == null) {
			ImageIcon icon = new ImageIcon(getClass().getResource("images/Back24.gif"));
			btnPrecedent = new JButton(icon);
			//version lambda
			btnPrecedent.addActionListener(e -> {
				precedent();
			});
		}
		return btnPrecedent;
	}

	private void precedent() {
		// TODO Auto-generated method stub
		
	}

	private JButton getBtnNouveau() {
		if (btnNouveau == null) {
			ImageIcon icon = new ImageIcon(getClass().getResource("images/New24.gif"));
			btnNouveau = new JButton(icon);
			btnNouveau.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					nouveau();
				}

				private void nouveau() {
					// TODO Auto-generated method stub
					
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
					enregistrer();
				}

				private void enregistrer() {
					// TODO Auto-generated method stub
					
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
					supprimer();
				}

				private void supprimer() {
					// TODO Auto-generated method stub
					
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
					suivant();
				}

				private void suivant() {
					// TODO Auto-generated method stub
					
				}
			});
		}
		return btnSuivant;
	}
}
