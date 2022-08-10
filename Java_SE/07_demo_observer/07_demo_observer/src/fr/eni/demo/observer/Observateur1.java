package fr.eni.demo.observer;

import javax.swing.JFrame;
import javax.swing.JLabel;

import fr.eni.demo.observer.ObjetObservable.ObservateurObjetObservable;

public class Observateur1 extends JFrame {// implements ObservateurObjetObservable {

	private ObjetObservable objetObservable;
	
	private JLabel lblValeur;
	
	public Observateur1(ObjetObservable objetObservable) {
		this.objetObservable = objetObservable;
		//la fenêtre s'inscrit auprès de l'objet observé pour pour l'observer
		//this.objetObservable.ajouterObservateur(this);
		this.objetObservable.ajouterObservateur(new ObservateurObjetObservable() {
			
			@Override
			public void maValeurAChange() {
				getLblValeur().setText(objetObservable.getMaValeur());
			}
		});
		
		setSize(200, 200);
		setLocation(100, 100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().add(getLblValeur());
	}

	public JLabel getLblValeur() {
		if(lblValeur == null) {
			lblValeur = new JLabel(objetObservable.getMaValeur());
		}
		return lblValeur;
	}

//	@Override
//	public void maValeurAChange() {
//		getLblValeur().setText(objetObservable.getMaValeur());
//	}
}
