package fr.eni.demo.observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Eliot extends JFrame {

	private ObjetObservable objetObservable;
	
	private JButton btnClic;

	public Eliot(ObjetObservable objetObservable) {
		this.objetObservable = objetObservable;
		
		setSize(200, 200);
		setLocation(400, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().add(getBtnClic());
	}

	public JButton getBtnClic() {
		if(btnClic == null) {
			btnClic = new JButton("Clic");
			btnClic.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					objetObservable.setMaValeur("Clic");
					System.out.println(objetObservable);
				}
			});
		}
		return btnClic;
	}

	

}
