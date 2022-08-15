package fr.eni.blagues.ihm.vue;

import javax.swing.SwingUtilities;

import fr.eni.blagues.bll.BLLException;

public class TestBlagues {

	public static void main(String[] args) {
SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {				
				try {
					EcranTop3 ecranTop3 = new EcranTop3();
				} catch (BLLException e) {
					e.printStackTrace();
				}
				EcranAccueil ecranAccueil = new EcranAccueil();
			}
		});

	}

}
