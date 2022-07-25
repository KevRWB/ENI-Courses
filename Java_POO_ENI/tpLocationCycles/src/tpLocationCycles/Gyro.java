package tpLocationCycles;

import java.time.LocalDate;

public abstract class Gyro extends Cycle {
	
	protected int autonomie;

	public Gyro(String marque, String modele, LocalDate dateAchat, int prixLoc, int autonomie) {
		super(marque, modele, dateAchat, prixLoc);
		this.autonomie = autonomie;
	}

	

}
