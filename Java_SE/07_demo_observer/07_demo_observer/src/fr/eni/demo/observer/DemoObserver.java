package fr.eni.demo.observer;

import javax.swing.SwingUtilities;

public class DemoObserver {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				ObjetObservable objetObservable = new ObjetObservable();
				
				Observateur1 obs1 = new Observateur1(objetObservable);
				Observateur2 obs2 = new Observateur2(objetObservable);
				Eliot eliot = new Eliot(objetObservable);
			}
		});
	}
}
