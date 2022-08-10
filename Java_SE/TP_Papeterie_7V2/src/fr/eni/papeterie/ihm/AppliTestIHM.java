package fr.eni.papeterie.ihm;

import javax.swing.SwingUtilities;

public class AppliTestIHM {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				EcranPapeterie ecran = new EcranPapeterie(PanelBoutons.getInstance());
				EcranCatalogue ecranCatalogue = new EcranCatalogue();
			}
		});
	}

}
