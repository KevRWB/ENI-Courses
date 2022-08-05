package fr.eni.papeterie.ihm.controller;

import javax.swing.SwingUtilities;

import fr.eni.papeterie.ihm.vue.EcranPapeterie;

public class PapeterieController {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				EcranPapeterie ecranPapeterie = new EcranPapeterie();
			}
		});

	}

}
