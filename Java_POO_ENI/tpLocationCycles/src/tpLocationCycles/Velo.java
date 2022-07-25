package tpLocationCycles;

import java.time.LocalDate;

public class Velo extends Cycle implements ChangementVitesse {

	public Velo(String marque, String modele, LocalDate dateAchat, int prixLoc) {
		super(marque, modele, dateAchat, prixLoc);
	}

	@Override
	public void chgtVitesses() {
		

	}

}
