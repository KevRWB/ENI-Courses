package fr.eni.demo.swing;

import javax.swing.SwingUtilities;

public class DemoSwing {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				EcranStagiaire ecranStagiaire = new EcranStagiaire();
			}
		});
	}

}
