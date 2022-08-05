package fr.eni.demo.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonOkListenerExterne implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Clic sur le bouton OK listener classe externe");
	}

}
