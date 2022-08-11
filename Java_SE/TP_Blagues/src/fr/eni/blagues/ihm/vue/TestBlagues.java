package fr.eni.blagues.ihm.vue;

import javax.swing.SwingUtilities;

public class TestBlagues {

	public static void main(String[] args) {
SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {				
				EcranNoteBlague ecranNoteBlague = new EcranNoteBlague();
				EcranAddBlague ecranAddBlague = new EcranAddBlague();
			}
		});

	}

}
